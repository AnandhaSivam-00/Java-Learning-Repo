public class Application {
    /**
     * This class contains a main method that allows you to manually test the Math lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.mathPow method should return the result of a exponential math equation, a^b, using the static Math.pow
     * method.
     */
    public static void main(String[] args) {
        Lab mlab = new Lab();
        System.out.println("The Math class should help you get the result of 2^3, which is 8. Current result:");
        double result = mlab.mathPow(2,3);
        System.out.println(result);
    }
}
