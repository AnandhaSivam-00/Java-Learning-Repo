let content = document.getElementById("content");
const user = returnUserObject("user1", "password123");

displayUserObject(user);



/**
 * TODO: this function should return a User Object.
 * 
 * L1-Objects in JavaScript look a bit like JSON (JSON is, of course, JavaScript object notation.)
 * For instance, they may follow the format:
 * 
 * {
 *     stringValue:"abc",
 *     intValue:123
 * }
 * 
 * You should return an Object that has the fields username & password, and leverage the two parameters
 * as the username & password values.
 * 
 */
function returnUserObject(inputUsername, inputPassword){
    //    code here
    const User = {
        username: inputUsername,
        password: inputPassword
    }

    return User;
}



/**
 * This function leverages a template literal to display a string containing variables and newlines without
 * the need for any string concatenation.
 * template literals were introduced in JavaScript version es6.
 * @param userObject a user object.
 */
function displayUserObject(userObject){
    if(content !== null){
        content.innerText = `username: ${userObject.username} 
                            password: ${userObject.password}`;
    }
}


/* OPTIONAL PRACTICE: If you want more practice later, look into how to dynamically update, add, and remove
    attributes of an object in JavaScript. */
