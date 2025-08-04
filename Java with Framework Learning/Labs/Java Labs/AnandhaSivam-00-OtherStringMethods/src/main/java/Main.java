/* 
 * There is no need to update the logic in this file. The main method only exists so you can see the output of your logic without running the tests
 * 
 * Please go to "OtherStringMethods.java" to complete the lab. 
 * 
 */

public class Main {

    public static void main(String[] args) {
        //NOTE: The values below will be incorrect until you update OtherStringMethods.java with the correct logic
        OtherStringMethods osm = new OtherStringMethods();
        String str = "Revature";

        

        //Substrings
        System.out.println("\nSubstrings...");
        System.out.println("Given the string value '" + str  + "'...");
        System.out.println("The substring between index 2 (inclusive) and 5 (exclusive) should return 'vat', Actual output: " + osm.partOfString(str, 2, 5));
        
        //Comparisons
        System.out.println("\nComparisons...");
        System.out.println("Comparing the string 'revature' to 'Revature', Expected Output: a positive number,  Actual output: " + osm.compareLexigraphically("revature", "Revature"));
        System.out.println("Comparing the string 'Revature' to 'revature', Expected Output: a negative number,  Actual output: " + osm.compareLexigraphically("Revature", "revature"));
        System.out.println("Comparing the string 'Revature' to 'Revature', Expected Output: 0,  Actual output: " + osm.compareLexigraphically(str, str));
        
        //Splitting string
        System.out.println("\nString splitting...");
        System.out.println("Splitting all the words in the sentence 'Software Development Lifecycle'\n\nExpected Output: ");
        System.out.println("Software\nDevelopment\nLifecycle\n\nActual Output: ");

        String words[] = osm.splitStringIntoMultipleStrings("Software Development Lifecycle", " ");
        if(words == null) {
            System.out.println("null");
        }else{
            for(String word : words){
                System.out.println(word);
            }
        }
        
        
    }
    
}
