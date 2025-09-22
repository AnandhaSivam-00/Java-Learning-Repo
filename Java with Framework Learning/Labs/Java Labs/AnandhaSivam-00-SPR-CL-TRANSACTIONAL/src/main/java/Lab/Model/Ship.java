package Lab.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * The @Entity is provided by Spring Data to convert this class into an ORM entity with a relationship to the
 * database. All other annotations have been provided by Lombok.
 *
 * Nothing in this class needs to be changed.
 */
@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
/**
 * there is no need to modify this class.
 */
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    //    @Column annotations actually aren't necessary. all fields will be made columns by default.
    public String name;
    public double tonnage;

    public Ship(String name, double tonnage) {
        this.name = name;
        this.tonnage = tonnage;
    }
}
