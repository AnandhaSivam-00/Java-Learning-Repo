import Lab.Service.ShipService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;

public class ShipServiceTestSuite {

    @Test
    public void testTransactionalAnnotationPresence(){
        Class<ShipService> shipServiceClass = ShipService.class;
        boolean annotationFound = shipServiceClass.isAnnotationPresent(Transactional.class);
        Assertions.assertTrue(annotationFound);
    }

    @Test
    public void testTransactionalRollbackForTonnageException(){
        Class<ShipService> shipServiceClass = ShipService.class;
        Annotation transactionalAnnotation = shipServiceClass.getAnnotation(Transactional.class);

        boolean annotationPropertyFound = transactionalAnnotation.toString().contains("InvalidTonnageException");

        Assertions.assertTrue(annotationPropertyFound);
    }

}
