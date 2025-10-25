/**
 * This script defines the add, view, and delete operations for Ingredient objects in the Recipe Management Application.
 */

const BASE_URL = "http://localhost:8081"; // backend URL

let ingredients = [];

window.addEventListener("DOMContentLoaded", () => {
    /* 
    * TODO: Get references to various DOM elements
    * - addIngredientNameInput
    * - deleteIngredientNameInput
    * - ingredientListContainer
    * - searchInput (optional for future use)
    * - adminLink (if visible conditionally)
    */
    const addIngredientNameInput = document.getElementById("add-ingredient-name-input");
    const deleteIngredientNameInput = document.getElementById("delete-ingredient-name-input");
    const ingredientListContainer = document.getElementById("ingredient-list");
    const searchInput = document.getElementById("search-input");
    const adminLink = document.getElementById("admin-link");

    const addIngredientButton = document.getElementById("add-ingredient-submit-button");
    const deleteIngredientButton = document.getElementById("delete-ingredient-submit-button");  

    /* 
    * TODO: Attach 'onclick' events to:
    * - "add-ingredient-submit-button" → addIngredient()
    * - "delete-ingredient-submit-button" → deleteIngredient()
    */
    addIngredientButton.addEventListener("click", addIngredient);
    deleteIngredientButton.addEventListener("click", deleteIngredient);

    /*
    * TODO: Create an array to keep track of ingredients
    */

    /* 
    * TODO: On page load, call getIngredients()
    */
    getIngredients();


    /**
     * TODO: Add Ingredient Function
     * 
     * Requirements:
     * - Read and trim value from addIngredientNameInput
     * - Validate input is not empty
     * - Send POST request to /ingredients
     * - Include Authorization token from sessionStorage
     * - On success: clear input, call getIngredients() and refreshIngredientList()
     * - On failure: alert the user
     */
    async function addIngredient() {
        // Implement add ingredient logic here
        try {
            const ingredient = addIngredientNameInput.value.trim();

            if(!ingredient) {
                throw new Error("Ingredient name cannot be empty.");
            }

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
                body: JSON.stringify({ name: ingredient})
            };

            const response = await fetch(`${BASE_URL}/ingredients`, requestOptions);
            if(response.status === 201) {
                addIngredientNameInput.value = "";
                getIngredients();
            } 
            else {
                throw new Error("Failed to add ingredient.");
            }   
        }
        catch(error) {
            console.error(error);
            alert(error);
        }
    }


    /**
     * TODO: Get Ingredients Function
     * 
     * Requirements:
     * - Fetch all ingredients from backend
     * - Store result in `ingredients` array
     * - Call refreshIngredientList() to display them
     * - On error: alert the user
     */
    async function getIngredients() {
        // Implement get ingredients logic here
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
                },
                redirect: "follow",
                referrerPolicy: "no-referrer"
            };

            const response = await fetch(`${BASE_URL}/ingredients`, requestOptions);

            if(response.status === 200) {
                ingredients = await response.json();
                refreshIngredientList();
            }
            else {
                throw new Error("Failed to retrieve ingredients");
            }
        }
        catch(error) {
            console.error(error);
            alert(error);
        }
    }


    /**
     * TODO: Delete Ingredient Function
     * 
     * Requirements:
     * - Read and trim value from deleteIngredientNameInput
     * - Search ingredientListContainer's <li> elements for matching name
     * - Determine ID based on index (or other backend logic)
     * - Send DELETE request to /ingredients/{id}
     * - On success: call getIngredients() and refreshIngredientList(), clear input
     * - On failure or not found: alert the user
     */
    async function deleteIngredient() {
        // Implement delete ingredient logic here
        try {
            const ingredientName = deleteIngredientNameInput.value.trim();
            const ingredient = ingredients.find(ingredient => ingredient.name === ingredientName);

            if(!ingredient) {
                throw new Error("Ingredient not found");
            }

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
                },
                redirect: "follow",
                referrerPolicy: "no-referrer"
            }

            const response = await fetch(`${BASE_URL}/ingredients/${ingredient.id}`, requestOptions);

            if(response.status === 204) {
                deleteIngredientNameInput.value = "";
                getIngredients();
            }
            else {
                throw new Error("Failed to delete ingredient.");
            }
        }
        catch(error) {
            console.error(error);
            alert(error);
        }
    }


    /**
     * TODO: Refresh Ingredient List Function
     * 
     * Requirements:
     * - Clear ingredientListContainer
     * - Loop through `ingredients` array
     * - For each ingredient:
     *   - Create <li> and inner <p> with ingredient name
     *   - Append to container
     */
    function refreshIngredientList() {
        // Implement ingredient list rendering logic here
        ingredientListContainer.innerHTML = "";
        ingredients.forEach((ingredient) => {
            const ingredientListItem = document.createElement("li");
            ingredientListItem.innerText = ingredient.name;
            ingredientListContainer.appendChild(ingredientListItem);
        })
    }
    
});
