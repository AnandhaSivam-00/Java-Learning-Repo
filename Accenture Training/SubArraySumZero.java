// Develop a program to determine whether an array, consisting of both 
// positive and negative numbers, contains a subarray (of minimum size one) 
// with a sum equal to zero.

// Example:
// Input: {4, 2, -3, 1, 6}
// Output: true 
// Explanation:
// There is a subarray with zero sum from index 1 to 3.

// Input: {4, 2, 0, 1, 6}
// Output: true
// Explanation: The third element is zero. A single element is also a sub-array.

import java.util.*;

public class SubArraySumZero {
  protected static boolean isSubArraySumZero(int[] arr) {
    int i, sum = 0;
    Set<Integer> set = new HashSet<>();

    for(i=0; i<arr.length; i++) {
      sum += arr[i];

      if(sum == 0 || set.contains(sum)) {
        // If the current as been seen before, return true
        return true;
      }
      set.add(sum);
    }

    return false;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int[] arr = new int[sc.nextInt()];
    boolean flag = false;

    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();
      if(arr[i] == 0) {
        flag = true;
      }
    }

    if(flag) {
      System.out.println("true");
    }
    else {
      System.out.println(isSubArraySumZero(arr));
    }
  }
}