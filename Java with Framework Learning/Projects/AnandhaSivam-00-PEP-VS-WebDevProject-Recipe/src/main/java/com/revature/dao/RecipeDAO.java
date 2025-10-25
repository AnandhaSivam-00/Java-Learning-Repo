package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.revature.model.Chef;
import com.revature.model.Recipe;
import com.revature.model.RecipeIngredient;
import com.revature.util.ConnectionUtil;
import com.revature.util.Page;
import com.revature.util.PageOptions;


// NOTE: This file is part of the backend implementation. No changes are required.



/**
 * Data Access Object (DAO) for managing Recipe entities in the database.
 * This class provides methods for creating, reading, updating, and deleting
 * recipes,
 * as well as searching for recipes by various criteria.
 */
public class RecipeDAO {

	/**
	 * DAO for managing Chef entities, used for retrieving chef details associated
	 * with recipes.
	 */
	private ChefDAO chefDAO;
	/**
	 * DAO for managing Ingredient entities, used for retrieving ingredient details
	 * for recipes.
	 */
	private IngredientDAO ingredientDAO;
	/**
	 * Utility class for managing database connections, providing methods to obtain
	 * database connections.
	 */
	private ConnectionUtil connectionUtil;

	/**
	 * Constructs a RecipeDAO instance with specified ChefDAO and IngredientDAO.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public RecipeDAO(ChefDAO chefDAO, IngredientDAO ingredientDAO, ConnectionUtil connectionUtil) {
		this.chefDAO = chefDAO;
		this.ingredientDAO = ingredientDAO;
		this.connectionUtil = connectionUtil;
	}

	/**
	 * Retrieves all recipes from the database.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public List<Recipe> getAllRecipes() {

		try {
			Connection connection = connectionUtil.getConnection();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM RECIPE ORDER BY id";
			ResultSet resultSet = statement.executeQuery(sql);
			return mapRows(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Retrieves a paginated list of all recipes from the database based on the
	 * specified page options.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public Page<Recipe> getAllRecipes(PageOptions pageOptions) {
		String sql = String.format("SELECT * FROM RECIPE ORDER BY %s %s", pageOptions.getSortBy(),
				pageOptions.getSortDirection());
		try (Connection connection = connectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			return pageResults(resultSet, pageOptions);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Searches for recipes by a specified search term.
	 * 
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public List<Recipe> searchRecipesByTerm(String term) {
		String sql = "SELECT * FROM RECIPE WHERE name LIKE ?";
		try (Connection connection = connectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, "%" + term + "%");
			ResultSet resultSet = statement.executeQuery();
			return mapRows(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Searches for recipes by a specified ingredient.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public List<Recipe> searchRecipesByIngredient(String ingredient) {
		String sql = "SELECT r.id, r.name, r.instructions FROM recipe r JOIN recipe_ingredient ir ON r.id = ir.recipe_id JOIN ingredient i ON ir.ingredient_id = i.id WHERE i.name LIKE ?;";
		try (Connection connection = connectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, "%" + ingredient + "%");
			ResultSet resultSet = statement.executeQuery();
			return mapRows(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Searches for recipes by a specified search term and returns a paginated
	 * result.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public Page<Recipe> searchRecipesByTerm(String term, PageOptions pageOptions) {
		String sql = String.format("SELECT * FROM RECIPE WHERE name LIKE ? ORDER BY %s %s", pageOptions.getSortBy(),
				pageOptions.getSortDirection());
		try (Connection connection = connectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, "%" + term + "%");
			ResultSet resultSet = statement.executeQuery();
			return pageResults(resultSet, pageOptions);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Retrieves a recipe by its unique identifier.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public Recipe getRecipeById(int id) {
		String sql = "SELECT * FROM RECIPE WHERE id = ?";
		try (Connection connection = connectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				return mapSingleRow(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates a new recipe in the database and returns its generated unique
	 * identifier.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	public int createRecipe(Recipe recipe) {
		String sql = "INSERT INTO RECIPE (name, instructions, chef_id) VALUES (?, ?, ?)";
		int generatedId = 0;

		try (Connection conn = connectionUtil.getConnection();
				PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			statement.setString(1, recipe.getName());
			statement.setString(2, recipe.getInstructions());
			statement.setInt(3, recipe.getAuthor().getId());
			statement.executeUpdate();

			try (ResultSet rs = statement.getGeneratedKeys()) {
				if (rs.next()) {
					generatedId = rs.getInt(1); // Get generated ID
					System.out.println("Recipe added with ID: " + generatedId); // Logging
				}
			}
		} catch (SQLException e) {
			System.err.println("Error adding recipe: " + e.getMessage()); // Logging
			e.printStackTrace();
		}
	
		return generatedId;
	}

	/**
	 * Updates an existing recipe's instructions and chef_id in the database.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */

