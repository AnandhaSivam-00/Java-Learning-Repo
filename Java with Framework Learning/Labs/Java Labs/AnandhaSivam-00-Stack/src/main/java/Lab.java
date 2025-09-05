import java.util.Deque;
import java.util.ArrayDeque;
/**
 * Stacks are LIFO - last in, first out, like a stack of plates or books, or the puzzle game "Towers of Hanoi".
 * They are used in algorithms where it is needed to keep track of the ordering in which the elements were inserted.
 *
 * ArrayDeque fills the role of *both* queues and stacks. You could think of a Deque as a deck of cards (pronounced the
 * same) where you could remove cards from either the top or bottom. You can use ArrayDeque
 * to perform stack operations. You can read about ArrayDeque in the official Javadocs here:
 * https://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html
 * And you can read about the stack class here (deque exhibits the same behavior as Stack and contains the same
 * methods): https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 */
public class Lab {
    /**
     * Implement and return some class that implements Deque, such as ArrayDeque, which contains all the functionality
     * of a Stack. This challenge will not be using the Stack class, because the Stack class is known to have a shoddy
     * implementation as it hasn't been changed since the very earliest version of Java. Deques were made to exhibit
     * the exact same behavior and are generally better.
     *
     * @return a newly instantiated Deque. Deques implement both stack and queue behavior.
     */
    public Deque<String> createNewStack(){
        return new ArrayDeque<>();
    }

    /**
     * @param stack A Deque of Strings.
     * @return the number of elements in the deque.
     */
    public int getSize(Deque<String> stack){
        return stack.size();
    }

    /**
     * Push a value to the top of the deque.
     * (this adds the value to the Stack.)
     * @param stack A Deque of Strings.
     * @param item a String to be added to the deque.
     */
    public void addToTopOfStack(Deque<String> stack, String item){
        stack.push(item);
    }

    /**
     * Pop the value from the top of the deque and return that value.
     * (this removes the most recently-pushed value)
     * @param stack A Deque of Strings.
     * @return the value popped from the top of the deque.
     */
    public String removeFromTopOfStack(Deque<String> stack){
        return stack.pop();
    }
    /**
     * Peek the value at the top of a deque.
     * This returns the most recently-pushed value, without removing the value.
     *
     * @param stack A Deque of Strings.
     * @return the value peeked from the top of the deque.
     */
    public String getTopOfStackWithoutRemoving(Deque<String> stack){
        return stack.peek();
    }
}
