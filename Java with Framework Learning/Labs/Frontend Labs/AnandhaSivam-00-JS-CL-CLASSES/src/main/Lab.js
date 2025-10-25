let container = document.getElementById("container");
let onButton = document.getElementById("onBulb");
let offButton = document.getElementById("offBulb");
let counter = 0;
onButton.onclick = ()=>{createBulb(true)};
offButton.onclick = ()=>{createBulb(false)};
function createBulb(state){
    counter++;
    let bulb = new Lightbulb(state);
    let title = document.createElement('h2');
    title.innerText = "Lightbulb "+counter
    let text = document.createElement('p');
    text.innerText = bulb.getDescription();
    container.appendChild(title);
    container.appendChild(text);
}

class Lightbulb {
    /**
     * This is the constructor for the Lightbulb class. When a lightbulb is created (as it is in the start of the 
     * createBulb function), this special method is called, which provides every Lightbulb with an initial field
     * known as 'state'. afterwards, the state of any individual lightbulb may be accessed from either outside of
     * the object, or within the object, using 'this.state.'
     */
    constructor(state){
        this.state = state;
    }
    /**
     * A getter & setter for 'state' are provided here to demonstrate the syntax of writing methods accessing the 
     * fields of a class the 'this' keyword. Naturally, the behavior of any particular lightbulb will be determined
     * at runtime, depending on the state assigned.
     */
    getState(){
        return this.state;
    }
    setState(state){
        this.state = state;
    }
    /**
     * Now, let's create a new function named 'getDescription' that returns varying text depending on the value of 'state'. 
     * If 'state' is true,  then the bulb will be considered 'on'. If 'state' is false, then the bulb will be considered 
     * 'off'. The function should then return "The bulb is on" or "The bulb is off" depending on whether the bulb is on or 
     * off.
     * 
     * TODO: Create a function named 'getDescription' that returns "The bulb is on" or "The bulb is off", depending on
     * whether 'state' is true or false.
     */
    getDescription() {
        if(this.state) {
            return "The bulb is on";
        }
        else {
            return "The bulb is off";
        }
    }
}
