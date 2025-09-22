package Lab.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * This is an ORM entity for an Artist. Artists have a one-to-many relationship with albums (one artist can produce
 * many albums). This is reflected in the @OneToMany annotation. Spring Data JPA will associate these entities (and
 * their database tables) with each other according to the specified relationship. This is done with foreign keys, but
 * we are abstracted away from that behavior. If we wish to find the albums written by a particular artist, JPA will
 * perform a join with the Album table to retrieve the artists. All that is needed to retrieve a List of the related
 * albums is to call the method artist.getAlbums().
 */
@Entity
//For the sake of brevity, the following 4 annotations tell Lombok to generate boilerplate code at compile-time.
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Artist {
    //The GeneratedValue annotation allows for Spring to automatically generate a unique ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artistId;
    private String name;
    /**
     * There is one artist for many albums.
     * They will be connected via a foreign key by the name "album_fk", belonging to the Album table.
     * Spring will automatically perform the logic needed to join the Album and Artist table to get related albums.
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_fk")
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
    }
    /**
     * A custom toString() is provided that avoids recursively serializing related entities.
     */
    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", name='" + name + '\'' +
                '}';
    }
}
