package Lab;

import Lab.Beans.ElectricEngine;
import Lab.Beans.GasEngine;
import Lab.Beans.NuclearEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * This is the Configuration class for this spring project - there are three beans, electricPoweredBean,
 * nuclearPoweredBean, and gasPoweredBean which are configured in this class. Notice that the Configuration annotation
 * combined with the Bean annotation allows for the retrieval of objects as beans (objects managed by Spring.)
 *
 * Check out the contents of the "Lab" class to see how beans can be retrieved from the app context.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class);
        Lab lab = new Lab();
        System.out.println(lab.getElectricPoweredBean());
        System.out.println(lab.getGasPoweredBean());
        System.out.println(lab.getNuclearPoweredBean());
    }
    @Bean
    public ElectricEngine electricPoweredBean(){
        return new ElectricEngine();
    }
    @Bean
    public NuclearEngine nuclearPoweredBean(){
        return new NuclearEngine();
    }
    @Bean
    public GasEngine gasPoweredBean(){
        return new GasEngine();
    }
}
