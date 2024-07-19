import java.util.*;
import java.util.stream.*; 

// To Reverse a words in a string

public class Concept_4 {
  protected static String StringConversion(String str) {
    // To UpperCase Letters
    List<String> words = Arrays.asList(str.split(" "))
      .stream()
      .map(String::toUpperCase)
      .collect(Collectors.toList());

    return words.toString();
  }


  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.println(StringConversion(sc.nextLine()));
  }
}

// toList()
// In Collector interface
// Gather the elements into a new list

// asList()
// Takes array as input and create new list