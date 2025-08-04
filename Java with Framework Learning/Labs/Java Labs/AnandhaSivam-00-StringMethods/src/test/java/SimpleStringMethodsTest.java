
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleStringMethodsTest {
    static SimpleStringMethods ssm;
    @BeforeClass
    public static void setUp(){
        ssm = new SimpleStringMethods();
    }

    /**
     * the length of "aaa" should return 3.
     */
    @Test
    public void lengthTest(){
        Assert.assertEquals(3, ssm.getStringLength("aaa"));
    }
    /**
     * the char at position 2 of 'abcdef' should return 'c'.
     */
    @Test
    public void charAtTest1(){
        Assert.assertEquals('c',ssm.getCharacterAtIndex("abcdef", 2));
    }
    /**
     * the char at position 0 of 'abcdef' should return 'a'.
     */
    @Test
    public void charAtTest2(){
        Assert.assertEquals('a', ssm.getCharacterAtIndex("abcdef", 0));
    }
    /**
     * the index of 'b' of "zebra" should return 2.
     */
    @Test
    public void indexOfTest1(){
        Assert.assertEquals(2, ssm.getIndexGivenCharacter("zebra", 'b'));
    }
    /**
     * the index of 'q' of "zebra" should return -1.
     */
    @Test
    public void indexOfTest2(){
        Assert.assertEquals(-1, ssm.getIndexGivenCharacter("banana", 'q'));
    }

}
