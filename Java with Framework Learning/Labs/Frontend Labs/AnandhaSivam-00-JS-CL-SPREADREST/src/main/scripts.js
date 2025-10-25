let employeeInfoElement = document.getElementById("employeeInfo");
let sumElement = document.getElementById("sum");

/**
 * Recall that the spread/rest operator (...) serves two purposes. First it "spreads", that is it breaks apart a collection like an array
 * into individual elements. Secondly it takes in the "rest", meaning that when used to modify a parameter, we take any number of remaining parameters
 * and combine them into an array. Using this operator in these ways will allow you to complete the exercise below.
 * 
 * There are several functions here, you will only need to make changes to the first two, submitEmployee() and sum(). 
 * 
 * For submitEmployee() you will need to make sure the call to renderEmployee() is properly invoked so that the employee profile is correctly rendered.
 * 
 * For sum() you will need to make sure the function can handle the parameters given to it, and use a for loop to sum them up.
 */


// TODO: Use the spread/rest operator so the function below properly invokes the renderEmployee() function.
function submitEmployee() {
    let employeeProfile = ['John', 'Smith', '89,000'];
    renderEmployee(...employeeProfile);
}


// TODO: Refactor the function below to take in any amount of numbers and render the sum on the page.
function sum(...nums) {
    let sumNumbers = 0;
    nums.forEach((value) => sumNumbers += value);

    sumElement.innerText = sumNumbers;
}

// This function takes in exactly three strings and renders that information on screen. You don't need to edit this function.
function renderEmployee(firstName, lastName, salary) {
    employeeInfoElement.innerText = 'Name: ' + lastName + ', ' + firstName + ' - $' + salary;
}

// This is an IIFE, a self-invoking function. As soon as this is declared, it runs. When the page loads, this will invoke submitEmployee() and sum().
(function run() {
    submitEmployee();
    sum(1,2,3,4,5);
})();
