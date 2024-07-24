import java.util.*;
import java.time.*; // Need for LocalDate, LocalTime and LocalDateTime classes
import java.time.format.*; // Need for DateTimeFormatter classes

public class LocaldateClass {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    // String date = sc.next();

    // For date section
    LocalDate ld = LocalDate.now();
    System.out.println("Today: " + ld);

    System.out.println("Current day:" + ld.getDayOfWeek());
    System.out.println("Current Month: " + ld.getMonth() + " " + ld.getDayOfMonth());
    System.out.println("Current Year : " + ld.getYear());
    System.out.println(ld.isLeapYear());

    System.out.println(ld.isBefore(LocalDate.parse("2022-01-01")));
    System.out.println(ld.isAfter(LocalDate.parse("2022-01-01")));

    // For time section
    LocalTime lt = LocalTime.now();
    System.out.println("Current Time: " + lt);
    System.out.println("Current Hour: " + lt.getHour());

    System.out.println(lt.isBefore(LocalTime.parse("08:30")));
    System.out.println(lt.isAfter(LocalTime.parse("12:00")));

    // For both date and time section
    LocalDateTime ldt = LocalDateTime.now();
    System.out.println("Current Date and Time: " + ldt);
    System.out.println("Current Date: " + ldt.getDayOfWeek());
    System.out.println("Current Month: " + ldt.getMonth());
    System.out.println("Current Year: " + ldt.getYear());

    // Formatting date and time

    System.out.println(ldt.format(DateTimeFormatter.ISO_DATE));
    System.out.println(ldt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))); // Capital DD and YYYY produce some varience
  }
}