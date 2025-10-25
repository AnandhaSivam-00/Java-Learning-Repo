/**
 * This script defines the CRUD operations for Recipe objects in the Recipe Management Application.
 */

const BASE_URL = "http://localhost:8081"; // backend URL

let recipes = [];

// Wait for DOM to fully load before accessing elements
window.addEventListener("DOMContentLoaded", () => {

    /* 
     * TODO: Get references to various DOM elements
     * - Recipe name and instructions fields (add, update, delete)
     * - Recipe list container
     * - Admin link and logout button
     * - Search input
    */
   const addRecipeName = document.getElementById("add-recipe-name-input");
   const addRecipeInstruction = document.getElementById("add-recipe-instructions-input");
   const addRecipeSubmitButton = document.getElementById("add-recipe-submit-input");

   const updateRecipeName = document.getElementById("update-recipe-name-input");
   const updateRecipeInstruction = document.getElementById("update-recipe-instructions-input");
   const updateRecipeSubmitButton = document.getElementById("update-recipe-submit-input");

   const deleteRecipeName = document.getElementById("delete-recipe-name-input");
   const deleteRecipeSubmitButton = document.getElementById("delete-recipe-submit-input");

   const searchInput = document.getElementById("search-input");
   const searchRecipeButton = document.getElementById("search-button");
   const listContainer = document.getElementById("recipe-list");
   const adminLink = document.getElementById("admin-link");
   const logoutButton = document.getElementById("logout-button");

    /*
     * TODO: Show logout button if auth-token exists in sessionStorage
     */
    if(sessionStorage.getItem("auth-token")) {
        logoutButton.style.display = "block";
    }

    /*
     * TODO: Show admin link if is-admin flag in sessionStorage is "true"
     */
    if(sessionStorage.getItem("is-admin") === "true") {
        adminLink.style.display = "block";
    }

    /*
     * TODO: Attach event handlers
     * - Add recipe button → addRecipe()
     * - Update recipe button → updateRecipe()
     * - Delete recipe button → deleteRecipe()
     * - Search button → searchRecipes()
     * - Logout button → processLogout()
     */
    addRecipeSubmitButton.addEventListener("click", addRecipe);
    updateRecipeSubmitButton.addEventListener("click", updateRecipe);
    deleteRecipeSubmitButton.addEventListener("click", deleteRecipe);
    searchRecipeButton.addEventListener("click", searchRecipes);
    logoutButton.addEventListener("click", processLogout);

    /*
     * TODO: On page load, call getRecipes() to populate the list
     */
    getRecipes()


    /**
     * TODO: Search Recipes Function
     * - Read search term from input field
     * - Send GET request with name query param
     * - Update the recipe list using refreshRecipeList()
     * - Handle fetch errors and alert user
     */
    async function searchRecipes() {
        // Implement search logic here
        
        try {
            const searchText = searchInput.value;
            const requestOptions = {
                method: "GET",
                mode: "cors",
                cache: "no-cache",
                credentials: "same-origin",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${sessionStorage.getItem("auth-token")}`,
                    "Access-Control-Allow-Origin": "*",
                    "Access-Control-Allow-Headers": "*"
                },
                redirect: "follow",
                referrerPolicy: "no-referrer"
            };

            const response = await fetch(`${BASE_URL}/recipes?name=${searchText}`, requestOptions);

            if(response.status === 200) {
                recipes = await response.json();
                refreshRecipeList();
            }
            else if(response.status === 401) {
                // alert("Unauthorized");
                throw new Error("Unauthorized");
            }
            else {
                throw new Error("Error occurred during fetching recipes");
            }
        }
        catch(error) {
            console.error(error);
            alert(error);
        }
    }

    /**
     * TODO: Add Recipe Function
     * - Get values from add form inputs
     * - Validate both name and instructions
     * - Send POST request to /recipes
     * - Use Bearer token from sessionStorage
     * - On success: clear inputs, fetch latest recipes, refresh the list
     */
    async function addRecipe() {
        // Implement add logic here
        const requestBody = {
            name: addRecipeName.value.trim(),
            instructions: addRecipeInstruction.value.trim(),
        };

        if(!requestBody.name || !requestBody.instructions) {
            // alert("Recipe name and instructions cannot be empty");
            return;
        }

        try {
            const requestOptions = {
                method: "POST",
                mode: "cors",
                cache: "no-cache",
                credentials: "same-origin",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${sessionStorage.getItem("auth-token")}`, 
                    "Access-Control-Allow-Origin": "*",
                    "Access-Control-Allow-Headers": "*"
                },
                redirect: "follow",
                referrerPolicy: "no-referrer",
                body: JSON.stringify(requestBody)
            }
            const response = await fetch(`${BASE_URL}/recipes`, requestOptions);

            if(response.status === 201) {
                addRecipeName.value = "";
                addRecipeInstruction.value = "";

                getRecipes();
            }
            else if(response.status === 401) {
                // alert("Unauthorized");
                throw new Error("Unauthorized");
            }
            else {
                throw new Error("Error occurred during adding a recipe");
            }
        } 
        catch(error) {
            console.error(error);
            alert(error);   
        }
    }

    /**
     * TODO: Update Recipe Function
     * - Get values from update form inputs
     * - Validate both name and updated instructions
     * - Fetch current recipes to locate the recipe by name
     * - Send PUT request to update it by ID
     * - On success: clear inputs, fetch latest recipes, refresh the list
     */
    async function updateRecipe() {
        // Implement update logic here
        const requestBody = {
            name: updateRecipeName.value.trim(),
            instructions: updateRecipeInstruction.value.trim(),
        };

        if(!requestBody.name || !requestBody.instructions) {
            // alert("Recipe name and updated instructions cannot be empty");
            return;
        }

        try {
            const recipe = recipes.find(recipe => recipe.name === requestBody.name);
            if(!recipe) {
                alert("Recipe not found");
                throw new Error("Recipe not found");
            }
            const requestOptions = {
                method: "PUT",
                mode: "cors",
                cache: "no-cache",
                credentials: "same-origin",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${sessionStorage.getItem("auth-token")}`,
                    "Access-Control-Allow-Origin": "*",
                    "Access-Control-Allow-Headers": "*"
                },
                redirect: "follow",
                referrerPolicy: "no-referrer",
                body: JSON.stringify(requestBody)
            }

            const response = await fetch(`${BASE_URL}/recipes/${recipe.id}`, requestOptions);

            if(response.status === 200) {
                console.log("Recipe updated successfully");
                updateRecipeName.value = "";
                updateRecipeInstruction.value = "";
                getRecipes();
            }
            else if(response.status === 401) {
                // alert("Unauthorized");
                throw new Error("Unauthorized");
            }
            else {
                throw new Error("Error occurred during updating a recipe");
            }
        }
        catch(error) {
            console.error(error);
            alert(error);
        }
    }

    /**
     * TODO: Delete Recipe Function
     * - Get recipe name from delete input
     * - Find matching recipe in list to get its ID
     * - Send DELETE request using recipe ID
     * - On success: refresh the list
     */
    async function deleteRecipe() {
        // Implement delete logic here
        try {
            const requestOptions = {
                method: "DELETE",
                mode: "cors",
                cache: "no-cache",
                credentials: "same-origin",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${sessionStorage.getItem("auth-token")}`,
                    "Access-Control-Allow-Origin": "*",
                    "Access-Control-Allow-Headers": "*"
                }
            }
            const deleteText = deleteRecipeName.value.trim();
            if(!deleteText) {
                throw new Error("Recipe name cannot be empty"); 
            }
            const recipe = recipes.find(recipe => recipe.name === deleteText);
            if(!recipe) {
                throw new Error("Recipe not found"); 
            }  

            const response = await fetch(`${BASE_URL}/recipes/${recipe.id}`, requestOptions);

            if(response.status === 200) {
                // alert("Recipe deleted successfully");
                console.log("Recipe deleted successfully");
                deleteRecipeName.value = "";
                getRecipes();
            }
            else if(response.status === 401) {
                // alert("Unauthorized");
                throw new Error("Unauthorized");
            }
            else {
                throw new Error("Error occurred during deleting a recipe");
            }

        }
        catch(error) {
            console.error(error);
            alert(error);
        }
    }

    /**
     * TODO: Get Recipes Function
     * - Fetch all recipes from backend
     * - Store in recipes array
     * - Call refreshRecipeList() to display
     */
    async function getRecipes() {
        // Implement get logic here
        
        try {
            const requestOptions = {
                method: "GET",
                mode: "cors",
                cache: "no-cache",
                credentials: "same-origin",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${sessionStorage.getItem("auth-token")}`, 
                    "Access-Control-Allow-Origin": "*",
                    "Access-Control-Allow-Headers": "*"
                }
            }

            const response = await fetch(`${BASE_URL}/recipes`, requestOptions);

            if(response.status === 200) {
                recipes = await response.json();
                refreshRecipeList();
            }
            else if(response.status === 401) {
                // alert("Unauthorized");
                throw new Error("Unauthorized");
            }
            else {
                throw new Error("Error occurred during fetching recipes");
            }
        }
        catch(error) {
            console.error(error);
            alert(error);
        }
    }

    /**
     * TODO: Refresh Recipe List Function
     * - Clear current list in DOM
     * - Create <li> elements for each recipe with name + instructions
     * - Append to list container
     */
    function refreshRecipeList() {
        // Implement refresh logic here
        listContainer.innerHTML = "";
        recipes.forEach((recipe) => {
            const listItem = document.createElement("li");
            listItem.innerText = `${recipe.name}: ${recipe.instructions}`;
            listContainer.appendChild(listItem);
        })
    }

    /**
     * TODO: Logout Function
     * - Send POST request to /logout
     * - Use Bearer token from sessionStorage
     * - On success: clear sessionStorage and redirect to login
     * - On failure: alert the user
     */
    async function processLogout() {
        // Implement logout logic here
        
        try {
            const requestOptions = {
                method: "POST",
                mode: "cors",
                cache: "no-cache",
                credentials: "same-origin",
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${sessionStorage.getItem("auth-token")}`, 
                    "Access-Control-Allow-Origin": "*",
                    "Access-Control-Allow-Headers": "*"
                }
            }

            const response = await fetch(`${BASE_URL}/logout`, requestOptions);

            if(response.status === 200) {
                sessionStorage.removeItem("auth-token");
                sessionStorage.removeItem("is-admin");
                window.location.href = "../login/login-page.html";
            }
            else {
                throw new Error("Error occured during logout");
            }
        }
        catch(error) {
            console.error(error);
            alert(error);
        }
    }

});
