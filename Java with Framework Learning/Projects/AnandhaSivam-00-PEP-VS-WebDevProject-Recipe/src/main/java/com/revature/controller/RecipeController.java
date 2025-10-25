package com.revature.controller;

import com.revature.model.Chef;
import com.revature.model.Recipe;
import com.revature.service.AuthenticationService;
import com.revature.service.RecipeService;
import com.revature.util.Page;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


 // NOTE: This file is part of the backend implementation. No changes are required.


/**
 * The RecipeController class provides RESTful endpoints for managing recipes.
 * It interacts with the RecipeService to fetch, create, update, and delete recipes.
 */
public class RecipeController {

    /** A service that handles recipe-related operations. */
    private RecipeService recipeService;
    /** A service that handles authentication-related operations. */
    private AuthenticationService authService;

    /**
     * Constructor that initializes the RecipeController with the provided RecipeService.
     * 
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public RecipeController(RecipeService recipeService, AuthenticationService authService) {
        this.recipeService = recipeService;
        this.authService = authService;
    }

    /**
     * Handler for fetching all recipes. Supports pagination, sorting, and filtering by recipe name or ingredient.
     * 
     * Responds with a 200 OK status and the list of recipes, or 404 Not Found with a result of "No recipes found".
     *
     * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Handler fetchAllRecipes = ctx -> {
        String term = getParamAsClassOrElse(ctx, "term", String.class, null);

		if (ctx.queryParam("page") != null) {

			int page = getParamAsClassOrElse(ctx, "page", Integer.class, 1);
			int pageSize = getParamAsClassOrElse(ctx, "pageSize", Integer.class, 10);
			String sortBy = getParamAsClassOrElse(ctx, "sortBy", String.class, "id");
			String sortDirection = getParamAsClassOrElse(ctx, "sortDirection", String.class, "asc");

			Page<Recipe> recipePage = recipeService.searchRecipes(term, page, pageSize, sortBy, sortDirection);

            
			ctx.json(recipePage);

		} else {

			String ingredient = ctx.queryParam("ingredient");
            String recipeName = ctx.queryParam("name");

            List<Recipe> recipes = new ArrayList<>();
            if(ingredient == null && recipeName == null) {
                recipes = recipeService.searchRecipes(null);
            }
            else if(ingredient == null && recipeName != null) {
                recipes = recipeService.searchRecipes(recipeName);
            }
            if(recipes.isEmpty()) {
                ctx.status(404);
                ctx.result("No recipes found");
            }
            else {
                ctx.status(200);
                ctx.json(recipes);
            }
		}
    };

    /**
     * Handler for fetching a recipe by its ID.
     * 
     * If successful, responds with a 200 status code and the recipe as the response body.
     * 
     * If unsuccessful, responds with a 404 status code and a result of "Recipe not found".
     * 
     * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Handler fetchRecipeById = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Optional<Recipe> recipe = recipeService.findRecipe(id);
        if (recipe.isPresent()) {
            ctx.json(recipe.get());
            ctx.status(200);
        } else {
            ctx.status(404).result("Recipe not found");
        }
    };

    /**
     * Handler for creating a new recipe. Requires authentication via an authorization token. 
     * 
     * If successful, responds with a 201 Created status.
     * If unauthorized, responds with a 401 Unauthorized status.	 
     * 
     * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Handler createRecipe = ctx -> {
        Chef chef = authService.getChefFromSessionToken(ctx.header("Authorization").split(" ")[1]);
        if (chef == null) {
			ctx.status(401);
		} else {

			Recipe recipe = ctx.bodyAsClass(Recipe.class);

			recipe.setId(0);
			
			recipe.setAuthor(chef);
			recipeService.saveRecipe(recipe);

			ctx.status(201);

		}
    };

    /**
     * Handler for deleting a recipe by its ID.
     * 
     * If successful, responds with a 200 status and result of "Recipe deleted successfully."
     * 
     * Otherwise, responds with a 404 status and a result of "Recipe not found."
     * 
     * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Handler deleteRecipe = ctx -> {
        try {
            // Parse the recipe ID from the path parameter
            int id = Integer.parseInt(ctx.pathParam("id"));
            
            // Attempt to delete the recipe
            boolean deleted = recipeService.deleteRecipe(id);
    
            // Handle the result of the deletion
            if (deleted) {
                ctx.status(200).result("Recipe deleted successfully.");
            } else {
                ctx.status(404).result("Recipe not found.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid ID format
            ctx.status(400).result("Invalid recipe ID format.");
        } catch (Exception e) {
            // Handle unexpected exceptions
            ctx.status(500).result("An error occurred while deleting the recipe.");
        }
    };
    
    /**
     * Handler for updating a recipe by its ID.
     * 
     * If successful, responds with a 200 status code and the updated recipe as the response body.
     * 
     * If unsuccessfuly, responds with a 404 status code and a result of "Recipe not found."
     * 	 
     * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public Handler updateRecipe = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Recipe recipe = ctx.bodyAsClass(Recipe.class);
    
        Optional<Recipe> existingRecipe = recipeService.findRecipe(id);
        if (!existingRecipe.isPresent()) {
            ctx.status(404).result("Recipe not found.");
            return;
        }
    
        recipe.setId(id);
        recipeService.saveRecipe(recipe);
        ctx.status(200).json(recipe);
    };
    
    /**
     * A helper method to retrieve a query parameter from the context as a specific class type, or return a default value if the query parameter is not present.
    /**
     * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required by candidates.
     */

    private <T> T getParamAsClassOrElse(Context ctx, String queryParam, Class<T> clazz, T defaultValue) {
        String paramValue = ctx.queryParam(queryParam);
        if (paramValue != null) {
            if (clazz == Integer.class) {
                return clazz.cast(Integer.valueOf(paramValue));
            } else if (clazz == Boolean.class) {
                return clazz.cast(Boolean.valueOf(paramValue));
            } else {
                return clazz.cast(paramValue);
            }
        }
        return defaultValue;
    }

    /**
     * Configure the routes for recipe operations.
     *
	 * (FOR REFERENCE) This method is part of the backend logic.
     * No modifications or implementations are required.
     */
    public void configureRoutes(Javalin app) {
        app.get("/recipes", fetchAllRecipes);
        app.get("/recipes/{id}", fetchRecipeById);
        app.post("/recipes", createRecipe);
        app.put("/recipes/{id}", updateRecipe);
        app.delete("/recipes/{id}", deleteRecipe);
    }
}
