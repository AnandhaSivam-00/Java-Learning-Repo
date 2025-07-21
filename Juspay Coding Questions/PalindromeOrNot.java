// You are given a string with alphabets. You need to convert the string to lowercase and check 
// if the string is a palindromic one.

// If the string is a palindrome, print the length of the palindromic string. 
// If that string is a non-palindromic one, print the ASCII value of the first character of the alphabet in the given string.

import java.util.*;

public class PalindromeOrNot {
  protected static int palindromeCheck(String str) {
    int i=0, j=str.length() - 1;
    while(i < j) {
      if(str.charAt(i) != str.charAt(j)) {
        return (int)str.charAt(0);
      }
      i++;
      j--;
    }

    return str.length();
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    str = str.toLowerCase();

    System.out.print(palindromeCheck(str));
  }
}