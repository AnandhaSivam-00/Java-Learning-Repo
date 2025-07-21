public class Application {
    /**
     * This class contains a main method that allows you to manually test the BooleanOperators lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab methods should return the results of some boolean logic. The resulting values will be printed here.
     */
    public static void main(String[] args) {
        Lab booleanslab = new Lab();
        System.out.println("Consider the expression 'true IS true'.");
        System.out.println("Here's what Lab.returnBoolean returns when provided the value 'true' (should be 'true')");
        boolean result1 = booleanslab.returnBoolean(true);
        System.out.println(result1);

        System.out.println("Consider the expression 'false IS false'.");
        System.out.println("Here's what Lab.returnBoolean returns when provided the value 'false' (should be 'false')");
        boolean result2 = booleanslab.returnBoolean(false);
        System.out.println(result2);

        System.out.println("Consider the expression 'true IS NOT false'.");
        System.out.println("Here's what Lab.returnNot returns when provided the value 'true' (should be 'false')");
        boolean result3 = booleanslab.returnNot(true);
        System.out.println(result3);

        System.out.println("Consider the expression 'false IS NOT true'.");
        System.out.println("Here's what Lab.returnNot returns when provided the value 'false' (should be 'true')");
        boolean result4 = booleanslab.returnNot(false);
        System.out.println(result4);

        System.out.println("Consider the expression 'true AND true IS true'.");
        System.out.println("Here's what Lab.returnAnd returns when provided the values 'true', 'true' (should be 'true')");
        boolean result5 = booleanslab.returnAnd(true, true);
        System.out.println(result5);

        System.out.println("Consider the expression 'true AND false IS false'.");
        System.out.println("Here's what Lab.returnAnd returns when provided the values 'true', 'false' (should be 'false')");
        boolean result6 = booleanslab.returnAnd(true, false);
        System.out.println(result6);

        System.out.println("Consider the expression 'true OR true IS true'.");
        System.out.println("Here's what Lab.returnAnd returns when provided the values 'true', 'true' (should be 'true')");
        boolean result7 = booleanslab.returnOr(true, true);
        System.out.println(result7);

        System.out.println("Consider the expression 'true OR false IS true'.");
        System.out.println("Here's what Lab.returnAnd returns when provided the values 'true', 'false' (should be 'true')");
        boolean result8 = booleanslab.returnOr(true, false);
        System.out.println(result8);

        System.out.println("Consider the expression 'false OR false IS false'.");
        System.out.println("Here's what Lab.returnAnd returns when provided the values 'false', 'false' (should be 'false')");
        boolean result9 = booleanslab.returnOr(false, false);
        System.out.println(result9);
    }
}
