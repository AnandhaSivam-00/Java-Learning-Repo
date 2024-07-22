import java.util.*;

public class NameSortingUsingMerge {
  protected static String[] sortPeople(String[] names, int[] heights) {
    mergeSort(names, heights, 0, names.length - 1);
    return names; 
  }  

  protected static void mergeSort(String[] names, int[] heights, int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        mergeSort(names, heights, start, mid);
        mergeSort(names, heights, mid + 1, end);
        merge(names, heights, start, mid, end);
    }
  }

  protected static void merge(String names[], int heights[], int start, int mid, int end) {
    int leftSize = mid - start + 1;
    int rightSize = end - mid;

    String leftNames[] = new String[leftSize];
    String rightNames[] = new String[rightSize];
    int leftHeights[] = new int[leftSize];
    int rightHeights[] = new int[rightSize];

    int i, j, k = start;

    for(i=0; i<leftSize; i++) {
      leftNames[i] = names[start + i];
      leftHeights[i] = heights[start + i];
    }

    for(j=0; j<rightSize; j++) {
      rightNames[j] = names[mid + 1 + j];
      rightHeights[j] = heights[mid + 1 + j];
    }

    i = 0;
    j = 0;

    while(i < leftSize && j < rightSize) {
      if(leftHeights[i] <= rightHeights[j]) {
        names[k] = leftNames[i];
        heights[k] = leftHeights[i];
        i++;
      }
      else {
        names[k] = rightNames[j];
        heights[k] = rightHeights[j];
        j++;
      }
    }

    while(i < leftSize || j < rightSize) {
      if(i < leftSize) {
        names[k] = leftNames[i];
        heights[k] = leftHeights[i];
        i++;
      }
      else {
        names[k] = rightNames[j];
        heights[k] = rightHeights[j];
        j++;
      }
      k++;
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String names[] = new String[n];
    int heights[] = new int[n];

    for(int i=0; i<n; i++) {
      names[i] = sc.next();
      heights[i] = sc.nextInt();
    }

    String sortedNames[] = sortPeople(names, heights);

    for(int i=0; i<n; i++) {
      System.out.println(sortedNames[i]);
    }
  }
}