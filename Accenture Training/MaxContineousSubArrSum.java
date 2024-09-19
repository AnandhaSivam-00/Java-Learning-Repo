// You are given an array Arr[] of N integers. Your task is to identify the contiguous sub-array (containing at least one number) with the maximum sum and return its sum.

// Write a function or algorithm to efficiently solve this problem.
// Example:

// Input:
// Array: [-2, 1, -3, 4, -1, 2, 1, -5, 4]

// Output:
// Maximum Sum: 6

// Explanation:
// The contiguous sub-array [4, -1, 2, 1] has the maximum sum, which is 6.

import java.util.*;

public class MaxContineousSubArrSum {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];

    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    int currMax = arr[0], maxSum = arr[0];

    for(int i=1; i<n; i++) {
      currMax = Math.max(arr[i], currMax + arr[i]);
      maxSum = Math.max(currMax, maxSum);
    } 

    // int currSum, maxSum = Integer.MIN_VALUE;

    // for(int i=0; i<n; i++) {
    //   currSum = 0;
    //   for(int j=i; j<n; j++) {
    //     currSum += arr[j];
    //     maxSum = Math.max(currSum, maxSum);
    //   }
    // }
    
    System.out.println(maxSum);
      
  }
}