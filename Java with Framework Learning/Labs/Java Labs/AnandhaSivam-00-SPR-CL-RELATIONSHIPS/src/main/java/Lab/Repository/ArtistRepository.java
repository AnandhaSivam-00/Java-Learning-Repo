package Lab.Repository;

import Lab.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * JPARepository that will be used to preform persistence operations on Artist objects
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
