// Consider a mountain array, denoted as arr[], and an integer X. Your assignment is 
// to formulate an algorithm to determine the smallest index of X within the given 
// mountain array. In cases where no such index is identified, the output should be -1. 
// Develop a solution that effectively locates the specified integer in the mountain 
// array and prints the smallest index if found; otherwise, outputs -1.

// Example:
// Input: arr = {1, 2, 3, 4, 5, 3, 1}, X = 3

// Output: 2
// Explanation: 
// The smallest index of X(= 3) in the array is 2. 
// Therefore, the required output is 2.

// Input: arr[] = {0, 1, 2, 4, 2, 1}, X = 3
// Output: -1
// Explanation: Since 3 does not exist in the array, the required output is -1.


import java.util.*;

public class SmallestIntegerMountain {
  protected static int indexOfX(int arr[], int target, int start, int end) {
    while(start < end) {
      int mid = start + (end - start) / 2;

      if(arr[0] <= arr[mid]) {
        if(target >= arr[0] && target <= arr[mid]) {
          end = mid;
        }
        else {
          start = mid + 1;
        }
      }
      else {
        if(target >= arr[mid] && target <= arr[arr.length - 1]) {
          end = mid;
        }
        else {
          start = mid + 1;
        }
      }
    }

    return arr[start] == target ? start : -1;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), i;
    int arr[] = new int[n];

    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    int key = sc.nextInt();

    System.out.println(indexOfX(arr, key, 0, n-1));
  }
}