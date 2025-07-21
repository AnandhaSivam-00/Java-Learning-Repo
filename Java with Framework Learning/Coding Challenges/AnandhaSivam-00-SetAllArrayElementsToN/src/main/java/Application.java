import java.util.Arrays;

public class Application {
    /**
     * This class contains a main method that allows you to manually test the setAllArrayElementsToN challenge.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.set method should set all the elements of an Array to some number.
     */
    public static void main(String[] args) {
        Lab setAll = new Lab();
        int[] arr = {5, 6, 7, 8};
        System.out.println("After setting all of the elements of {5, 6, 7, 8} to 2, the elements should be {2, 2, 2, 2}:");
        setAll.set(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
