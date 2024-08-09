// An integer array A is given as input of length N. 
// Your task is to find and print the difference between the first duplicate element 
// and last duplicate element in array A. 
// Note: Assume that the input contains both positive and negative integers

import java.util.*;

public class Duplicate_Difference {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    List<Integer> duplicates = new ArrayList<>();

    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        if(arr[i] == arr[j] && !duplicates.contains(arr[i])) {
          duplicates.add(arr[i]);
          break;
        }
      }
    }

    System.out.println(Math.abs(duplicates.get(0) - duplicates.get(duplicates.size() - 1)));
  }
}