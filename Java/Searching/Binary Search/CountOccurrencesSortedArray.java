// Problem Statement: You are given a sorted array containing N integers and a number X, 
// you have to find the occurrences of X in the given array.

// Examples

// Example 1:
// Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
// Output: 4
// Explanation: 3 is occurring 4 times in 
// the given array so it is our answer.

// Example 2:
// Input: N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
// Output: 5
// Explanation: 2 is occurring 5 times in the given array so it is our answer.

import java.util.*;

public class CountOccurrencesSortedArray {
  protected static int occuranceCount(int n, int[] arr, int target, boolean searchDirection) {
    int left = 0, right = n - 1, mid, count = 0;

    while(left <= right) {
      mid = left + (right - left) / 2;

      if(arr[mid] == target) {
        count++;
        if(searchDirection) {
          left = mid + 1;
        }
        else {
          right = mid - 1;
        }
      }
      else if(arr[mid] < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    return count;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }
    int target = sc.nextInt();

    System.out.println(occuranceCount(n, arr, target, false) + occuranceCount(n, arr, target, true));
  }
}