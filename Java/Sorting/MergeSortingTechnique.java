import java.util.*;

public class MergeSortingTechnique {

  protected static void merge(int arr[], int low, int mid, int high) {
    // Intitializing the left and right array sizes.
    int leftSize = mid - low + 1;
    int rightSize = high - mid;

    // Creating the left and right array.
    int left[] = new int[leftSize];
    int right[] = new int[rightSize];
    int i, j, k = low;

    // Copying the elements of the left array.
    for(i=0; i<leftSize; i++) {
      left[i] = arr[low + i];
    }

    // Copying the elements of the right array.
    for(j=0; j<rightSize; j++) {
      right[j] = arr[mid + 1 + j];
    }

    // Resetting the index of the array.
    i = 0;
    j = 0;

    // Merging the left and right array.
    // while(left[i] <= right[j]) {
    //   arr[k] = left[i];
    //   i++;
    //   k++;
    // }

    // while(left[i] >= right[j]) {
    //   arr[k] = right[j];
    //   j++;
    //   k++;
    // }

    while(i < leftSize && j < rightSize) {
      if(left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      }
      else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }

    // Copying the remaining elements
    while(i < leftSize || j < rightSize) {
      if(i < leftSize) {
        arr[k] = left[i];
        i++;
        k++;
      }
      else if(j < rightSize) {
        arr[k] = right[j];
        j++;
        k++;
      }
    }
    
  }
  
  protected static void mergeSort(int arr[], int low, int high) {
    if(low >= high) {
      return;
    }
    int mid = (low + high) / 2;

    mergeSort(arr, low, mid);
    mergeSort(arr, mid+1, high);
    merge(arr, low, mid, high);
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    int arr[] = new int[size];

    for(int i=0; i<size; i++) {
      arr[i] = sc.nextInt();
    }

    mergeSort(arr, 0, size-1);

    for(int i=0; i<size; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}


// YouTube Link
// https://www.youtube.com/watch?v=4acikH5mXwk