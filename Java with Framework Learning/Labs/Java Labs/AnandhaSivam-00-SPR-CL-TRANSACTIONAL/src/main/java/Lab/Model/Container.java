package Lab.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

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
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    //    @Column annotations actually aren't necessary. all fields will be made columns by default.
    public String contents;
    public double weight;

    public Container(String contents, double weight) {
        this.contents = contents;
        this.weight = weight;
    }
}
