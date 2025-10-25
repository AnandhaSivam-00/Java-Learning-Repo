package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.dao.RecipeDAO;
import com.revature.model.Recipe;
import com.revature.util.Page;
import com.revature.util.PageOptions;


// NOTE: This file is part of the backend implementation. No changes are required.


/**
 * The RecipeService class provides services related to Recipe objects,
 * including CRUD operations and search functionalities. It acts as an
 * intermediary between the data access layer and the
 * application logic, ensuring that all operations on Recipe objects
 * are handled consistently and efficiently.
 */
public class RecipeService {

    /** The data access object used for performing operations on Recipe entities. */
    private RecipeDAO recipeDAO;

    /**
     * Constructs a RecipeService with the specified RecipeDao.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public RecipeService(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    /**
     * Finds a Recipe by its unique identifier.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Optional<Recipe> findRecipe(int id) {
        return Optional.ofNullable(recipeDAO.getRecipeById(id));
    }

    /**
     * Saves a Recipe object to the data store. If the id is 0, create a new Recipe.
     * 
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void saveRecipe(Recipe recipe) {
        if (recipe.getId() == 0) {
            int id = recipeDAO.createRecipe(recipe);
            recipe.setId(id);
        } else {
            Recipe savedRecipe = recipeDAO.getRecipeById(recipe.getId());
            if (savedRecipe == null) {
                throw new IllegalArgumentException("Recipe with ID " + recipe.getId() + " not found.");
            }
            if (recipe.getInstructions() != null) {
                savedRecipe.setInstructions(recipe.getInstructions());
            }
            recipeDAO.updateRecipe(savedRecipe);
        }
    }
    
    /**
     * Searches for recipes with pagination and sorting options.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Page<Recipe> searchRecipes(String term, int page, int pageSize, String sortBy, String sortDirection) {
        PageOptions options = new PageOptions(page, pageSize, sortBy, sortDirection);
        if (term == null) {
            return recipeDAO.getAllRecipes(options);
        } else {
            return recipeDAO.searchRecipesByTerm(term, options);
        }
    }

    /**
     * Searches for recipes based on a search term.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public List<Recipe> searchRecipes(String term) {
        
        if (term == null) {
            return recipeDAO.getAllRecipes();
        } else {
            return recipeDAO.searchRecipesByTerm(term);
        }
    }

    /**
     * Deletes a Recipe by its unique identifier.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public boolean deleteRecipe(int id) {
        Recipe recipe = recipeDAO.getRecipeById(id);
        if (recipe != null) {
            recipeDAO.deleteRecipe(recipe);
            return true; // Deletion successful
        }
        return false; // Recipe not found
    }
    
}
