import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Deque;

public class StackImplementationExerciseTest {
    static Lab se;

    @BeforeClass
    public static void setUp(){
        se = new Lab();
    }
    /**
     * A newly instantiated Stack should not be null.
     */
    @Test
    public void createStackTest(){
        Deque<String> stack = se.createNewStack();
        Assert.assertNotNull(stack);
    }
    /**
     * A newly instantiated Stack should have a size of 0.
     */
    @Test
    public void getSizeTest1(){
        Deque<String> stack = se.createNewStack();
        if(stack == null){
            Assert.fail();
        }else{
            Assert.assertEquals(0, se.getSize(stack));
        }
    }
    /**
     * An empty stack which has had an item added to it should have a size of 1.
     */
    @Test
    public void getSizeTest2(){
        Deque<String> stack = se.createNewStack();
        if(stack == null){
            Assert.fail();
        }else{
            se.addToTopOfStack(stack, "Crime and Punishment");
            Assert.assertEquals(1, se.getSize(stack));
        }
    }
    /**
     * An empty stack which has had two items added to it should have a size of 2.
     */
    @Test
    public void addToTopOfStackTest1(){
        Deque<String> stack = se.createNewStack();
        if(stack == null){
            Assert.fail();
        }else{
            se.addToTopOfStack(stack, "Crime and Punishment");
            se.addToTopOfStack(stack, "Finnegan's Wake");
            Assert.assertEquals(2, se.getSize(stack));
        }
    }

    /**
     * A stack with 3 items which then has an item removed should have a size of 2. The removed item
     * should be the most recently added item.
     */
    @Test
    public void removeFromTopOfStackTest1(){
        Deque<String> stack = se.createNewStack();
        if(stack == null){
            Assert.fail();
        }else{
            se.addToTopOfStack(stack, "Crime and Punishment");
            se.addToTopOfStack(stack, "Finnegan's Wake");
            se.addToTopOfStack(stack, "Don Quixote");
            String bookName = se.removeFromTopOfStack(stack);
            Assert.assertEquals(2, se.getSize(stack));
            Assert.assertEquals("Don Quixote", bookName);
        }
    }
    /**
     * A stack with 3 items which then has 2 items removed should have a size of 1. The most recently
     * added item should be removed first.
     */
    @Test
    public void removeFromTopOfStackTest2(){
        Deque<String> stack = se.createNewStack();
        if(stack == null){
            Assert.fail();
        }else{
            se.addToTopOfStack(stack, "Crime and Punishment");
            se.addToTopOfStack(stack, "Finnegan's Wake");
            se.addToTopOfStack(stack, "Don Quixote");
            String bookName = se.removeFromTopOfStack(stack);
            Assert.assertEquals("Don Quixote", bookName);
            bookName = se.removeFromTopOfStack(stack);
            Assert.assertEquals(1, se.getSize(stack));
            Assert.assertEquals("Finnegan's Wake", bookName);
        }
    }

    /**
     * Peeking from a stack should return the most recently added item without decreasing the size of the stack.
     */
    @Test
    public void getTopOfStackWithoutRemovingTest1(){
        Deque<String> stack = se.createNewStack();
        if(stack == null){
            Assert.fail();
        }else{
            se.addToTopOfStack(stack, "Crime and Punishment");
            se.addToTopOfStack(stack, "Finnegan's Wake");
            se.addToTopOfStack(stack, "Don Quixote");
            String bookName = se.getTopOfStackWithoutRemoving(stack);
            Assert.assertEquals("Don Quixote", bookName);
            Assert.assertEquals(3, se.getSize(stack));
        }
    }
}
