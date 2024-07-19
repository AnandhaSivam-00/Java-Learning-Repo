import java.util.*;
import java.util.stream.*; 

// To Group the items based on length

public class Concept_5 {
  protected static void lenGrouping(String str) {
    String words[] = str.split(" ");

    Map<Integer, List<String>> lenMap = Arrays.asList(words)
      .stream()
      .collect(Collectors.groupingBy(String::length));

    for(Map.Entry<Integer, List<String>> items : lenMap.entrySet()) {
      System.out.println(items.getKey() + " : " + items.getValue());
    }
  }


  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    lenGrouping(sc.nextLine());
  }
}