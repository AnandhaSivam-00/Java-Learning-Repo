// Design a class Student that contains 'Name, 'Reg. No.','Dept','Year', 
// 'Semester' 'Mark1', 'Mark2', 'Mark3', 'Mark4', 'Mark5', 'Mark6', 'Total', 
// 'Average' as a data member and 'getDetails()', 
// 'Display' as the methods. Get the details of data members using getData() 
// and display the mark statement with % of mark using Display 
// methods from the main class StudentMarks.

import java.util.*;

class Students {
  protected String Name;
  protected String RegNo;
  protected String Dept;
  protected int Year;
  protected int Semester;
  protected int Mark1;
  protected int Mark2;
  protected int Mark3;
  protected int Mark4;
  protected int Mark5;
  protected int Mark6;
  protected double Total;
  protected double Average;

  public Students(String Name, String RegNo, String Dept, int Year, int Semester, int Mark1, int Mark2, int Mark3, int Mark4, int Mark5, int Mark6) {
    this.Name = Name;
    this.RegNo = RegNo;
    this.Dept = Dept;
    this.Year = Year;
    this.Semester = Semester;
    this.Mark1 = Mark1;
    this.Mark2 = Mark2;
    this.Mark3 = Mark3;
    this.Mark4 = Mark4;
    this.Mark5 = Mark5;
    this.Mark6 = Mark6;

    Total = Mark1 + Mark2 + Mark3 + Mark4 + Mark5 + Mark6;
    Average = Total / 6;
  }
  
}

public class StudentMarks {
  protected static Students getData(Scanner sc) {
    System.out.println("Enter the name of the student: ");
    String Name = sc.next();

    System.out.println("Enter the RegNo of the student: ");
    String RegNo = sc.next();

    System.out.println("Enter the Dept of the student: ");
    String Dept = sc.next();

    System.out.println("Enter the Year of the student: ");
    int Year = sc.nextInt();

    System.out.println("Enter the Semester of the student: ");
    int Semester = sc.nextInt();

    System.out.println("Enter the Mark1 of the student: ");
    int Mark1 = sc.nextInt();

    System.out.println("Enter the Mark2 of the student: ");
    int Mark2 = sc.nextInt();

    System.out.println("Enter the Mark3 of the student: ");
    int Mark3 = sc.nextInt();

    System.out.println("Enter the Mark4 of the student: ");
    int Mark4 = sc.nextInt();

    System.out.println("Enter the Mark5 of the student: ");
    int Mark5 = sc.nextInt();

    System.out.println("Enter the Mark6 of the student: ");
    int Mark6 = sc.nextInt();

    Students obj = new Students(Name, RegNo, Dept, Year, Semester, Mark1, Mark2, Mark3, Mark4, Mark5, Mark6);

    return obj;
  }

  protected static void display(List<Students> list) {
    for(Students obj : list) {
      System.out.println("Name: " + obj.Name);
      System.out.println("RegNo: " + obj.RegNo);
      System.out.println("Dept: " + obj.Dept);
      System.out.println("Year: " + obj.Year);
      System.out.println("Semester: " + obj.Semester);
      System.out.println("Mark1: " + obj.Mark1);
      System.out.println("Mark2: " + obj.Mark2);
      System.out.println("Mark3: " + obj.Mark3);
      System.out.println("Mark4: " + obj.Mark4);
      System.out.println("Mark5: " + obj.Mark5);
      System.out.println("Mark6: " + obj.Mark6);
      System.out.println("Total: " + obj.Total);
      System.out.println("Average: " + obj.Average);
    }
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;

    System.out.println("Press 1 to add a new student \n Press 2 to display the overall average of the class \n Press 3 to display the students details with their percentage \n Press 4 to exit");

    List<Students> listStudents = new ArrayList<>();

    while(flag) {

      System.out.println("Enter your choice: ");
      
      switch(sc.nextInt()) {
        case 1:
          listStudents.add(getData(sc));
          break;
        case 2:
          display(listStudents);
          break;
        default:
          System.out.println("Invalid Input");
          flag = false;
          break;
      }
    }
  }
}