package Application;

import Application.Model.Classroom;
import Application.Model.Student;
import Application.Repository.ClassroomRepository;
import Application.Service.ClassroomService;
import Application.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(App.class);
        ClassroomService classroomService = applicationContext.getBean(ClassroomService.class);
        StudentService studentService = applicationContext.getBean(StudentService.class);
        System.out.println("First, let's create a new classroom and student entity and persist them. Then, we'll make " +
                "sure they exist by retrieving all entities.");
        Classroom c1 = classroomService.addClassroom(new Classroom("A201"));
        Classroom c2 = classroomService.addClassroom(new Classroom("A202"));
        Student s1 = studentService.addStudent(new Student("Ted Balashov", 1));
        Student s2 = studentService.addStudent(new Student("Person McHuman", 1));
        List<Classroom> allClassrooms = classroomService.getAllClassrooms();
        System.out.println(allClassrooms);
        System.out.println("Next, let's try to assign a student to a classroom A202, then retrieve all of the students of" +
                " the classroom.");
        classroomService.addStudentToClassroom(c1.getId(), s1);
        List<Student> allStudents = classroomService.getStudentsOfClassroom(c1.getId());
        System.out.println(allStudents);
        System.out.println("Next, let's try to remove the student from classroom A202, then retrieve all of the students of" +
                " the classroom. The classroom should now not contain students.");
        classroomService.removeStudentFromClassroom(c1.getId(), s1.getId());
        System.out.println(classroomService.getStudentsOfClassroom(c1.getId()));
        System.out.println("Now let's try performing these operation from the student's side using your code in" +
                " the StudentService. We'll start by assigning a classroom to a student and retrieving their " +
                "classroom.");
        studentService.assignClassroomToStudent(s2.getId(), c2);
        System.out.println("Here is the second student's classroom: ");
        System.out.println(studentService.getClassroomOfStudent(s2.getId()));
        System.out.println("Now let's unassign the student's classroom. Their classroom should now be null.");
        studentService.unassignClassroomOfStudent(s2.getId());
        System.out.println(studentService.getClassroomOfStudent(s2.getId()));



    }
}
