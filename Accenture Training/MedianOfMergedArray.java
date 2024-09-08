// In the context of two sorted arrays, namely a[] and b[], with N and M elements, 
// the objective is to devise an algorithm to determine the median of the combined array. 
// Your task is to formulate a solution that efficiently computes the median, considering 
// the total number of elements in both arrays. Develop an algorithm that accurately 
// identifies the median of the merged sorted arrays, with N and M denoting the 
// number of elements in the respective arrays.

// Example:

// Input: a[] = {-5, 3, 6, 12, 15}, b[] = {-12, -10, -6, -3, 4, 10}
// Output: The median is 3.

// Explanation: The merged array is: ar3[] = {-12, -10, -6, -5 , -3, 3, 4, 6, 10, 12, 15}.
// So the median of the merged array is 3

// Input: a[] = {2, 3, 5, 8}, b[] = {10, 12, 14, 16, 18, 20}
// Output: The median is 11.
// Explanation : The merged array is: ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
// If the number of the elements are even. So there are two middle elements.
// Take the average between the two: (10 + 12) / 2 = 11.


import java.util.*;

public class MedianOfMergedArray {
  protected static void mergeTwoSortedArrays(int arr1[], int arr2[], int arr3[], int n, int m) {
    int i = 0, j = 0, k = 0;

    while(i < n && j < m) {
      if(arr1[i] < arr2[j]) {
        arr3[k++] = arr1[i++];
      }
      else if(arr1[i] > arr2[j]) {
        arr3[k++] = arr2[j++];
      }
      else {
        arr3[k++] = arr1[i++];
        arr3[k++] = arr2[j++];
      }
    }

    while(i < n || j < m) {
      if(i < n) {
        arr3[k++] = arr1[i++];
      }
      else if(j < m) {
        arr3[k++] = arr2[j++];
      }
    }
  }

  protected static int findingMedian(int a[], int size) {
    if(size == 0 || size == 1) {
      return a[0];
    }
    
    int median = 0;
    
    if(size % 2 == 0) {
      median = (a[size/2] + a[size/2 - 1]) / 2;
    }
    else {
      median = a[size/2];
    }

    return median;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), m = sc.nextInt(), i;
    int arr1[] = new int[n];
    int arr2[] = new int[m];

    for(i=0; i<n; i++) {
      arr1[i] = sc.nextInt();
    }

    for(i=0; i<m; i++) {
      arr2[i] = sc.nextInt();
    }

    int arr3[] = new int[n+m];
    mergeTwoSortedArrays(arr1, arr2, arr3, n, m);

    System.out.println(findingMedian(arr3, m+n));
  }
}