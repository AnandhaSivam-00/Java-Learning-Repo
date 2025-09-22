// Given an array of integers, print all the leaders in the array. 
// A leader is an element that is greater than all the elements to 
// its right. The output should be in the same order as they occur 
// in the input array.

// Example Input: [16, 17, 5, 1, 2]
// Example Output: 17 5 2

import java.util.*;

public class LeadersInArray {
  protected static List<Integer> findLeaders(int[] arr, int n) {
    int max = arr[n - 1];
    List<Integer> leaders = new ArrayList<>();
    leaders.add(max);
    
    for(int i = n - 2; i >= 0; i--) {
      if(arr[i] > max) {
        max = arr[i];
        leaders.add(arr[i]);
      }
    }

    Collections.reverse(leaders);
    return leaders;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(findLeaders(arr, n));
  }
}