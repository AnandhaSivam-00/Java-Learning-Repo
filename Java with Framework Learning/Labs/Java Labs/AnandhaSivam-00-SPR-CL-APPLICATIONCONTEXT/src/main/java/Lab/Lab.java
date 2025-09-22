package Lab;

import Lab.Beans.ElectricEngine;
import Lab.Beans.GasEngine;
import Lab.Beans.NuclearEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Lab {
    /**
     * Notice that the ApplicationContext is itself a bean that can be retrieved from the Spring IOC container
     * (in a sense, from itself, since this is now a Bean used to retrieve Beans)
     */
    @Autowired
    ApplicationContext applicationContext;

    /**
     * Retrieves the ElectricPoweredBean from the ApplicationContext by requesting a bean of the class
     * ElectricEngine. There is no need to modify this method.
     * @return an ElectricEngine bean
     */
    public ElectricEngine getElectricPoweredBean(){
        return applicationContext.getBean(ElectricEngine.class);
    }
    /**
     * TODO: Retrieve an GasEngine bean and return it.
     * @return a GasEngine bean
     */
    public GasEngine getGasPoweredBean(){
        return applicationContext.getBean(GasEngine.class);
    }
    /**
     * TODO: Retrieve a NuclearEngine bean and return it.
     * @return a NuclearEngine bean
     */
    public NuclearEngine getNuclearPoweredBean(){
        return applicationContext.getBean(NuclearEngine.class);
    }
}
