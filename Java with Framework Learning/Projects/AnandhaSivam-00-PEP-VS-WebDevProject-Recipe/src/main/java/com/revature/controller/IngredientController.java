
package com.revature.controller;

import com.revature.model.Ingredient;
import com.revature.service.IngredientService;
import com.revature.util.Page;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.Optional;


 // NOTE: This file is part of the backend implementation. No changes are required.


/**
 * The IngredientController class handles operations related to ingredients. It allows for creating, retrieving, updating, and deleting individual ingredients, as well as retrieving a list of all ingredients. 
 * 
 * The class interacts with the IngredientService to perform these operations.
 */

public class IngredientController {

    /**  A service that manages ingredient-related operations. */
    private IngredientService ingredientService;

    /**
     * Constructs an IngredientController with the specified IngredientService.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    /**
     * Retrieves a single ingredient by its ID.
     * If the ingredient exists, responds with a 200 OK status and the ingredient data.
     * If not found, responds with a 404 Not Found status.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void getIngredient(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Optional<Ingredient> ingredient = ingredientService.findIngredient(id);
        if (ingredient.isPresent()) {
            ctx.json(ingredient.get());
            ctx.status(200);
        } else {
            ctx.status(404);
        }
    }
     
    /**
     * Deletes an ingredient by its ID.
     * Responds with a 204 No Content status.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void deleteIngredient(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ingredientService.deleteIngredient(id);
        ctx.status(204);
    }

    /**
     * Updates an existing ingredient by its ID.
     * If the ingredient exists, updates it and responds with a 204 No Content status.
     * If not found, responds with a 404 Not Found status.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void updateIngredient(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Optional<Ingredient> ingredient = ingredientService.findIngredient(id);
        if(ingredient.isPresent()) {
            Ingredient updatedIngredient = ctx.bodyAsClass(Ingredient.class);
            ingredientService.saveIngredient(updatedIngredient);
            ctx.status(204);
        } else {
            ctx.status(404);
        }
    }

    /**
     * Creates a new ingredient.
     * Saves the ingredient and responds with a 201 Created status.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void createIngredient(Context ctx) {
        Ingredient ingredient = ctx.bodyAsClass(Ingredient.class);
        ingredientService.saveIngredient(ingredient);
        ctx.status(201);
    }

    /**
     * Retrieves a paginated list of ingredients, or all ingredients if no pagination parameters are provided.
     * 
     * If pagination parameters are included, returns ingredients based on page, page size, sorting, and filter term.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void getIngredients(Context ctx) {
       String term = getParamAsClassOrElse(ctx, "term", String.class, null);
        if(ctx.queryParam("page") != null) {
            int page = getParamAsClassOrElse(ctx, "page", Integer.class, 1);
            int pageSize = getParamAsClassOrElse(ctx, "pageSize", Integer.class, 10);
            String sortBy = getParamAsClassOrElse(ctx, "sortBy", String.class, "id");
            String sortDirection = getParamAsClassOrElse(ctx, "sortDirection", String.class, "asc");
            Page<Ingredient> ingredients = ingredientService.searchIngredients(term, page, pageSize, sortBy, sortDirection);
            ctx.json(ingredients);
            return;
        }
        ctx.json(ingredientService.searchIngredients(term));
    }

/**
     * This utility method is already implemented as part of the backend infrastructure.
	 
     * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     
 */

    private <T> T getParamAsClassOrElse(Context ctx, String queryParam, Class<T> clazz, T defaultValue) {
        if(ctx.queryParam(queryParam) != null) {
            return ctx.queryParamAsClass(queryParam, clazz).get();
        } else {
            return defaultValue;
        }
    }
    /**
     * Configure the routes for ingredient operations.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void configureRoutes(Javalin app) {
        app.get("/ingredients", this::getIngredients);
        app.get("/ingredients/{id}", this::getIngredient);
        app.post("/ingredients", this::createIngredient);
        app.put("/ingredients/{id}", this::updateIngredient);
        app.delete("/ingredients/{id}", this::deleteIngredient);
    }
}
