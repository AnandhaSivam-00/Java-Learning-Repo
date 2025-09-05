// Sorting the employee objects based on their salary using Comparable interface

import java.util.*;
import java.lang.Comparable;

class Employee implements Comparable<Employee> {
  private String name;
  private int salary;
  private int id;
  private int age;
  private String department;

  public Employee(String name, int salary, int id, int age, String department) {
    this.name = name;
    this.salary = salary;
    this.id = id;
    this.age = age;
    this.department = department;
  }

  protected void setName(String name) {
    this.name = name;
  }
  protected void setSalary(int salary) {
    this.salary = salary;
  }
  protected void setId(int id) {
    this.id = id;
  }
  protected void setAge(int age) {
    this.age = age;
  }
  protected void setDepartment(String department) {
    this.department = department;
  }

  protected String getName() {
    return this.name;
  }
  protected int getSalary() {
    return this.salary;
  }
  protected int getId() {
    return this.id;
  }
  protected int getAge() {
    return this.age;
  }
  protected String getDepartment() {
    return this.department;
  }

  @Override
  public int compareTo(Employee emp) {
    if(this.salary == emp.salary) {
      return 0;
    }
    else if(this.salary > emp.salary) {
      return 1;
    }
    else {
      return -1;
    }
  }
}

public class EmployeeObjectSorting {
  public static void main(String args[]) {
    List<Employee> empList = new ArrayList<>();
    empList.add(new Employee("John", 18000, 1, 25, "IT"));
    empList.add(new Employee("Jane", 12000, 2, 26, "HR"));
    empList.add(new Employee("Jack", 30000, 3, 27, "Finance"));
    empList.add(new Employee("Jill", 45000, 4, 28, "Marketing"));
    empList.add(new Employee("Jake", 11000, 5, 29, "Sales"));

    // Collections.sort(empList, Collections.reverseOrder());
    Collections.sort(empList);

    System.out.println("Sorted Employee List:");
    for(Employee emp : empList) {
      System.out.println(emp.getName() + " " + emp.getSalary() + " " + emp.getId() + " " + emp.getAge() + " " + emp.getDepartment());
    }
  }
}