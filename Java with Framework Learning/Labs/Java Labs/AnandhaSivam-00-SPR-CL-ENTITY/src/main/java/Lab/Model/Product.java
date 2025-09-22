package Lab.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Spring uses Object Relational Mapping to provide an easy way to interact with the database. Most of the time,
 * database tables directly match model classes used in Java. Therefore, it is possible to dynamically generate
 * SQL statements based on the contents of an object. Object Relational Mapping will allow us to interact with
 * the database by directly retrieving and manipulating special objects, called Entities, without the
 * need to write SQL statements.
 *
 * In order to do that, this class will need to be marked as an Entity using the @Entity annotation. You will also
 * need to mark a field, such as productID, with the @Id annotation to establish the primary key of the database
 * table. All other fields of the class will automatically become columns of the database table.
 *
 * You may often see Hibernate mentioned in exceptions & documentations. Hibernate is the default "ORM provider"
 * used in Spring Data.
 *
 * You can read Spring's documentation on Spring Data JPA & Entities here: https://spring.io/guides/gs/accessing-data-jpa/
 */

// @TODO - Add an annotation to indicate that this class is mapped to a relation in the database:
@Entity
public class Product {
    // TODO - Add an annotation to indicate that this field is the primary key for the corresponding relation:
    @Id
    private long productID;
    private String name;
    private String description;

    public Product(long productID, String name, String description) {
        this.productID = productID;
        this.name = name;
        this.description = description;
    }

    public Product(){

    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
    This will override the default equality check with a deep equivalency check.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
