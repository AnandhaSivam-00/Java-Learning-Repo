package Application.Service;

import Application.Model.Classroom;
import Application.Model.Student;
import Application.Repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This service class will demonstrate how to retrieve or manipulate the entities related to the Classroom entity.
 */
@Service
public class ClassroomService {
    ClassroomRepository classroomRepository;
    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    /**
     * Persist a new classroom.
     * @param classroom a transient classroom entity.
     * @return a persisted classroom entity.
     */
    public Classroom addClassroom(Classroom classroom){
        return classroomRepository.save(classroom);
    }
    /**
     * @return all persisted classroom entities.
     */
    public List<Classroom> getAllClassrooms(){
        return classroomRepository.findAll();
    }
    /**
     * Assign a student to a classroom while retrieving only the classroom entity.
     * @param classroomId the Id of an already existing classroom entity.
     * @param student an already persisted student entity.
     */
    public void addStudentToClassroom(long classroomId, Student student){
        Optional<Classroom> classroomOptional = classroomRepository.findById(classroomId);
        if(classroomOptional.isPresent()){
            Classroom classroom = classroomOptional.get();
            classroom.getStudents().add(student);
            classroomRepository.save(classroom);
        }
    }
    /**
     * Get the students of a classroom while retrieving only the classroom entity.
     * @param classroomId the Id of an already existing classroom entity.
     * @return the persisted student entities
     */
    public List<Student> getStudentsOfClassroom(long classroomId){
        Optional<Classroom> classroomOptional = classroomRepository.findById(classroomId);
        if(classroomOptional.isPresent()){
            Classroom classroom = classroomOptional.get();
            return classroom.getStudents();
        }
        return null;
    }
    /**
     * Unassign a student from a classroom while retrieving only the clasroom entity.
     * @param classroomId the Id of an already existing classroom entity.
     * @param studentId the Id of the student entity to be removed from a classroom.
     * @return the persisted student entities
     */
    public void removeStudentFromClassroom(long classroomId, long studentId){
        Optional<Classroom> classroomOptional = classroomRepository.findById(classroomId);
        if(classroomOptional.isPresent()){
            Classroom classroom = classroomOptional.get();
//            lambda expression applied to the collection - this is the same as iterating through the student list
//            and removing if(student.getId() == studentId)
            classroom.getStudents().removeIf(student -> student.getId() == studentId);
            classroomRepository.save(classroom);
        }
    }
}
