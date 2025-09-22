import Application.Model.Classroom;
import Application.Model.Student;
import Application.Repository.ClassroomRepository;
import Application.Repository.StudentRepository;
import Application.Service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        studentService = new StudentService(studentRepository, classroomRepository);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentService.addStudent(student);

        assertEquals(student, result);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testAssignClassroomToStudent() {
        long studentId = 1L;
        Classroom classroom = new Classroom();

        Student student = new Student();
        student.setId(studentId);

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentRepository.save(student)).thenReturn(student);

        studentService.assignClassroomToStudent(studentId, classroom);

        assertEquals(classroom, student.getClassroom());
        verify(studentRepository, times(1)).findById(studentId);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testGetClassroomOfStudent() {
        long studentId = 1L;
        Classroom classroom = new Classroom();

        Student student = new Student();
        student.setId(studentId);
        student.setClassroom(classroom);

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        Classroom result = studentService.getClassroomOfStudent(studentId);

        assertEquals(classroom, result);
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    public void testUnassignClassroomOfStudent() {
        long studentId = 1L;

        Student student = new Student();
        student.setId(studentId);
        student.setClassroom(new Classroom());

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentRepository.save(student)).thenReturn(student);

        studentService.unassignClassroomOfStudent(studentId);

        assertEquals(null, student.getClassroom());
        verify(studentRepository, times(1)).findById(studentId);
        verify(studentRepository, times(1)).save(student);
    }
}