package Lab.Repository;

import Lab.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is a JPARepository. When Spring starts up, it will become a usable Bean which can perform basic
 * database operations on our Product Entity, allowing us to save, delete, update, and query for Products from
 * a Product table that directly resembles the Product Object in Java. Spring will manage the conversion between
 * database records and Java Objects automatically through a process called Object Relational Mapping. The setup for
 * that database is defined in the application.properties file in src/main/resources.
 *
 * We will look into how to work with the JPARepository in the future. First, let's configure our Entity in the Model
 * folder. Take note of how the JPARepository takes in two generic types, the first the object used to model the
 * Product data (Product) and the second being the type of the entity's Id (Long).
 *
 * There is no need to modify anything in this class. It also doesn't need to be marked as @Component or @Repository,
 * as this is inherited from the JPARepository.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
