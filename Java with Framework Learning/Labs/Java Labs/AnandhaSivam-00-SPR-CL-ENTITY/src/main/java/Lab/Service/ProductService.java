package Lab.Service;

import Lab.Model.Product;
import Lab.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.util.List;

/**
 * This Service class demonstrates the basic use of the ProductRepository.
 * There is no need to change anything in this class.
 */
@Component
@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    /**
     * This method will retrieve all Product entities from the Product database table, the equivalent
     * of a "select * from product" statement.
     * @return
     */
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    /**
     * This method will persist a product to the Product database table, the equivalent of a
     * "insert into product" statement.
     * @return
     */
    public Product insertProduct(Product product){
        return productRepository.save(product);
    }
    /**
     * This method will delete a product from the Product database table, the equivalent of a
     * "delete from product" statement.
     * @return
     */
    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
}