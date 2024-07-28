import java.util.*;

class School {
  // int id;
  // String name;

  // public School(int id, String name) {
  //   this.id = id;
  //   this.name = name;
  // }
}

class Student extends School {
  // int rollno;
  // String StuName;

  // public Student(int rollno, String StuName) {
  //   this.rollno = rollno;
  //   this.StuName = StuName;
  // }
}

public class CollectionAssigning {
  public static void main(String args[]) {
    
    // List<Object> list = new ArrayList<Object>();
    // List<Student> studentList = new ArrayList<Student>();
    // list = studentList; // It throws an error.

    // List<Student> studentList = new ArrayList<Student>();
    // List<School> schoolList = new ArrayList<School>();
    // schoolList = studentList; // It will also not work

    // List<?> schoolList = new ArrayList<School>();
    // List<Student> studentList = new ArrayList<Student>();
    // schoolList = studentList; // It will work

    // List<?> schoolList = new ArrayList<School>();
    // List<String> studentList = new ArrayList<String>();
    // schoolList = studentList; // It will not work because the String is not a child class of School.


    // // upper bound
    // List<? extends School> schoolList = new ArrayList<School>();
    // List<Student> studentList = new ArrayList<Student>();
    // schoolList = studentList; // It will work 


    List<? super School> schoolList = new ArrayList<School>();
    List<Object> studentList = new ArrayList<Object>();
    schoolList = studentList; // It will work
    
  }
}