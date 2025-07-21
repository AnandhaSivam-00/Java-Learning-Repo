/* 
 * There is no need to update the logic in this file. The main method only exists so you can see the output of your logic without running the tests
 * 
 * Please go to "SimpleStringMethods.java" to complete the lab. 
 * 
 */
public class Main {
    public static void main(String[] args) {
        SimpleStringMethods ssm = new SimpleStringMethods();
        String str = "Revature";

        //NOTE: The values below will be incorrect until you update SimpleStringMethods.java with the correct logic
        System.out.println("Given that the string value is '" + str  + "'...");
        System.out.println("The length of the string is " + ssm.getStringLength(str));
        System.out.println("The character at index 2 is " + ssm.getCharacterAtIndex(str, 2));
        System.out.println("Character 'a' is at the index " + ssm.getIndexGivenCharacter(str, 'a'));
    }
}
