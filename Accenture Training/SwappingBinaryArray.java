// Formulate a program to sort a binary array with the objective of 
// minimizing the number of swaps. 
// The program should adhere to the constraint that only adjacent 
// elements are permissible for swapping.

// Example:
// Input : [0, 0, 1, 0, 1, 0, 1, 1]
// Output : 3

// 1st swap : [0, 0, 1, 0, 0, 1, 1, 1]
// 2nd swap : [0, 0, 0, 1, 0, 1, 1, 1]
// 3rd swap : [0, 0, 0, 0, 1, 1, 1, 1]

// Input : Array = [0, 1, 0, 1, 0]
// Output : 3

import java.util.*;

public class SwappingBinaryArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    int minSwap = 0, i = 0, j = n-1;

    while(i < j) {
      if(arr[i] == 0) {
        i++;
      }
      else if(arr[j] == 1) {
        j--;
      }
      else if(arr[i] == 1 && arr[j] == 0) {
        // System.out.println("i = " + i + " j = " + j);
        minSwap += (j-i);
        arr[i] = 0;
        arr[j] = 1;
        i++;
        j--;
      }
    }

    System.out.println(minSwap);
  }
}