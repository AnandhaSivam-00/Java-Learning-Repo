public class Application {
    /**
     * This class contains a main method that allows you to manually test the Subtract challenge functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.subtract method should produce the sum of two decimal numbers (doubles).
     */
    public static void main(String[] args) {
        Lab subtract = new Lab();
        System.out.println("Currently, the lab produces the result of 3.1 - 0.2 as:");
        double result = subtract.sub(3.1,0.2);
        System.out.println(result);
    }
}
