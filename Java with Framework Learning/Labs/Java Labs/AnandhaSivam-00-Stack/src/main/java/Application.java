import java.util.Deque;

public class Application {
    /**
     * This class contains a main method that allows you to manually test the Stack lab.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab methods should perform Stack operations.
     */
    public static void main(String[] args) {
        Lab stackLab = new Lab();
        System.out.println("Was the set properly instantiated? this will print '[]' if yes, null if no");
        Deque<String> myStack = stackLab.createNewStack();
        System.out.println(myStack);

        System.out.println("Can we add 'item 1' to the top of the stack? Now the values are:");
        stackLab.addToTopOfStack(myStack, "item 1");
        System.out.println(myStack);

        System.out.println("Can we add 'item 2' to the top of the stack? Now the values are:");
        stackLab.addToTopOfStack(myStack, "item 2");
        System.out.println(myStack);

        System.out.println("Can we pop off the top of the stack? Now the values are:");
        stackLab.removeFromTopOfStack(myStack);
        System.out.println(myStack);
    }
}
