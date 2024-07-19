import java.util.*;

public class LowComplexitySorting_Techs {
  protected static void printArray(int arr[]) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  protected static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  protected static void bubbleSorting(int arr[], int size) {
    boolean isSwapped;
    for(int i=0; i<size; i++) {
      isSwapped = false;
      for(int j=1; j<size; j++) {
        if(arr[j-1] > arr[j]) {
          swap(arr, j-1, j);
          isSwapped = true;
        }
      }
      
      if(!isSwapped) {
        break;
      }
      
      System.out.print("Iteration " + i + ": ");
      printArray(arr);
    }
    System.out.println();
  }

  protected static void selectionSorting(int arr[], int size) {
    int minIndex;
    for(int i=0; i<size; i++) {
      minIndex = i;
      for(int j=i+1; j<arr.length; j++) {
        if(arr[minIndex] > arr[j]) {
          minIndex = j;
        }
      }
      swap(arr, i, minIndex);
      System.out.print("Iteration " + i + ": ");
      printArray(arr);
    }
    System.out.println();
  }

  protected static void insertionSorting(int arr[], int size) {
    for(int i=0; i<size; i++) {
      int j = i;
      while(j > 0 && arr[j-1] > arr[j]) {
        swap(arr, j-1, j);
        j--;
      }
      System.out.print("Iteration " + i + ": ");
      printArray(arr);
    }
    System.out.println();
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    int arr[] = new int[size];

    for(int i=0; i<size; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println("Enter the number to sort : ");
    switch(sc.nextInt()) {
      case 1:
        //Bubble Sort
        System.out.println("Bubble Sort");
        bubbleSorting(arr, size);
        break;
      case 2:
        //Selection sort
        System.out.println("Selection Sort");
        selectionSorting(arr, size);
        break;
      case 3:
        //Insertion sort
        System.out.println("Insertion Sort");
        insertionSorting(arr, size);
        break;
      default:
        break;
    }

  }
}