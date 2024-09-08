// Create an algorithm to efficiently sort an array of N elements, 
// considering that each element is at most K positions away from its 
// target position. The algorithm should achieve a time complexity 
// of O(N log K).
  
// Example:

// Input: arr[] = {6, 5, 3, 2, 8, 10, 9}, K = 3 
// Output: arr[] = {2, 3, 5, 6, 8, 9, 10}

// Input: arr[] = {10, 9, 8, 7, 4, 70, 60, 50}, k = 4
// Output: arr[] = {4, 7, 8, 9, 10, 50, 60, 70}

// Using Merge Sort, Also done with a Quick sort algorithm

import java.util.*;

public class SortWithContraints {
  protected static void sortByPartioning(int[] arr, int start, int end, int k) {
    mergeSort(arr, start, k);
    mergeSort(arr, k+1, end);
  }

  protected static void mergeSort(int arr[], int start, int end) {
    if(start >= end) {
      return;
    }

    int mid = start + (end - start) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid+1, end);
    merge(arr, start, end, mid);
  }

  protected static void merge(int arr[], int start, int end, int mid) {
    int leftArrSize = mid - start + 1;
    int rightArrSize = end - mid;

    int leftArr[] = new int[leftArrSize];
    int rightArr[] = new int[rightArrSize];
    int i, j, k = start;

    for(i=0; i<leftArrSize; i++) {
      leftArr[i] = arr[start + i];
    }

    for(j=0; j<rightArrSize; j++) {
      rightArr[j] = arr[mid + 1 + j];
    }

    i=0;
    j=0;

    while(i < leftArrSize && j < rightArrSize) {
      if(leftArr[i] <= rightArr[j]) {
        arr[k++] = leftArr[i++];
      }
      else {
        arr[k++] = rightArr[j++];
      }
    }

    while(i < leftArrSize || j < rightArrSize) {
      if(i < leftArrSize) {
        arr[k++] = leftArr[i++];
      }
      else if(j < rightArrSize) {
        arr[k++] = rightArr[j++];
      }
    }
    
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int k = sc.nextInt();

    sortByPartioning(arr, 0, n - 1, k);

    for(int i=0; i<n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}