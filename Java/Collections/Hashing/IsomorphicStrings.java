import java.util.*;

public class IsomorphicStrings {
  protected static boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    char ch1, ch2;

    for(int i=0; i<s.length(); i++) {
      ch1 = s.charAt(i);
      ch2 = t.charAt(i);
      
      if(!map.containsKey(ch1)) {
        map.put(ch1, ch2);
      }
      else {
        if(map.get(ch1) != ch2) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String t = sc.next();

    System.out.println(isIsomorphic(s, t));
  }
}