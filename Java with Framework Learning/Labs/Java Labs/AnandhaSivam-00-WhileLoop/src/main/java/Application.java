public class Application {
    /**
     * This class contains a main method that allows you to manually test the While loop lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.whileExample lab will get the sum of all numbers from 1 to some number >1. All code required to
     * calculate this is provided in the while loop lab documentation.
     */
    public static void main(String[] args) {
        Lab loop = new Lab();
        System.out.println("According to the lab code, the sum of all numbers from 1 to 6, not including 6, is ");
        int result = loop.whileExample(6);
        System.out.println(result);
        System.out.println("It should be 15.");
    }
}
