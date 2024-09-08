// Create a program to identify all pairs of integers in an array whose sum equals a given target number.

// Example:

// Input: arr[] ={10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1} target = 11
// Output: Count of pairs is 9

import java.util.*;

public class CountOfPairs {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), i, j, pairCount = 0;
    int arr[] = new int[n];

    for(i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    int target = sc.nextInt();

    for(i=0; i<n; i++) {
      for(j=i+1; j<n; j++) {
        if(arr[i] + arr[j] == target) {
          pairCount++;
        }
      }
    }

    // HashMap<Integer, Integer> map = new HashMap<>();
    // int temp;

    // for(i=0; i<n; i++) {
    //   temp = sc.nextInt();
    //   map.put(temp, map.getOrDefault(temp, 0) + 1);
    // }

    // int target = sc.nextInt();

    // for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //   if(map.containsKey(target - entry.getKey())) {
    //     System.out.println(entry.getKey() + " " + map.containsKey(target - entry.getKey()));
    //     pairCount += 1;
    //   }
    // }

    System.out.println("Count of pairs is " + pairCount);
  }
}

