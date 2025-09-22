package Application.Service;

import Application.Model.Classroom;
import Application.Model.Student;
import Application.Repository.ClassroomRepository;
import Application.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * In this class, you will complete the code necessary to retrieve and manipulate entities related to the Student
 * entity. You can check out the ClassroomService to see how this is done for another entity. You should also review
 * the Classroom and Student classes themselves, as these two classes are related to each other in different ways
 * (a list in a one to many against a single object in a many to one.)
 */
@Service
public class StudentService {
    StudentRepository studentRepository;
    ClassroomRepository classroomRepository;
    /**
     * The StudentRepository has been autowired into this class via constructor injection. In case you would like
     * to use or experiment with the ClassroomRepository as well, that bean will also be injected, however, using the
     * ClassroomRepository is not required.
     * @param studentRepository
     * @param classroomRepository
     */
    @Autowired
    public StudentService(StudentRepository studentRepository, ClassroomRepository classroomRepository){
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }

    /**
     * Persist a new student entity.
     * @param student a transient student entity.
     * @return the persisted student entity.
     */
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    /**
     * @return all student entities.
     */
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    /**
     * TODO: Provided the Id of an already existing student entity, as well as an existing classroom entity,
     * assign the classroom to the student by manipulating the classroom field of the student. Don't forget to save
     * the changes made to your student entity via the studentRepository so that the update is sent to the database.
     *
     * @param studentId the id of a persisted student
     * @param classroom a persisted, existing classroom passed into this method
     */
    public void assignClassroomToStudent(long studentId, Classroom classroom){
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setClassroom(classroom);

            studentRepository.save(student);
        }
    }

    /**
     * TODO: Provided the Id of an already existing student entity, return its assigned classroom by retrieving
     * the 'classroom' field of student. 
     * @param studentId Id of a persisted, existing student entity
     * @return the Classroom of the student
     */
    public Classroom getClassroomOfStudent(long studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if(studentOptional.isPresent()) {
            return studentOptional.get().getClassroom();
        }
        return null;
    }

    /**
     * TODO: Provided the Id of an already existing student entity, unassign its classroom by setting the student
     * entity's classroom field to null. Don't forget to save the changes made to your student entity via the
     * studentRepository so that the update is sent to the database.
     * @param studentId Id of a persisted, existing student entity
     */
    public void unassignClassroomOfStudent(long studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setClassroom(null);

            studentRepository.save(student);
        }
    }
}
