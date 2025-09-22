import Lab.Application;
import Lab.Model.Product;
import Lab.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;


public class ProductEntityTest {

    /**
     * This test will pass if the ApplicationContext successfully starts. This requires that the
     * persistence Entities are correctly annotated.
     *
     * The ProductRepository interface defines a JPA Repository for Product Entities. If Product is
     * not properly annotated as an Entity, the repository bean cannot be created, so the ApplicationContext
     * cannot be successfully started.
     */
    @Test
    public void productEntityTest1() {
        ApplicationContext applicationContext = SpringApplication.run(Application.class);
        ProductService productService = applicationContext.getBean(ProductService.class);
        Product p1 = productService.insertProduct(new Product(1, "Headphones", "Nice headphones"));
        Assertions.assertTrue(productService.getAllProducts().contains(p1));
    }
}
