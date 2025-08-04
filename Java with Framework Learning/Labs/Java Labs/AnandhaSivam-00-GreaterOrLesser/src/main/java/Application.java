public class Application {
    /**
     * This class contains a main method that allows you to manually test the GreaterOrLesser challenge functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.greaterOrLesser method should produce the values "Greater", "Lesser" or "Equal" depending on two
     * provided values.
     */
    public static void main(String[] args) {
        Lab greaterOrLesser = new Lab();
        System.out.println("Currently, the lab produces this value when comparing 3 to 9: ");
        String result1 = greaterOrLesser.decide(3,9);
        System.out.println(result1);
        System.out.println("Currently, the lab produces this value when comparing 5 to 5: ");
        String result2 = greaterOrLesser.decide(5,5);
        System.out.println(result2);
        System.out.println("Currently, the lab produces this value when comparing 9 to 10: ");
        String result3 = greaterOrLesser.decide(9,10);
        System.out.println(result3);
    }
}
