// Given two strings of equal length, find and print all the substrings
// where the characters at the same positions in both strings are
// different. The output should display the mismatched substrings 
// from both strings.

// Example Input: schoollifeisusefull, schoollongofuselike
// Example Output:
// ifeis , ongof
// full , like

import java.util.*;

public class UnmatchedSubstrings {
  protected static List<String> findUnmatchedSubstrings(String str1, String str2) {
    List<String> unmatchedSubstrings = new ArrayList<>();
    if(str1.length() != str2.length()) {
      return unmatchedSubstrings;
    }
    
    int start = 0, end = 0;
    for(int i = 0; i < str1.length(); i++) {
      if(str1.charAt(i) != str2.charAt(i)) {
        start = i;
        while(i < str1.length() && str1.charAt(i) != str2.charAt(i)) {
          end = i;
          i++;
        }
        unmatchedSubstrings.add(str1.substring(start, end + 1));
        unmatchedSubstrings.add(str2.substring(start, end + 1));
      }
    }

    return unmatchedSubstrings;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = sc.nextLine();
    String str2 = sc.nextLine();

    System.out.println(findUnmatchedSubstrings(str1, str2));
  }
}