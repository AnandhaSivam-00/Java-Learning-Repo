public class Application {
    /**
     * This class contains a main method that allows you to manually test the Exception lab.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.mustThrow method should throw an exception.
     */
    public static void main(String[] args) throws Exception {
        Lab thrower = new Lab();
        System.out.println("The lab code should throw an exception, causing a stack trace to be printed to console here:");
        thrower.mustThrow();
        System.out.println("\nIf this line was printed to console, then throwing an exception was unsuccessful.");
    }
}
