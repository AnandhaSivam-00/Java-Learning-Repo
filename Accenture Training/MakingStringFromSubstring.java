// Develop a program to determine the minimum number of times a given string 
// A needs to be repeated such that another string B becomes a substring of it. 
// If no solution exists, the program should output -1.

// Example:
// Input : A = “abcd”, B = “cdabcdab” 
// Output : 3 
// Repeating A three times (“abcdabcdabcd”), B is a substring of it. B is not a substring of A when it is repeated less than 3 times.

// Input : A = “ab”, B = “cab” 
// Output : -1

import java.util.*;

public class MakingStringFromSubstring {
  protected static int isContainsAllChars(String a, String b) {
    int count = 1;

    StringBuilder sb = new StringBuilder(a);

    while (sb.length() < b.length()) { // Match the second string length
        count++;
        sb.append(a);
    }

    if (sb.toString().contains(b)) { // Check if the second string is a substring of the first string
        return count;
    }

    sb.append(a);
    if (sb.toString().contains(b)) { // If the second string is not a substring of the first string, check if it is a substring of the first string repeated
        return count + 1;
    }

    return -1;
    
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String str1 = sc.next(), str2 = sc.next();

    System.out.println(isContainsAllChars(str1, str2));

  }
}