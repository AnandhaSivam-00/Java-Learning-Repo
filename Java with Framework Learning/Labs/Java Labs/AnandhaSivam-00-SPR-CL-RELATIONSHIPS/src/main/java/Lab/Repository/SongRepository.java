package Lab.Repository;

import Lab.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JPARepository that will be used to preform persistence operations on Song objects
 */
public interface SongRepository extends JpaRepository<Song, Long> {

}
