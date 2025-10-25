let opening = document.getElementById("opening");
let theRest = document.getElementById("theRest");

/*
A callback function is simply a function passed as an argument to be called at a later time. Often this follows a pattern of
passing callback functionB() as a parameter to functionA() so that when functionA() is complete it will call FunctionB(). 
Below are several callback functions, each of which adds a bit of text to the HTML page, waits 2 seconds, then calls another 
callback function. 

setTimeout() is a global function which takes in a callback function and an amount of milliseconds to wait before calling it.
setTimeout(callback, 5000); will wait 5 seconds before invoking the function called "callback". Note that when we pass a 
callback function like this, we don't include a parameter list with parentheses '()'. We are passing a reference to the
function, not invoking it.

TODO: Your goal is to have the page render Hamlet's famous speech from Shakespeare's play. If you aren't sure how that goes 
simply research "Hamlet's famous speech". Replace references to "placeholder" with the correct callbacks so that we assemble
the first line, then finally the rest of the speech. Note that one of the callbacks below contains 30 lines, that should come 
last.
*/

// This is an IIFE, "Immediately Invoked Function Expression" a function which is called as soon as it is defined. 
// Start here, this will call itself when the page loads.
(function start() {
    setTimeout(toBe, 1000);
})();

// Callback function 1
function friendsRomansCountrymen() {
    opening.innerText += 'Friends, Romans, Countrymen, ';
    setTimeout(placeholder, 1000);
}

// Callback function 2
function toBe() {
    opening.textContent += 'To be, ';
    setTimeout(orNotToBe, 1000);
}

// Callback function 3
function thatIsTheQuestion() {
    opening.textContent += 'that is the question: ';
    setTimeout(finishSpeech, 1000);
}

// Callback function 4
function myKingdomForAHorse() {
    opening.innerText += 'My kingdom for a horse! ';
    setTimeout(placeholder, 1000);
}

// Callback function 5
function orNotToBe() {
    opening.textContent += 'or not to be, ';
    setTimeout(thatIsTheQuestion, 1000);
}

// Callback function 6
function placeholder() {
    console.log('This placeholder function does nothing. ');
}

// Callback function 7
function lendMeYourEars() {
    opening.innerText += 'lend me your ears. ';
    setTimeout(placeholder, 1000);
}

// Callback function 8
function aHorse() {
    opening.innerText += 'A horse! ';
    setTimeout(placeholder, 1000);
}

// Callback function 9
function finishSpeech() {
    theRest.innerText += `Whether 'tis nobler in the mind to suffer
    The slings and arrows of outrageous fortune,
    Or to take arms against a sea of troubles
    And by opposing end them. To die—to sleep,
    No more; and by a sleep to say we end
    The heart-ache and the thousand natural shocks
    That flesh is heir to: 'tis a consummation
    Devoutly to be wish'd. To die, to sleep;
    To sleep, perchance to dream—ay, there's the rub:
    For in that sleep of death what dreams may come,
    When we have shuffled off this mortal coil,
    Must give us pause—there's the respect
    That makes calamity of so long life.
    For who would bear the whips and scorns of time,
    Th'oppressor's wrong, the proud man's contumely,
    The pangs of dispriz'd love, the law's delay,
    The insolence of office, and the spurns
    That patient merit of th'unworthy takes,
    When he himself might his quietus make
    With a bare bodkin? Who would fardels bear,
    To grunt and sweat under a weary life,
    But that the dread of something after death,
    The undiscovere'd country, from whose bourn
    No traveller returns, puzzles the will,
    And makes us rather bear those ills we have
    Than fly to others that we know not of?
    Thus conscience doth make cowards of us all,
    And thus the native hue of resolution
    Is sicklied o'er with the pale cast of thought,
    And enterprises of great pith and moment
    With this regard their currents turn awry
    And lose the name of action.`;
}
