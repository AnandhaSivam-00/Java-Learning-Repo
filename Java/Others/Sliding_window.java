import java.util.*;
class Sliding_window {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int max = Integer.MIN_VALUE;

    for(int i=0; i<str.length(); i++) {
      HashMap<Character, Integer> map = new HashMap<>();
      for(int j=0; j<str.length(); j++) {
        if(!map.containsKey(str.charAt(j))) {
          map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
        }
      }
      if(max < map.size()) {
        max = map.size();
      }
    }
    System.out.println(max);
  }
}