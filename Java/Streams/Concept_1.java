import java.util.*;
import java.util.stream.*; // Important for Collectors

public class Concept_1 {
  protected static void operationFunc(List<Character> list) {
    List<Integer> resultList = list
      .stream()
      .map(item -> Integer.valueOf(Character.toString(item)) * 2)
      .collect(Collectors.toList());
    System.out.println(resultList);
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String nums = sc.next();

    List<Character> list = new ArrayList<>();

    for(int i = 0; i < nums.length(); i++) {
      list.add(nums.charAt(i));
    }

    operationFunc(list);
  }
}