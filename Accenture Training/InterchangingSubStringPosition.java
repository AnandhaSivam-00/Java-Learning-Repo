// The program must accept a string S and interchange the first 
// and last N characters. Then the program must print the 
// revised string value.

// Boundary Condition(s):
// 2 <= Length of S <= 100
// 1 <= N <= (Length of S)/2

// Input Format:
// The first line contains S.
// The second line contains N.

// Output Format:
// The first line contains a string value.

// Example Input/Output 1:
// Input:
// abcdefgh
// 3

// Output:
// fghdeabc


import java.util.*;

public class InterchangingSubStringPosition {
  protected static void optimizedSorting(String s, int n) {
    char charArr[] = s.toCharArray();

    int start = s.length() - n;
    int end = s.length();
    int i = 0;

    while(start < end) {
      char temp = charArr[start];
      charArr[start] = charArr[i];
      charArr[i] = temp;
      i++;
      start++;
    }

    System.out.println(new String(charArr));
  }

  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    String str = sc.next();
    int range = sc.nextInt(), n = str.length(), i;

    StringBuilder sb = new StringBuilder();

    for(i=n-range; i<n; i++) {
      sb.append(str.charAt(i));
    }

    for(i=range; i<n-range; i++) {
      sb.append(str.charAt(i));
    }

    for(i=0; i<range; i++) {
      sb.append(str.charAt(i));
    }

    optimizedSorting(str, range);

    System.out.println(sb.toString());
  }
}