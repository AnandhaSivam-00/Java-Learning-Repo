public class Application {
    /**
     * This class contains a main method that allows you to manually test the For Loop lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.returnNumbers method should return a String of all numbers between two numbers. All code needed to
     * produce such a result is included in the For Loop lab documentation.
     */
    public static void main(String[] args) {
        Lab eo = new Lab();
        System.out.println("According to the challenge code, 3 is (even/odd):");
        System.out.println(eo.decide(21));
        System.out.println("According to the challenge code, 4 is (even/odd):");
        System.out.println(eo.decide(20));
    }
}
