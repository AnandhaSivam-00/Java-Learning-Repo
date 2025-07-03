// Given an array of N integers. Every number in the array 
// except one appears twice. Find the single number in the array.

// For the leftside of the answer, all the element is in (even, odd) combo like they 
// are same. In the rightside of the answer, all the elements are in (odd, even) combo 
// like they are same.

import java.util.*;

public class SearchSingleElement {
  private static int findSingleElement(int n, int[] arr) {
    if(n == 1) {
      return arr[0];
    }
    else if(n == 2) {
      if(arr[0] != arr[1]) {
        return arr[0];
      }
      else {
        return -1;
      }
    }

    int left = 0, right = n - 1, mid;
    while(left <= right) {
      mid = left + (right - left) / 2;
      
      // If the mid is a single element
      if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]) {
        return arr[mid];
      }
      // Check if we are in the left side of the answer, if yes move to the right
      else if((mid % 2 == 0 && arr[mid] == arr[mid+1]) || (mid % 2 != 0 && arr[mid] == arr[mid-1])) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    return -1;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(findSingleElement(n, arr));
  }
}