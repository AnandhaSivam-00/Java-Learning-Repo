// Maximum Consecutive Subarray
// Given a binary array (containing only 0s and 1s), find the length of the 
// longest consecutive subarray of the same digit. If no such subarray 
// exists, print "No subarray found".

// Example Input: [1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1]
// Example Output: 4

import java.util.*;

public class LongestConsecutiveSubarray {
  protected static int findLongestConsecutiveSubarrayLength(int[] arr, int n) {
    int maxLength = 0, currentLength = 0;

    for(int i = 1; i < n; i++) {
      if(arr[i] == arr[i - 1]) {
        currentLength++;
      }
      else {
        maxLength = Math.max(maxLength, currentLength);
        currentLength = 1;
      }
    }

    maxLength = Math.max(maxLength, currentLength);

    return maxLength;
  } 
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(findLongestConsecutiveSubarrayLength(arr, n));
  }
}