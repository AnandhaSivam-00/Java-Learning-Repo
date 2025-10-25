let image = document.getElementById("image");
let input = document.getElementById("input");
let button = document.getElementById("button");

button.onclick = setImageSrc;

/**
 * Notice above that we have already set references to the image, input, and button elements. Also, button has been given an "onclick" attribute
 * which references the function "setImageSrc()". Keep in mind that input elements have a property called "value" that stores their input.
 * 
 * TODO: Use the image and input references to set the "src" attribute on the image element to the current value of the input element.
 */
function setImageSrc() {
    // Write your code here...
    image.setAttribute("src", input.value);
}


/**
 * Did you notice that the variables at the top of the script were declared with 'let' instead of 'var'? That's
 * because JS actually has 3 ways to declare variables: var, let, const. Var doesn't have block scoping - meaning, when
 * a 'var' variable is declared within an if statement or for loop, it's actually accessible outside of its code block.
 * This was fixed in version JavaScript version ES6, when 'let' was introduced, which features block scoping. 'const'
 * is for unchangeable variables.
 *
 * We're going to be using 'let' from now on. 'var' is only relevant for very old browsers which are running old
 * versions of JavaScript.
 */
