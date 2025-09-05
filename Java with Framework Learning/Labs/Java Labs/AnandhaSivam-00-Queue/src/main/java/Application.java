import java.util.Deque;

public class Application {
    /**
     * This class contains a main method that allows you to manually test the Queue lab.
     * No changes you make here affect the test case results. You must still run & pass the test cases.
     * All implementation code should be written in the Lab class.
     *
     * The Lab methods must perform Queue operations.
     */
    public static void main(String[] args) {
        Lab queueLab = new Lab();
        System.out.println("Was the queue properly instantiated? this will print '[]' if yes, null if no");
        Deque<String> myQueue = queueLab.createQueue();
        System.out.println(myQueue);

        System.out.println("Can we add 'item 1' to the back of the queue? Now the values are:");
        queueLab.addToEndOfQueue(myQueue, "item 1");
        System.out.println(myQueue);

        System.out.println("Can we add 'item 2' to the back of the queue? Now the values are:");
        queueLab.addToEndOfQueue(myQueue, "item 2");
        System.out.println(myQueue);

        System.out.println("Can we remove an item from the front of the queue? Now the values are:");
        queueLab.removeFromStartOfQueue(myQueue);
        System.out.println(myQueue);
    }
}
