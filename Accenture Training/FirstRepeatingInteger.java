// Create a program to identify the index of the first repeating element 
// in an array of integers, where the first occurrence of the 
// repeating element has the smallest index.

// Example:
// Input: arr[] = {10, 5, 3, 4, 3, 5, 6}
// Output: 5 
// Explanation: 5 is the first element that repeats

// Input: arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
// Output: 6 
// Explanation: 6 is the first element that repeats

import java.util.*;

public class FirstRepeatingInteger {
  protected static int firstRepeatingInt(int[] arr) {
    int i, j;

    for(i=0; i<arr.length; i++) {
      for(j=i+1; j<arr.length; j++) {
        if(arr[i] == arr[j]) {
          return j;
        }
      }
    }

    return -1;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int[] arr = new int[sc.nextInt()];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(firstRepeatingInt(arr));
  }
}