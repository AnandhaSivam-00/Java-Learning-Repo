package Application.Repository;

import Application.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository interface for the Student entity
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
