// Consider an array of size N-1 containing distinct integers in the range of 1 to N. 
// Your task is to find the missing element in the array.

// Write a function or algorithm to efficiently solve this problem.

// Example:
// Input:
// Array: [1, 2, 4, 6, 3, 7, 8]
// Output:
// Missing Element: 5

// Explanation:
// The missing element in the array is 5.

import java.util.*;

public class MissingElementInArray {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), i, max = Integer.MIN_VALUE;
    int arr[] = new int[n];

    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
      max = Math.max(max, arr[i]);
    }

    int freq[] = new int[max+1];
    for(i=0; i<n; i++) {
      freq[arr[i]]++;
    }

    for(i=1; i<=max; i++) {
      if(freq[i] == 0) {
        System.out.println("Missing Element: " + i);
        break;
      }
    }
    
  }
}