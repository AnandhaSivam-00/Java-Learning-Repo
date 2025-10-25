package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.util.ConnectionUtil;
import com.revature.util.Page;
import com.revature.util.PageOptions;
import com.revature.model.Ingredient;

/**
 * The IngredientDAO class handles the CRUD operations for Ingredient objects.
 * It provides methods for creating, retrieving, updating, and deleting
 * Ingredient records from the database.
 * 
 * This class relies on the ConnectionUtil class for database connectivity and
 * also supports searching and paginating through Ingredient records.
 */

public class IngredientDAO {

    /** A utility class used for establishing connections to the database. */
    @SuppressWarnings("unused")
    private ConnectionUtil connectionUtil;

    /**
     * Constructs an IngredientDAO with the specified ConnectionUtil for database
     * connectivity.
     * 
     * TODO: Finish the implementation so that this class's instance variables are
     * initialized accordingly.
     * 
     * @param connectionUtil the utility used to connect to the database
     */
    public IngredientDAO(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    /**
     * TODO: Retrieves an Ingredient record by its unique identifier.
     *
     * @param id the unique identifier of the Ingredient to retrieve.
     * @return the Ingredient object with the specified id.
     */
    public Ingredient getIngredientById(int id) {
        Connection conn = connectionUtil.getConnection();
        try {
            String sqlQuery = "SELECT * FROM INGREDIENT WHERE id = ?";
            PreparedStatement prepStat = conn.prepareStatement(sqlQuery);
            prepStat.setInt(1, id);

            ResultSet rs = prepStat.executeQuery();
            if(rs.next()) {
                return new Ingredient(rs.getInt("id"), rs.getString("name"));
            }
        } 
        catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    /**
     * TODO: Creates a new Ingredient record in the database.
     *
     * @param ingredient the Ingredient object to be created.
     * @return the unique identifier of the created Ingredient.
     */
    public int createIngredient(Ingredient ingredient) {
        Connection conn = connectionUtil.getConnection();

        try {
            String sqlQuery = "INSERT INTO INGREDIENT(name) VALUES(?)";
            PreparedStatement prepStat = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            prepStat.setString(1, ingredient.getName());
            prepStat.executeUpdate();

            ResultSet rs = prepStat.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
        } 
        catch(SQLException e) {
            System.out.println(e);
        }

        return 0;
    }

    /**
     * TODO: Deletes an ingredient record from the database, including references in
     * related tables.
     *
     * @param ingredient the Ingredient object to be deleted.
     */
    public void deleteIngredient(Ingredient ingredient) {
        Connection conn = connectionUtil.getConnection();

        try {
            String sqlQuery = "DELETE FROM INGREDIENT WHERE id = ?";
            PreparedStatement prepStat = conn.prepareStatement(sqlQuery);
            prepStat.setInt(1, ingredient.getId());
            prepStat.executeUpdate();
        } 
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * TODO: Updates an existing Ingredient record in the database.
     *
     * @param ingredient the Ingredient object containing updated information.
     */
    public void updateIngredient(Ingredient ingredient) {
        Connection conn = connectionUtil.getConnection();

        try {
            String sqlQuery = "UPDATE INGREDIENT SET name = ? WHERE id = ?";
            PreparedStatement prepStat = conn.prepareStatement(sqlQuery);
            prepStat.setString(1, ingredient.getName());
            prepStat.setInt(2, ingredient.getId());
            prepStat.executeUpdate();
        } 
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * TODO: Retrieves all ingredient records from the database.
     *
     * @return a list of all Ingredient objects.
     */
    public List<Ingredient> getAllIngredients() {
        Connection conn = connectionUtil.getConnection();
        List<Ingredient> ingredients = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM INGREDIENT ORDER BY id";
            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);

            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                ingredients.add(new Ingredient(rs.getInt("id"), rs.getString("name")));
            }

            return ingredients;
        } 
        catch(SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * TODO: Retrieves all ingredient records from the database with pagination
     * options.
     *
     * @param pageOptions options for pagination and sorting.
     * @return a Page of Ingredient objects containing the retrieved ingredients.
     */
    public Page<Ingredient> getAllIngredients(PageOptions pageOptions) {
        Connection conn = connectionUtil.getConnection();

        try {
            String orderBy = pageOptions.getSortBy() != null ? pageOptions.getSortBy() : "id";
            String orderDirection = pageOptions.getSortDirection() != null ? pageOptions.getSortDirection() : "ASC";

            String sqlQuery = "SELECT * FROM INGREDIENT ORDER BY " + orderBy + " " + orderDirection;
            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);

            ResultSet rs = prepStmt.executeQuery();
            return pageResults(rs, pageOptions);
        } 
        catch(SQLException e) {
            System.out.println(e);
        }
        return new Page<>();
    }

    /**
     * TODO: Searches for Ingredient records by a search term in the name.
     *
     * @param term the search term to filter Ingredient names.
     * @return a list of Ingredient objects that match the search term.
     */
    public List<Ingredient> searchIngredients(String term) {
        Connection conn = connectionUtil.getConnection();
        List<Ingredient> ingredients = new ArrayList<>();

        try {
            String sqlQuery = "SELECT * FROM INGREDIENT WHERE LOWER(name) LIKE LOWER(?) ORDER BY id";
            PreparedStatement prepStat = conn.prepareStatement(sqlQuery);
            prepStat.setString(1, "%" + term + "%");
            ResultSet rs = prepStat.executeQuery();
            ingredients = mapRows(rs);
        } 
        catch (SQLException e) {
            System.out.println(e);
        }

        return ingredients;
    }

    /**
     * TODO: Searches for Ingredient records by a search term in the name with
     * pagination options.
     *
     * @param term        the search term to filter Ingredient names.
     * @param pageOptions options for pagination and sorting.
     * @return a Page of Ingredient objects containing the retrieved ingredients.
     */
    public Page<Ingredient> searchIngredients(String term, PageOptions pageOptions) {
        Connection conn = connectionUtil.getConnection();

        try {
            String orderBy = pageOptions.getSortBy() != null ? pageOptions.getSortBy() : "id";
            String sortDirection = pageOptions.getSortDirection() != null ? pageOptions.getSortDirection() : "ASC";

            String sqlQuery = "SELECT * FROM INGREDIENT WHERE LOWER(name) LIKE LOWER(?) ORDER BY " + orderBy + " "
                    + sortDirection;
            PreparedStatement prepStat = conn.prepareStatement(sqlQuery);
            prepStat.setString(1, "%" + term + "%");
            ResultSet rs = prepStat.executeQuery();

            return pageResults(rs, pageOptions);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return new Page<>();
    }

    // below are helper methods for your convenience

    /**
     * Maps a single row from the ResultSet to an Ingredient object.
     *
     * @param resultSet the ResultSet containing Ingredient data.
     * @return an Ingredient object representing the row.
     * @throws SQLException if an error occurs while accessing the ResultSet.
     */
    private Ingredient mapSingleRow(ResultSet resultSet) throws SQLException {
       return new Ingredient(resultSet.getInt("id"), resultSet.getString("name"));
    }

    /**
     * Maps multiple rows from the ResultSet to a list of Ingredient objects.
     *
     * @param resultSet the ResultSet containing Ingredient data.
     * @return a list of Ingredient objects.
     * @throws SQLException if an error occurs while accessing the ResultSet.
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
     * @param resultSet   the ResultSet containing Ingredient data.
     * @param pageOptions options for pagination and sorting.
     * @return a Page of Ingredient objects containing the paginated results.
     * @throws SQLException if an error occurs while accessing the ResultSet.
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
