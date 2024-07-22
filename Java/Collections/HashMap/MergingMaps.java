import java.util.*;

public class MergingMaps {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    HashMap<Integer, String> originalMap = new HashMap<>();

    originalMap.put(1, "A");
    originalMap.put(2, "B");
    originalMap.put(3, "C");
    
    HashMap<Integer, String> newMap = new HashMap<>();
    newMap.put(1, "D");
    newMap.put(2, "E");
    newMap.put(4, "F");

    // newMap.forEach((key, value) -> originalMap.merge(key, value, String::concat));  // put the newMap items into the original map

    // System.out.println(originalMap);

    // Writing bifunctions for custom delimiters

    newMap.forEach((key, value) -> originalMap.merge(key, value, (a, b) -> a.equalsIgnoreCase(b) ? a : "[" + a + "," + b + "]"));

      System.out.println(originalMap);

  }
}