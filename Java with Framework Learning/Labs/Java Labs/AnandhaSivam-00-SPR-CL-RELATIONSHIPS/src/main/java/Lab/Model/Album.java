package Lab.Model;

import lombok.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * This is an ORM entity for an Album. This entity is incomplete, and you will have to specify the relationship
 * this Entity will have with other entities. Albums ought to have a many-to-one relationship with artists (many albums
 * may be created by one artist) and a one-to-many relationship with songs (one album may have many songs). Review the
 * other provided entities, Artist and Song, to see examples of @OneToMany and @ManyToOne annotations in use.
 */

@Entity
//For the sake of brevity, the following 4 annotations tell Lombok to generate boilerplate code at compile-time.
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {
    //The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long albumId;
    private String title;

    /**
     * Review the other model classes to see examples of annotations that link entities.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_fk")
    private Artist artist;

    /**
     * Review the other model classes to see examples of annotations that link entities.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_fk")
    private List<Song> songs;

    public Album(String title) {
        this.title = title;
    }

    /**
     * A custom toString() is provided that avoids recursively serializing related entities.
     */
    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                '}';
    }
}























