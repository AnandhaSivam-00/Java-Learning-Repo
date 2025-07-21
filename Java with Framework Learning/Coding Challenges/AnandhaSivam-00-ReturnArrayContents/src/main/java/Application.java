public class Application {
    /**
     * This class contains a main method that allows you to manually test the HardcodedLogin challenge functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.arrayToString method should return all of the values in an array as a String: eg, {1, 2, 3}
     * should be formatted as "1 2 3"
     */
    public static void main(String[] args) {
        Lab arrayContents = new Lab();
        int[] arr = {4, 5, 6, 7};
        System.out.println("Here is what the lab currently returns from the array {4, 5, 6, 7} - should be 4 5 6 7");
        System.out.println(arrayContents.arrayToString(arr));
    }
}
