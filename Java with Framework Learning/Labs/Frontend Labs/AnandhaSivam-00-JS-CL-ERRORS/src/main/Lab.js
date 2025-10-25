/**
 * Don't touch this code - it is essential to the lab, check your instructions below.
 */
let errorButton = document.getElementById("errorButton");
let noErrorButton = document.getElementById("noErrorButton");
let monitor = document.getElementById("monitor");
errorButton.onclick = causeError;
noErrorButton.onclick = noError;
function causeError(){
    let errorCallback = () => {
        throw new Error('Im causing an erroa and you should catch it in couldCauseError().');
    };
    couldCauseError(errorCallback)
}
function noError(){
    let friendlyCallback = () => {
        //I don't do anything, so I won't throw an error.
    };
    couldCauseError(friendlyCallback)
}
/**
 * Just like other high-level languages, JavaScript features exceptions and exception handling. Exceptions (which
 * are often also referred to as Errors within the context of JavaScript) represent unintended and unpredictable 
 * events, such as issues with HTTP requests. JavaScript will continue to attempt running code when an exception is
 * encountered, but it will print out the error stack trace in the browser's console. You can catch exceptions using
 * a try/catch block, which, like other languages, will cease to run code in the 'try' block and instead run the
 * code in the 'catch' block when an exception occurs. For instance, that could look like this:
 * 
 * try{
 *      //dangerous code! this will throw an exception carrying the message "sample exception"
 *      throw new Error("sample error");
 * }catch(error){
 *      //when some exception occurs, it may be helpful to send it to the console for the developer
 *      console.log(error);
 * }
 * 
 * In this case, the line callback() may or may not represent an error-causing function, so JavaScript might throw an 
 * error when this line executes. JavaScript will still continue to run other code when a function throws an error. 
 * Even though JavaScript won't outright crash, a try/catch statement is needed to provide behavior to recover the site
 * after an unexpected event (for instance, providing an informative message to the user when a video stream has been 
 * interrupted.)
 * 
 * TODO: use a try/catch block to catch the error thrown by the nonsense line.
 */
function couldCauseError(callback) {
    // START THE TRY BLOCK HERE
    try {
        monitor.innerText = "The button was clicked. This text should only be displayed on the site if an exception is "+
        "never thrown, as the second message should only replace this one when the try block executes.";
        callback();
    }
    catch(error) {
        monitor.innerText = "This text should be displayed only in the event of a an error, as it should be placed within " +
        "a try block. If you did intend to cause an error and see this text, you have succeeded.";
    }
}
