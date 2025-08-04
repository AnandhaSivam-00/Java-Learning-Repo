public class Application {
    /**
     * This class contains a main method that allows you to manually test the MethodParameters lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.copy method should return the same value that was passed to it. This value will be printed here.
     */
    public static void main(String[] args) {
        System.out.println("The Lab.copy method should return the same value that was passed to it.");
        Lab parrot = new Lab();

        System.out.println("Here's what Lab.copy returns when provided the value \"repeat after me\"");
        String val1 = "repeat after me";
        String output1 = parrot.copy(val1);
        System.out.println(output1);

        System.out.println("Here's what Lab.copy returns when provided the value \"hello\"");
        String val2 = "hello";
        String output2 = parrot.copy(val2);
        System.out.println(output2);
    }
}
