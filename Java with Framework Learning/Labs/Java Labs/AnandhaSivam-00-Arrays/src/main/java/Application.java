public class Application {
    /**
     * This class contains a main method that allows you to manually test the Arrays lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab methods should demonstrate some basic array manipulation functionality.
     */
    public static void main(String[] args) {
        Lab arrayslab = new Lab();
        int[] arr1 = {1,2,3,4};

        System.out.println("The length of the array {1, 2, 3, 4} is 4, and the lab produces this value as the length: ");
        int len = arrayslab.getLengthOfArray(arr1);
        System.out.println(len);

        System.out.println("In the array {1, 2, 3, 4}, the item with index 2 is 3, ");
        System.out.println("because arrays start counting indexes from 0.");
        System.out.println("The lab produces this value is the item of index 2:");
        int item = arrayslab.getNthElementOfArray(arr1, 2);
        System.out.println(item);

        System.out.println("In the array {1, 2, 3, 4}, the lab should be able to set the item at index 2 to 9.");
        System.out.println("Here are the current contents of the array: ");
        arrayslab.setNthElementOfArray(arr1, 2, 9);
        int item0 = arrayslab.getNthElementOfArray(arr1, 0);
        int item1 = arrayslab.getNthElementOfArray(arr1, 1);
        int item2 = arrayslab.getNthElementOfArray(arr1, 2);
        int item3 = arrayslab.getNthElementOfArray(arr1, 3);
        System.out.println("{"+item0+", "+item1+", "+item2+", "+item3+"}");

        System.out.println("The lab should be able to instantiate a new array of some size.");
        System.out.println("If the array hasn't been instantiated, then a NullPointerException will occur:");
        int[] arr2 = arrayslab.returnNewArraySizeN(4);
        int arr2len = arr2.length;
    }
}
