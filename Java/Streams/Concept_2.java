import java.util.*;
import java.util.stream.*; // Important for Collectors

public class Concept_2 {
  protected static void operationFunc(List<String> list) {
    List<String> sortedList = list
      .stream()
      .sorted()
      .filter(name -> name.equals("Hello") != true)
      .collect(Collectors.toList());

    System.out.println(sortedList);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    List<String> nameList = Arrays.asList(sc.nextLine().split(" "));

    // System.out.println(nameList);
    operationFunc(nameList);
  }
}