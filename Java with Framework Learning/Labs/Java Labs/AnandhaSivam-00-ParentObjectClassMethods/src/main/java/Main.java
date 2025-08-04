/* 
 * There is no need to update the logic in this file. The main method only exists so you can see the output of your logic without running the tests
 * 
 * Please go to "SampleClass.java" to complete the lab. 
 * 
 */
public class Main {
    public static void main(String[] args) {
        SampleClass sc1 = new SampleClass();
        SampleClass sc2 = new SampleClass();
        sc1.a = 3;
        sc2.a = 3;
        sc1.b = true;
        sc2.b = true;

        System.out.println("equals...");
        System.out.println("Comparing 'SampleClass' object 1 with the same values in 'SampleClass' object 2\nExpected Output: true\nActual Output: " + sc1.equals(sc2));
        sc1.a = 2;
        sc2.a = 7;
        sc1.b = true;
        sc2.b = false;
        System.out.println("\nComparing 'SampleClass' object 1 with the different values in 'SampleClass' object 2\nExpected Output: false\nActual Output: " + sc1.equals(sc2));
    
    
        System.out.println("\ntoString...");
        System.out.println("Expected: overridden toString method should display both variables in the class.");
        System.out.println("Actual: " + sc1.toString());
    }
}
