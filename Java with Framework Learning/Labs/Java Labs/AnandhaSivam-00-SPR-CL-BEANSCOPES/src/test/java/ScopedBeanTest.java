import Lab.Application;
import Lab.Beans.ScopedBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopedBeanTest {
    /**
     * Requesting the "labBean" multiple times should result in multiple instances. This is the expected behavior
     * of one of the bean scopes. This test will pass when the bean is set to the proper scope.
     */
    @Test
    public void scopedBeanTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        ScopedBean b1 = (ScopedBean) applicationContext.getBean("labBean");
        ScopedBean b2 = (ScopedBean) applicationContext.getBean("labBean");
        Assertions.assertTrue(b1!=b2);
    }
}
