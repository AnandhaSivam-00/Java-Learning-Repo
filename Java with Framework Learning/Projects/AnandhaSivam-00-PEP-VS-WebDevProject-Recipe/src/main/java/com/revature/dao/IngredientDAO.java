package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Ingredient;
import com.revature.util.ConnectionUtil;
import com.revature.util.Page;
import com.revature.util.PageOptions;


// NOTE: This file is part of the backend implementation. No changes are required.


/**
 * Data Access Object (DAO) for performing CRUD operations on Ingredient
 * entities. This class provides methods to create, read, update, and delete
 * Ingredient records in the database.
 */
public class IngredientDAO {

   /** A utility class used for establishing connections to the database. */
   @SuppressWarnings("unused")
   private ConnectionUtil connectionUtil;

   /**
    * Constructs an IngredientDAO with the specified ConnectionUtil for database connectivity.
    * 
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
    */
   public IngredientDAO(ConnectionUtil connectionUtil) {
       this.connectionUtil = connectionUtil;
   }


    /**
     * Retrieves an Ingredient record by its unique identifier.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Ingredient getIngredientById(int id) {
        String sql = "SELECT * FROM INGREDIENT WHERE ID = ?";
        try (Connection connection = connectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() ? mapSingleRow(resultSet) : null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Creates a new Ingredient record in the database.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public int createIngredient(Ingredient ingredient) {
        String sql = "INSERT INTO INGREDIENT (NAME) VALUES (?)";
        try (Connection connection = connectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, ingredient.getName());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                throw new RuntimeException("Unable to create ingredient");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    /**
     * Deletes an Ingredient record from the database, including references in
     * related tables.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void deleteIngredient(Ingredient ingredient) {
        String deleteRecipeIngredientSql = "DELETE FROM RECIPE_INGREDIENT WHERE INGREDIENT_ID = ?";
        String deleteIngredientSql = "DELETE FROM INGREDIENT WHERE ID = ?";
        Connection connection = connectionUtil.getConnection();
        try {
            connection.setAutoCommit(false); // Start transaction

            // Step 1: Delete references in the RECIPE_INGREDIENT table
            try (PreparedStatement ps = connection.prepareStatement(deleteRecipeIngredientSql)) {
                ps.setInt(1, ingredient.getId());
                ps.executeUpdate();
            }

            // Step 2: Delete the ingredient itself
            try (PreparedStatement ps = connection.prepareStatement(deleteIngredientSql)) {
                ps.setInt(1, ingredient.getId());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 0) {
                    throw new RuntimeException("No ingredient found with id: " + ingredient.getId());
                }
            }

            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            ex.printStackTrace();
        }
    }

    /**
     * Updates an existing Ingredient record in the database.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void updateIngredient(Ingredient ingredient) {
        String sql = "UPDATE INGREDIENT SET NAME = ? WHERE ID = ?";
        try (Connection connection = connectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ingredient.getName());
            statement.setInt(2, ingredient.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Retrieves all Ingredient records from the database.
     * 
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public List<Ingredient> getAllIngredients() {
        String sql = "SELECT * FROM INGREDIENT ORDER BY ID";
        try (Connection connection = connectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            return mapRows(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Retrieves all Ingredient records from the database with pagination options.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Page<Ingredient> getAllIngredients(PageOptions pageOptions) {
        String sql = String.format("SELECT * FROM ingredient ORDER BY %s %s", pageOptions.getSortBy(),
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
     * Searches for Ingredient records by a search term in the name.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public List<Ingredient> searchIngredients(String term) {
        String sql = "SELECT * FROM INGREDIENT WHERE NAME LIKE ? ORDER BY ID";
        try (Connection connection = connectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + term + "%");
            ResultSet resultSet = statement.executeQuery();
            return mapRows(resultSet);
        } catch (SQLException ex) {
            throw new RuntimeException("Unable to search ingredients", ex);
        }
    }

    /**
     * Searches for Ingredient records by a search term in the name with pagination options.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Page<Ingredient> searchIngredients(String term, PageOptions pageOptions) {
        String sql = String.format("SELECT * FROM ingredient WHERE name LIKE ? ORDER BY %s %s", pageOptions.getSortBy(),
                pageOptions.getSortDirection());
        try (Connection connection = connectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + term + "%");
            ResultSet resultSet = statement.executeQuery();
            return pageResults(resultSet, pageOptions);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to search ingredients by term", e);
        }
    }

    // below are helper methods for your convenience

    /**
     * Maps a single row from the ResultSet to an Ingredient object.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    private Ingredient mapSingleRow(ResultSet resultSet) throws SQLException {
        return new Ingredient(resultSet.getInt("ID"), resultSet.getString("NAME"));
    }

    /**
     * Maps multiple rows from the ResultSet to a list of Ingredient objects.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    private List<Ingredient> mapRows(ResultSet resultSet) throws SQLException {
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        while (resultSet.next()) {
            ingredients.add(mapSingleRow(resultSet));
        }
        return ingredients;
    }

    /**
     * Paginates the results of a ResultSet into a Page of Ingredient objects.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    private Page<Ingredient> pageResults(ResultSet resultSet, PageOptions pageOptions) throws SQLException {
        List<Ingredient> ingredients = mapRows(resultSet);
        int offset = (pageOptions.getPageNumber() - 1) * pageOptions.getPageSize();
        int limit = offset + pageOptions.getPageSize();
        List<Ingredient> subList = ingredients.subList(offset, limit);
        return new Page<>(pageOptions.getPageNumber(), pageOptions.getPageSize(),
                (int) Math.ceil(ingredients.size() / ((float) pageOptions.getPageSize())), ingredients.size(), subList);
    }
}