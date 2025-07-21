/* 
 * There is no need to update the logic in this file. The main method only exists so you can see the output of your logic without running the tests
 * 
 * Please go to "SampleClassC.java" to complete the lab. 
 * 
 */

public class Main {

    public static void main(String[] args) {
        //NOTE: The values below will be incorrect until you update SampleClassC.java with the correct logic
        SampleClassC sc1 = new SampleClassC();
        SampleClassC sc2 = new SampleClassC();

        //Comparisons
        System.out.println("\ncompareTo...");
        sc1.val = 10;
        sc2.val = 20;
        System.out.println("Comparing sc1 with value 10 to to sc2 with value 20, Expected Output: a negative value,  Actual output: " + sc1.compareTo(sc2));
        sc1.val = 20;
        sc2.val = 10;
        System.out.println("Comparing sc1 with value 20 to to sc2 with value 10, Expected Output: a positive value,  Actual output: " + sc1.compareTo(sc2));
        sc1.val = 10;
        sc2.val = 10;
        System.out.println("Comparing sc1 with value 10 to to sc2 with value 10, Expected Output: 0,  Actual output: " + sc1.compareTo(sc2));
        
        
    }
    
}