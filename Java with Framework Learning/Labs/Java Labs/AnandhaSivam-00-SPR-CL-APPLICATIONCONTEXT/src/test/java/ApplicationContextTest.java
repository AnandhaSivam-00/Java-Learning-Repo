import Lab.Beans.ElectricEngine;
import Lab.Beans.GasEngine;
import Lab.Beans.NuclearEngine;
import Lab.Lab;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import Lab.Application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(classes = Application.class)
public class ApplicationContextTest {
    @Autowired
    Lab lab;

    @Test
    public void testGetElectricPoweredBean() {
        ElectricEngine electricEngine = lab.getElectricPoweredBean();
        assertNotNull(electricEngine);
    }

    @Test
    public void testGetGasPoweredBean() {
        GasEngine gasEngine = lab.getGasPoweredBean();
        assertNotNull(gasEngine);
    }

    @Test
    public void testGetNuclearPoweredBean() {
        NuclearEngine nuclearEngine = lab.getNuclearPoweredBean();
        assertNotNull(nuclearEngine);
    }
}
