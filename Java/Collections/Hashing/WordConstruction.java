// Construct the the word from the given characters

import java.util.*;

public class WordConstruction {
  protected static boolean canConstruct(String wordConstruct, String givenWord) {
    Map<Character, Integer> freqMap = new HashMap<>();

    for (int i = 0; i < givenWord.length(); i++) {
      char ch = givenWord.charAt(i);
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    for(int i = 0; i < wordConstruct.length(); i++) {
      char ch = wordConstruct.charAt(i);
      if(freqMap.containsKey(ch) && freqMap.get(ch) > 0) {
        freqMap.put(ch, freqMap.get(ch) - 1);
      }
      else if(freqMap.get(ch) == 0){
        return false;
      }
    }

    return true;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String wordConstruct = sc.next();
    String givenWord = sc.next();

    System.out.println(canConstruct(wordConstruct, givenWord));
  }
}