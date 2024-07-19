import java.util.*;
import java.util.stream.*; 
import java.util.function.Function; // for identity method

// To Group the items based on frquency of occurence

public class Concept_6 {
  protected static void freqGrouping(String str) {
    String words[] = str.split(" ");

    Map<String, Long> freqMap = Arrays.asList(words)
      .stream()
      .collect(
        Collectors.groupingBy(
          Function.identity(),
          Collectors.counting()
        )
      ); // Must be Long

    for(Map.Entry<String, Long> items : freqMap.entrySet()) {
      System.out.println(items.getKey() + " : " + items.getValue());
    }
  }


  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    freqGrouping(sc.nextLine());
  }
}