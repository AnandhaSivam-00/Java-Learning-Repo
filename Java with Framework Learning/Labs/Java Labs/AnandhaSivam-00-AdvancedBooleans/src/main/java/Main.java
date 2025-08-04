/* 
 * There is no need to update the logic in this file. The main method only exists so you can see the output of your logic without running the tests
 * 
 * Please go to "AdvancedBooleanLogic.java" to complete the lab. 
 * 
 */
public class Main {
    public static void main(String[] args) {
        AdvancedBooleanLogic abl = new AdvancedBooleanLogic();
        
        //NOTE: The values below will be incorrect until you update AdvancedBooleanLogic.java with the correct logic
        System.out.println("~~~~returnNotBoth()~~~~");
        System.out.println("Input: b1=true and b2=true   | Expected: false | Actual: " + abl.returnNotBoth(true, true));
        System.out.println("Input: b1=true and b2=false  | Expected: true  | Actual: " + abl.returnNotBoth(true, false));
        System.out.println("Input: b1=false and b2=true  | Expected: true  | Actual: " + abl.returnNotBoth(false, true));
        System.out.println("Input: b1=false and b2=false | Expected: true  | Actual: " + abl.returnNotBoth(false, false));

        System.out.println("\n~~~~returnExclusiveOr()~~~~");
        System.out.println("Input: b1=true and b2=true   | Expected: false | Actual: " + abl.returnExclusiveOr(true, true));
        System.out.println("Input: b1=true and b2=false  | Expected: true  | Actual: " + abl.returnExclusiveOr(true, false));
        System.out.println("Input: b1=false and b2=true  | Expected: true  | Actual: " + abl.returnExclusiveOr(false, true));
        System.out.println("Input: b1=false and b2=false | Expected: false | Actual: " + abl.returnExclusiveOr(false, false));

        System.out.println("\n~~~~returnNeitherNor()~~~~");
        System.out.println("Input: b1=true and b2=true   | Expected: false | Actual: " + abl.returnNeitherNor(true, true));
        System.out.println("Input: b1=true and b2=false  | Expected: false | Actual: " + abl.returnNeitherNor(true, false));
        System.out.println("Input: b1=false and b2=true  | Expected: false | Actual: " + abl.returnNeitherNor(false, true));
        System.out.println("Input: b1=false and b2=false | Expected: true  | Actual: " + abl.returnNeitherNor(false, false));
    }
}
