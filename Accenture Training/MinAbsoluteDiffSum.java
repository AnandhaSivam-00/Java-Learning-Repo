// Develop a program to calculate the sum of the minimum absolute differences within a given array.

// Example:

// Input: arr[]={2, 4, 5, 3};
// Output: Minimum Absolute Difference Sum is 4

import java.util.*;

public class MinAbsoluteDiffSum {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), i, sum = 0;
    int arr[] = new int[n];

    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);

    sum += Math.abs(arr[0] - arr[1]);
    sum += Math.abs(arr[n-1] - arr[n-2]);

    for(i=1; i<n-1; i++) {
      sum += Math.min(
        Math.abs(arr[i] - arr[i-1]),
        Math.abs(arr[i] - arr[i+1])
      );
    }

    System.out.println("Minimum Absolute Difference Sum is " + sum);
  }
}