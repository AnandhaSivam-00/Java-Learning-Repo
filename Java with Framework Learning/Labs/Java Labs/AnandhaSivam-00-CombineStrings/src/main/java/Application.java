public class Application {
    /**
     * This class contains a main method that allows you to manually test the CombineStrings lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.combine method should return the combination of two Strings. (eg "string1"+"string2"="string1string2")
     */
    public static void main(String[] args) {
        System.out.println("The Lab.combine method should combine two Strings together.");
        Lab cs = new Lab();

        System.out.println("Here's what Lab.combine returns when provided values \"abc\" and \"xyz\":");
        String p1val1 = "abc";
        String p1val2 = "xyz";
        String output1 = cs.combine(p1val1, p1val2);
        System.out.println(output1);

        System.out.println("Here's what Lab.combine returns when provided the value \"hello\" and \"world\":");
        String p2val1 = "hello";
        String p2val2 = "world";
        String output2 = cs.combine(p2val1, p2val2);
        System.out.println(output2);
    }
}
