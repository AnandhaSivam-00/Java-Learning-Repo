// A string s is given as input. Your task is to find and print 
// the count of characters occurring more than twice continuously in a given string s.
// Note:
// 1.String s contains both uppercase and lowercase alphabets.
// 2. Assume that the Uppercase alphabets and lowercase alphabets are not same.

import java.util.*;

public class CountOfConsecutiveOccurance {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int counter = 1;

    List<Character> result = new ArrayList<>();

    for(int i = 1; i < str.length(); i++) {
      if(str.charAt(i) == str.charAt(i - 1)) {
        counter++;

        if(counter == 2 && !result.contains(str.charAt(i))) {
          result.add(str.charAt(i));
          counter = 1;
        }
      }
      else {
        counter = 1;
      }
    }

    System.out.print(result);
  }
}