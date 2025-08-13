// Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a 
// number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.

// Examples

// Example 1:
// Input Format: N = 3, M = 27
// Result: 3
// Explanation: The cube root of 27 is equal to 3.

// Example 2:
// Input Format: N = 4, M = 69
// Result: -1
// Explanation: The 4th root of 69 does not exist. So, the answer is -1.

import java.util.*;

public class NthRootOfANumber {
  private static int findingNthRoot(int n, int m) {
    int left = 0, right = m, mid, num;

    while(left <= right) {
      mid = left + (right - left) / 2;
      num = (int)Math.pow(mid, n);
      
      if(num == m) {
        return mid;
      }
      else if(num > m) {
        right = mid - 1;
      }
      else {
        left = mid + 1;
      }
    }

    return -1;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), m = sc.nextInt();
    System.out.println(findingNthRoot(n, m));
  }
}