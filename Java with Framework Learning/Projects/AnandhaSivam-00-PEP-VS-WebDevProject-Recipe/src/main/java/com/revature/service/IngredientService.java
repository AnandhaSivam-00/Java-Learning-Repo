package com.revature.service;

import java.util.List;
import java.util.Optional;

import com.revature.model.Ingredient;
import com.revature.dao.IngredientDAO;
import com.revature.util.Page;
import com.revature.util.PageOptions;


// NOTE: This file is part of the backend implementation. No changes are required.


/**
 * The IngredientService class provides business logic for operations related to Ingredient entities.
 * 
 * It interacts with the IngredientDAO to perform CRUD operations and search functionality.
 */
public class IngredientService {

    /** Data access object for Ingredient entities. */
    private IngredientDAO ingredientDAO;

    /**
     * Constructs an IngredientService with the specified IngredientDAO.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public IngredientService(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    /**
     * Finds an Ingredient by its unique identifier.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Optional<Ingredient> findIngredient(int id) {
        return Optional.ofNullable(ingredientDAO.getIngredientById(id));
    }

    /**
     * Saves an Ingredient entity. If the Ingredient's ID is zero, a new Ingredient is created and the `ingredient` parameter's ID is updated.
     * Otherwise, updates the existing Ingredient.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void saveIngredient(Ingredient ingredient) {
        if(ingredient.getId() == 0) {
            int id = ingredientDAO.createIngredient(ingredient);
            ingredient.setId(id);
        } else {
            ingredientDAO.updateIngredient(ingredient);
        }
    }

    /**
     * Deletes an Ingredient based on its unique identifier, if it exists.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void deleteIngredient(int id) {
        Ingredient ingredient = ingredientDAO.getIngredientById(id);
        if(ingredient != null) {
            ingredientDAO.deleteIngredient(ingredient);
        }
    }

    /**
     * Searches for Ingredients based on a search term.
     * If the term is null, retrieves all Ingredients.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public List<Ingredient> searchIngredients(String term) {
        if(term == null ) { 
            return ingredientDAO.getAllIngredients();
        } else {
            return ingredientDAO.searchIngredients(term);
        }
    }

    /**
     * Searches for Ingredients based on a search term with pagination and sorting options.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Page<Ingredient> searchIngredients(String term, int page, int pageSize, String sortBy, String sortDirection) {
        PageOptions pageOptions = new PageOptions(page, pageSize, sortBy, sortDirection);
        if(term == null) { 
            return ingredientDAO.getAllIngredients(pageOptions);
        } else {
            return ingredientDAO.searchIngredients(term, pageOptions);
        }
    }
}