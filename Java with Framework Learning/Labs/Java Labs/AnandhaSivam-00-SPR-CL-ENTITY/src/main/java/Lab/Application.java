package Lab;

import Lab.Model.Product;
import Lab.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.web.tomcat.TomcatMetricsAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.sql.SQLException;

/**
 * SpringBootApplication main class.
 * There is no need to change anything in this class. Check out the Model class and Repository class for your tasks.
 */
@SpringBootApplication
public class Application {
    /**
     * You can use the main method to check if the Spring app successfully starts. If you get a set of very
     * long errors rather than this nicely formatted output, that most likely means that the Spring beans failed to
     * load, because the JPARepository could not be initialized, because the Product entity was incorrectly set up.
     * Spring errors tend to follow this long cascading pattern.
     */
    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(Application.class);
        ProductService productService = applicationContext.getBean(ProductService.class);
        String output = "\n";
        output+=("\nIf you're seeing this message, the database & entities were probably correctly set up.");
        output+=("\nLet's try inserting some items.");
        Product p1 = productService.insertProduct(new Product(1, "Headphones", "Nice headphones"));
        Product p2 = productService.insertProduct(new Product(2, "Phone", "A smartphone"));
        Product p3 = productService.insertProduct(new Product(3, "Swag", "Some other swag"));
        output+=("\nLet's check the current contents of the Product table.");
        output+=("\n"+productService.getAllProducts());
        output+=("\nLet's see the contents of the Product table after I delete the product.");
        productService.deleteProduct(p2);
        output+=("\n"+productService.getAllProducts()+"\n");
        SpringApplication.exit(applicationContext);
//        I'm printing the output after the spring app finishes its closing logging messages.
        System.out.println(output);
    }
}
