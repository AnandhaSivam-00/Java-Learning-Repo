// Given an array arr[] of N integers and an index range [a, b]. 
// The task is to sort the array in this given index range 
// i.e., sort the elements of the array from arr[a] to arr[b] 
// while keeping the positions of other elements intact and print 
// the modified array. 

// Note: There is no relation between a and b i.e., a can be less than, equal to or greater than b. Also, 0 ? a, b < N

// Examples: 

// Input: arr[] = {7, 8, 4, 5, 2}, a = 1, b = 4 
// Output: 7 2 4 5 8 
// For the index range [1, 4] we get the elements 8, 4, 5 and 2 
// On sorting these elements we get 2, 4, 5 and 8. 
// So the array is modified as {7, 2, 4, 5, 8}

// Input: arr[] = {20, 10, 3, 8}, a = 3, b = 1 
// Output: 20 3 8 10


import java.util.*;

public class RangeSorting {
  protected static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  protected static void sortingOperation(int arr[], int start, int end) {
    for(int i=start; i<=end; i++) {
      int j = i;

      while(j > start && arr[j] < arr[j-1]) {
        swap(arr, j-1, j);
        j--;
      }
    }
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    int a = sc.nextInt(), b = sc.nextInt();

    if(a < 0 || b < 0 || a > n || b > n) {
      System.out.println("Invalid Input");
    }
    else {
      if(a > b) {
        sortingOperation(arr, b, a);
      }
      else {
        sortingOperation(arr, a, b);
      }

      for(int i=0; i<n; i++) {
        System.out.print(arr[i] + " ");
      }
    }
  }
}