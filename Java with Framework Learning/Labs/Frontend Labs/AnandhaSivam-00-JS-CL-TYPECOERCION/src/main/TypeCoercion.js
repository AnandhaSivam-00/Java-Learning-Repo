/**
 * Recall that JavaScript is "loosely typed". This means that JavaScript does not require the developer
 * to explicitly define type. However, JavaScript still has types - Number, String, Boolean, Object, Symbol,
 * BigInt, Null, Undefined. JavaScript simply treats them all equally: when a comparison to, let's say, a Number and
 * a String happens, JavaScript will undergo implicit type coercion to temporarily turn them into equivalent data types. In that
 * case, the Number will be implicitly turned into a String just for the purpose of comparing the two.
 *
 * This lab will show off the difference between == and ===. == is an equality comparison that allows for implicit type coercion.
 * === is an equality comparison that will not allow for type coercion, so equivalent pieces of data that have different
 * datatypes will not be considered equal. Check out the two functions below. When you're done, continue to the second half
 * of the lab below to explore explicit type coercion.
 *
 * More info on type coersion here:
 * https://developer.mozilla.org/en-US/docs/Glossary/Type_coercion
 * More info on equality comparisons here:
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Equality_comparisons_and_sameness
 */

let a1 = document.getElementById("a1");
let a2 = document.getElementById("a2");
let a3 = document.getElementById("a3");
let a4 = document.getElementById("a4");
let a5 = document.getElementById("a5");
let a6 = document.getElementById("a6");
let a7 = document.getElementById("a7");
let a8 = document.getElementById("a8");

a1.innerText = doubleEquals(5, 6);
a2.innerText = doubleEquals(5, 5);
a3.innerText = doubleEquals(5, "5");
a4.innerText = doubleEquals("5", "5");
a5.innerText = tripleEquals(5, 6);
a6.innerText = tripleEquals(5, 5);
a7.innerText = tripleEquals(5, "5");
a8.innerText = tripleEquals("5", "5");

/**
 * TODO: use the == operator to return the boolean result of an equality comparison for a and b that does NOT also check
 * for equality between types (with type coercion)
 * Then, check out the results by opening the html document in your browser.
 * @param a
 * @param b
 */
function doubleEquals(a, b){
    //    code here
    if(a == b) {
        return true;
    }
    else {
        return false;
    }
}


/**
 * TODO: use the === operator to return the boolean result of an equality comparison for a and b that also checks for
 * equality between types (no type coercion)
 * Then, check out the results by opening the html document in your browser.
 * @param a
 * @param b
 */
function tripleEquals(a, b){
    //    code here
    if(a === b) {
        return true;
    }
    else {
        return false;
    }
}

/*  OPTIONAL PRACTICE: If you want more practice later, try using the "typeof" method in JS; this operator returns
    a string that represents what type of data it was given.
    
    Example:
        typeof(5);    
        typeof("5");
*/

/**
 * JavaScript allows for explicit type coercion as well. This means that a developer can change the type of a variable to another
 * type if the situation calls for it. Sometimes, this can be risky if not used correctly. Other times, it can be extremely
 * beneficial. JavaScript provides built-in functions to explicitly convert variables to other types.
 *
 * The functions Number(), String(), and Boolean() can be used to explicitly convert variables to these types. Your task is to
 * use these functions to convert the provided variables to different types.
 *
 * More info on explicit type coercion here:
 * https://developer.mozilla.org/en-US/docs/Glossary/Type_coercion
 */

let a9 = document.getElementById("a9");
let a10 = document.getElementById("a10");
let a11 = document.getElementById("a11");

a9.innerText = toString(5) + 6;
a10.innerText = toNumber("5") + 6;
a11.innerText = toBoolean(5) + 6;
a12.innerText = toBoolean(null) + 6;

 /**
  * TODO: Write a function to explicitly convert a variable to a String.
  * @param variable
  * @return String
  */
 function toString(a){
     //    code here
     return String(a);
 }

 /**
  * TODO: Write a function to explicitly convert a variable to a Number.
  * @param variable
  * @return Number
  */
 function toNumber(a){
     //    code here
     return Number(a);
 }

 /**
  * TODO: Write a function to explicitly convert a variable to a Boolean.
  * @param variable
  * @return Boolean
  */
 function toBoolean(a){
     //    code here
     return Boolean(a);
 }

 /*  OPTIONAL PRACTICE: For additional practice, try converting different types of variables to other types and observe the results.
     For example, what happens when you convert an object to a number? Or a boolean to a string? How about null to a boolean?
 */
