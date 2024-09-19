// The program must accept N integers and sort only the integers that are in 
// the range (inclusive) X to Y. Other integers (which are not within the range) 
// positions must not be changed. In case Y is smaller than X, consider the 
// range (inclusive) as Y to X.

// Boundary Condition(s):
// 2 <= N <= 100
// 1 <= Each integer value <= 10^5
// 1 <= X, Y <= 10^5

// Input Format:
// The first line contains N, X and Y.
// The second line contains N integer values.

// Output Format:
// The first line contains N integer values.

// Example Input/Output 1:
// Input:
// 5 99 10
// 56 500 25 20000 44

// Output:
// 25 500 44 20000 56

import java.util.*;

public class NumberRangeSorting {
  protected static void numberRangeSorting(int[] arr, int n, int x, int y) {
    for(int i=0; i<n; i++) {
      if(arr[i] >= x && arr[i] <= y) {
        for(int j=i+1; j<n; j++) {
          if(arr[j] >= x && arr[j] <= y) {
            if(arr[i] > arr[j]) {
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
            }
          }
        }
      }
    }
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();;
    
    int arr[] = new int[n];

    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    if(x > y) {
      numberRangeSorting(arr, n, y, x);
    }
    else {
      numberRangeSorting(arr, n, x, y);
    }

    for(int i=0; i<n; i++) {
      System.out.print(arr[i] + " ");
    }
    
  }
}