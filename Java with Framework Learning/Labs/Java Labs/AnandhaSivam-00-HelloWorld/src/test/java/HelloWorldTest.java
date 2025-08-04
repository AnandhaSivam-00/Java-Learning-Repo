
import org.junit.Assert;
import org.junit.Test;

/**
 * DO NOT change anything within this test file. All code should be written in src/main/java/Lab.java
 */
public class HelloWorldTest {
    Lab hw = new Lab();

    /**
     * Method sayHello() must return "Hello, World!". The trim method will remove any extra spaces or newlines at the end.
     */
    @Test
    public void helloTest(){
        String expected = "Hello, world!";
        String actual = hw.sayHello().trim();
        Assert.assertEquals(expected,actual);
    }
}
