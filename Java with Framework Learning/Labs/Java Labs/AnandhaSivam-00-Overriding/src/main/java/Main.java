/* 
 * There is no need to update the logic in this file. The main method only exists so you can see the output of your logic without running the tests
 * 
 * Please go to "Shiba.java" to complete the lab. 
 * 
 * NOTE: Make sure you do NOT change the logic in the "Dog" class. The intent is for you to override the sound method within the "Shiba" class
 * 
 */

public class Main {
    public static void main(String[] args) {
        Shiba shiba = new Shiba();


        System.out.println("Expected output: Anything other than 'Woof' (because the 'sound' method is supposed to be overridden)");
        System.out.println("Actual Output: " + shiba.sound());

    }
}
