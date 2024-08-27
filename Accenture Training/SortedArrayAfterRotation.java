// Examine the array arr[] comprising N distinct integers. 
// Your objective is to determine whether the array remains sorted after undergoing a counter-clockwise rotation. 
// It is imperative to note that a conventionally sorted array, without any rotations, 
// does not qualify as sorted and rotated in this context. 
// In essence, ascertain the presence of at least one rotation for the array to be 
// considered as sorted and rotated.

// Example:

// Input: arr[] = { 3, 4, 5, 1, 2 } 
// Output: true 

// Explanation: 
// Sorted array: {1, 2, 3, 4, 5}. 
// Rotating this sorted array clockwise 
// by 3 positions, we get: { 3, 4, 5, 1, 2}

// Input: arr[] = {7, 9, 11, 12, 5} 
// Output: true




import java.util.*;

public class SortedArrayAfterRotation {
  protected static boolean isSorted(int[] arr, int n) {
    int i=0, incCount = 0, decCount = 0, equalCount = 0;
    
    for(i=1; i<n; i++) {
      if(arr[i-1] > arr[i]) {
        incCount++;
      }
      else if(arr[i-1] < arr[i]) {
        decCount++;
      }
      else {
        equalCount++;
      }
    }

    if(incCount > decCount) {
      incCount += equalCount;
    }
    else {
      decCount += equalCount;
    }

    if((incCount == 1 || decCount == 1) || (n == incCount || n == decCount)) {
      return true;
    }
    else {
      return false;
    }
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n], i = 0;

    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(isSorted(arr, n));
  }
}