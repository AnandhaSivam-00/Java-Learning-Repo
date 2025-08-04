public class Application {
    /**
     * This class contains a main method that allows you to manually test the Comparisons lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab methods like isEqual, notEqualTo, etc should produce true or false values depending on the numbers
     * provided.
     */
    public static void main(String[] args) {
        Lab comparisons = new Lab();

        System.out.println("Currently, isEqual produces the following value for '4 is equal to 4':");
        boolean result11 = comparisons.isEqual(4,4);
        System.out.println(result11);

        System.out.println("Currently, isEqual produces the following value for '2 is equal to 7':");
        boolean result12 = comparisons.isEqual(2,7);
        System.out.println(result12);

        System.out.println("Currently, greaterThan produces the following value for '5 is greater than 3':");
        boolean result21 = comparisons.greaterThan(5,3);
        System.out.println(result21);

        System.out.println("Currently, greaterThan produces the following value for '4 is greater than 9':");
        boolean result22 = comparisons.greaterThan(4,9);
        System.out.println(result22);

        System.out.println("Currently, lessThan produces the following value for '3 is less than 6':");
        boolean result31 = comparisons.lessThan(3,6);
        System.out.println(result31);

        System.out.println("Currently, lessThan produces the following value for '2 is less than 1':");
        boolean result32 = comparisons.lessThan(2,1);
        System.out.println(result32);

        System.out.println("Currently, notEqualTo produces the following value for '1 is not equal to 9':");
        boolean result41 = comparisons.notEqualTo(1,9);
        System.out.println(result41);

        System.out.println("Currently, notEqualTo produces the following value for '8 is not equal to 8':");
        boolean result42 = comparisons.notEqualTo(8,8);
        System.out.println(result42);
    }
}