	public void updateRecipe(Recipe recipe) {
		if (recipe == null || recipe.getId() == 0) {
			throw new IllegalArgumentException("Invalid recipe provided for update.");
		}
		String sql = "UPDATE RECIPE SET instructions = ?, chef_id = ? WHERE id = ?";
		try (Connection connection = connectionUtil.getConnection();
			 PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, recipe.getInstructions());
			statement.setInt(2, recipe.getAuthor().getId());
			statement.setInt(3, recipe.getId());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 0) {
				throw new RuntimeException("No rows updated. Recipe ID may be invalid.");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error updating recipe in database", e);
		}
	}
	
	/**
	 * Deletes a recipe from the database, along with its associated ingredients.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */

	public void deleteRecipe(Recipe recipe) {
		String ingredientSql = "DELETE FROM RECIPE_INGREDIENT WHERE recipe_id = ?";
		String sql = "DELETE FROM RECIPE WHERE id = ?";
		try (Connection connection = connectionUtil.getConnection()) {
			connection.setAutoCommit(false);
			try (PreparedStatement ingredientStatement = connection.prepareStatement(ingredientSql);
				 PreparedStatement statement = connection.prepareStatement(sql)) {
				ingredientStatement.setInt(1, recipe.getId());
				ingredientStatement.executeUpdate();
				statement.setInt(1, recipe.getId());
				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted == 0) {
					throw new RuntimeException("Recipe not found for deletion: " + recipe.getId());
				}
				connection.commit();
			} catch (SQLException e) {
				connection.rollback(); // Roll back if there's an error
				throw new RuntimeException("Unable to delete recipe", e);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Unable to obtain connection", e);
		}
	}

	
	// below are two extra methods that we don't test for. Not provided in student boilerplate.
	/**
	 * Retrieves a list of ingredients associated with a specific recipe.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	@SuppressWarnings("unused")
	private List<RecipeIngredient> getIngredients(int id) {

		String sql = "SELECT ingredient_id, vol, unit FROM RECIPE_INGREDIENT WHERE recipe_id = ?";
		List<RecipeIngredient> ingredients = new LinkedList<RecipeIngredient>();
		try (Connection connection = connectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ingredients.add(new RecipeIngredient(ingredientDAO.getIngredientById(resultSet.getInt(1)),
						resultSet.getDouble(2), resultSet.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ingredients;
	}

	/**
	 * Saves the ingredients for a given recipe to the database.
	 * This method inserts each ingredient associated with the recipe into the
	 * RECIPE_INGREDIENT table, establishing a relationship between the recipe and
	 * its ingredients.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	@SuppressWarnings("unused")
	private void saveIngredients(Recipe recipe) {

		String sql = "INSERT INTO RECIPE_INGREDIENT (recipe_id, ingredient_id, vol, unit) VALUES (?,?,?,?)";
		for (RecipeIngredient i : recipe.getIngredients()) {
			try (Connection connection = connectionUtil.getConnection();
					PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				statement.setInt(1, recipe.getId());
				statement.setInt(2, i.getId());
				statement.setString(3, i.getName());
				statement.setString(4, i.getUnit());
				statement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// below are helper methods for your convenience
	
	/**
	 * Maps a single row from the ResultSet to a Recipe object.
	 * This method extracts the recipe details such as ID, name, instructions,
	 * and associated chef from the ResultSet and constructs a Recipe instance.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	private Recipe mapSingleRow(ResultSet set) throws SQLException {
		int id = set.getInt("id");
		String name = set.getString("name");
		String instructions = set.getString("instructions");
		Chef author = chefDAO.getChefById(set.getInt("chef_id"));
		return new Recipe(id, name, instructions, author);
	}

	/**
	 * Maps multiple rows from a ResultSet to a list of Recipe objects.
	 * This method iterates through the ResultSet and calls mapSingleRow
	 * for each row, adding the resulting Recipe objects to a list.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	private List<Recipe> mapRows(ResultSet set) throws SQLException {
		List<Recipe> recipes = new ArrayList<>();
		while (set.next()) {
			recipes.add(mapSingleRow(set));
		}
		return recipes;
	}

	/**
	 * Pages the results from a ResultSet into a Page object for the Recipe entity.
	 * This method processes the ResultSet to retrieve recipes, then slices the list
	 * based on the provided pagination options, and returns a Page object
	 * containing
	 * the paginated results.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	private Page<Recipe> pageResults(ResultSet set, PageOptions pageOptions) throws SQLException {
		List<Recipe> recipes = mapRows(set);
		int offset = (pageOptions.getPageNumber() - 1) * pageOptions.getPageSize();
		int limit = offset + pageOptions.getPageSize();
		List<Recipe> slicedList = sliceList(recipes, offset, limit);
		return new Page<>(pageOptions.getPageNumber(), pageOptions.getPageSize(),
				recipes.size() / pageOptions.getPageSize(), recipes.size(), slicedList);
	}

	/**
	 * Slices a list of Recipe objects from a specified start index to an end index.
	 * This method creates a sublist of the provided list, which can be used for
	 * pagination.
	 *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
	 */
	private List<Recipe> sliceList(List<Recipe> list, int start, int end) {
		List<Recipe> sliced = new ArrayList<>();
		for (int i = start; i < end; i++) {
			sliced.add(list.get(i));
		}
		return sliced;
	}
}