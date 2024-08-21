// Inversion count in array Problem statement Let j and k be two indices in an array A.
// If j < K and A[j] > A[k], then the pair (j,k) is known  as an “Inversion pair”.
// You are required to implement the following function:
// int InversionCount(int *A, int n);
// The function accepts an array ‘A’ of ‘n’ unique integers as its argument. You are required
// to calculate the number of ‘Inversion pair’ in an array A, and return.

// Note:
// If ‘A’ is NULL (None in case of python), return -1
// If ‘n’ <2, return 0
// Example:
// Input:
// A: 1 20 6 4 5
// n: 5

// Output:
// 5
// Explanation:
// The inversion pair in array A are (20,6),(20,4),(20,5),(6,4) and (6,5), the count of the inversions are 5, hence 5 is returned.

// The custom input format for the above case:
// 5
// 1 20 6 4 5

// (The first line represents the size of the array, the second line represents the elements of the array)

// Sample Input
// A: 13 10 9 6 21 15 14
// n: 7
// Sample Output
// 9
// The custom input format
// for the above case: 7
// 13 10 9 6 21 15 14




import java.util.*;

public class InversionPairCount {
  protected static int findingCountOfInversionPairs(int arr[], int n) {

    if(arr.length == 0) {
      return -1;
    }

    if(n < 2) {
      return 0;
    }
    
    int count = 0;

    for(int j=0; j<n; j++) {
      for(int k=j+1; k<n; k++) {
        if(j < k && arr[j] > arr[k]) {
          count++;
        }
      }
    }

    return count;
  }
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int arr[] = new int[n];

    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(findingCountOfInversionPairs(arr, n));
  }
}

