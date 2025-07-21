
public class Application {
    /**
     * This class contains a main method that allows you to manually test the Hello World lab functionality.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab.sayHello method should produce a value, "Hello, World!", which this class should be able to print
     * when you run the main method.
     */
    public static void main(String[] args) {
        System.out.println("This program will print out whatever is returned by the Lab.sayHello method.");
        System.out.println("The current lab output: ");

        Lab hello = new Lab();
        String output = hello.sayHello();

        System.out.println(output);
    }
}
