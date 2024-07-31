import java.util.*;

public class VaildAnagramUsingHashing {
  protected static boolean isVaildAnagram(String s, String t) {
    Map<Character, Integer> freqMap = new HashMap<>();

    String big;
    String small;

    if(s.length() > t.length()) {
      big = s.toLowerCase();
      small = t.toLowerCase();
    }
    else {
      big = t.toLowerCase();
      small = s.toLowerCase();
    }

    for(int i=0; i<big.length(); i++) {
      freqMap.put(big.charAt(i), freqMap.getOrDefault(big.charAt(i), 0) + 1);
    }

    for(int i=0; i<small.length(); i++) {
      char ch = small.charAt(i);
      if(freqMap.containsKey(ch) && freqMap.get(ch) > 0) {
        freqMap.put(ch, freqMap.get(ch) - 1);
      }
      else {
        return false;
      }
    }

    return true;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String t = sc.next();

    System.out.println(isVaildAnagram(s, t));
  }
}