// You're given an sorted array arr of n integers and an integer x. 
// Find the floor and ceiling of x in arr[0..n-1].
// The floor of x is the largest element in the array which is smaller than or equal to x.
// The ceiling of x is the smallest element in the array greater than or equal to x.

// Example 1:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
// Result: 4 7
// Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

// Example 2:
// Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 8
// Result: 8 8
// Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.

import java.util.*;

public class FloorAndCeilSortedArray {
  protected static int[] findingFloorAndCeil(int n, int[] arr, int x) {
    int left = 0, right = n - 1, mid, floorValue = 0, ceilValue = 0;

    while(left <= right) {
      mid = left + (right - left) / 2;

      if(arr[mid] == x) {
        return new int[]{arr[mid], arr[mid]};
      }
      else if(arr[mid] < x) {
        floorValue = arr[mid];
        left = mid + 1;
      }
      else {
        ceilValue = arr[mid];
        right = mid - 1;
      }
    }
    return new int[]{floorValue, ceilValue};
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }
    int x = sc.nextInt();
    int result[] = findingFloorAndCeil(n, arr, x);

    System.out.println(result[0]);
    System.out.println(result[1]);
  }
}