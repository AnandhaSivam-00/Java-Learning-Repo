import java.util.*;

class Student {
  private int id;
  private String name;
  private int age;
  private int totMarks;

  public Student(int id, String name, int age, int totMarks) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.totMarks = totMarks;
  }

  protected int getId() {
    return id;
  }
  protected String getName() {
    return name;
  }
  protected int getAge() {
    return age;
  }
  protected int getTotMarks() {
    return totMarks;
  }
}

public class Basic_Object_Sorting {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    int stuId, stuAge, stuTotMarks;
    String stuName;

    List<Student> studentsData = new ArrayList<>();

    while(flag) {
      stuId = sc.nextInt();
      stuName = sc.next();
      stuAge = sc.nextInt();
      stuTotMarks = sc.nextInt();
      
      studentsData.add(new Student(stuId, stuName, stuAge, stuTotMarks));
      
      System.out.println("Student Data is added");
      System.out.println("Do you want to add more students? (Y/N)");

      if(sc.next().equals("N")) {
        flag = false;
      }
    }

    System.out.println("Sorted by Student Id");

    // for comparing integers, use compare inside overrided compare() methed
    // for comparing strings, use compareTo() --> obj1.compareTo(obj2)
    // for case insensitive comparison, use compareToIgnoreCase()

    // Collections.sort(studentsData, Comparator.comparing(Student::getId)); // For array based sorting use Arrays.sort()

    // If two values are same then use to sort as
    // Collections.sort(studentsData, Comparator.comparing(Student::getId).thenComparing(Student::getName).thenComparing(Student::getAge).thenComparing(Student::getTotMarks));     // to Reverese that use .reversed()

    //@Override
    //  public int compare(Employee o1, Employee o2) {
      //     int flag = o1.getId() - o2.getId();
      //     if(flag==0) flag = o1.getName().compareTo(o2.getName());
      //     return flag;
      // }

    Collections.sort(studentsData, new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
          return s1.getId() - s2.getId();
        }
    });

    for(Student stu : studentsData) {
      System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getAge() + " " + stu.getTotMarks());
    }
  }
}



// Note that Compartors are only work on the class type not primitiive types.


Collections.sort(keys, new Comparator<Integer>() {
    @Override
    public int compare(Integer obj1, Integer obj2) {
        if(obj1 - obj2 != 0) {
            return obj1 - obj2;
        }
    }
});