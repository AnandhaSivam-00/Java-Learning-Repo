
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExceptionTest {
    static Lab ec;
    @BeforeClass
    public static void setUp(){
        ec = new Lab();
    }

    /**
     * This test verifies that ec.mustThrow() throws an exception.
     */
    @Test
    public void exceptionMustThrowTest(){
        Assert.assertThrows(Exception.class, ()->ec.mustThrow());
    }
}
