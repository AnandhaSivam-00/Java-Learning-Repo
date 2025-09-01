/* 
 * There is no need to update the logic in this file. The main method only exists so you can see the output of your logic without running the tests
 * 
 * Please go to "GenericExample.java" to complete the lab. 
 * 
 */

public class Main {
    public static void main(String[] args) {
        GenericExercise<Integer> geInt = new GenericExercise<>();
        System.out.println("Datatype Integer...");
        System.out.println("Setting value 3 to variable 'data'.");
        geInt.loadGenericItem(3);

        System.out.println("calling 'returnGenericItem' method.");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + geInt.returnGenericItem());


        GenericExercise<String> geString = new GenericExercise<>();
        System.out.println("\n\nDatatype String...");
        System.out.println("Setting value 'Revature' to variable 'data'.");
        geString.loadGenericItem("Revature");

        System.out.println("calling 'returnGenericItem' method.");
        System.out.println("Expected Output: 'Revature'");
        System.out.println("Actual Output: " + geString.returnGenericItem());


        
    }
}
