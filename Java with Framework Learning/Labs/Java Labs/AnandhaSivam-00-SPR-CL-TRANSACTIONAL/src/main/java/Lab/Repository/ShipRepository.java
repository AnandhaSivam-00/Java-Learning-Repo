package Lab.Repository;

import Lab.Model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * there is no need to modify this class.
 */
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
