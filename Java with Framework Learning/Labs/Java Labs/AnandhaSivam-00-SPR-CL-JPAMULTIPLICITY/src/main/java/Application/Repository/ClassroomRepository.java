package Application.Repository;

import Application.Model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository interface for the Classroom entity
 */
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
