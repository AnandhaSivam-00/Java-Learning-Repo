// Develop a program to arrange an unsorted array of integers into a wave array. 
// An array arr[0..n-1] is considered in wave form if it satisfies the condition: 

// arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..

// Example:
// Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
// Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} 


// Input: arr[] = {20, 10, 8, 6, 4, 2}
// Output: arr[] = {20, 8, 10, 4, 6, 2}

import java.util.*;

public class WaveLikeSorting {
  protected static void waveSorting(int arr[], int n) {
    int i;
    for(i=1; i<n-1; i+=2) {
      if(arr[i] > arr[i-1]) {
        swapping(arr, i, i-1);
      }
      else if(arr[i] > arr[i+1]) {
        swapping(arr, i, i+1);
      }
    }
  }

  protected static void swapping(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), i;
    int arr[] = new int[n];
    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    waveSorting(arr, n);

    for(i=0; i<n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}