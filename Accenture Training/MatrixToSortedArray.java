// In an examination scenario, you are presented with K sorted arrays, each of size N. Your assignment
// is to develop an algorithm for merging these arrays into a single sorted output. Formulate a solution 
// that efficiently merges the K sorted arrays and produces the final sorted result. Provide the 
// code for your algorithm along with the necessary explanation, demonstrating your ability to 
// handle and manipulate sorted arrays in a merging context.

// Example:
// Input: K = 3, N = 4, arr = { {1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}}
// Output: 0 1 2 3 4 5 6 7 8 9 10 11 
// Explanation: The output array is a sorted array that contains all the elements of the input matrix


import java.util.*;

public class MatrixToSortedArray {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt(), n = sc.nextInt(), i, j;
    int matrix[][] = new int[k][n];

    for(i=0; i<k; i++) {
      for(j=0; j<n; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }

    int result[] = new int[k*n];
    int counter = 0;
    for(i=0; i<k; i++) {
      for(j=0; j<n; j++) {
        result[counter++] = matrix[i][j];
      }
    }

    Arrays.sort(result);

    for(i=0; i<k*n; i++) {
      System.out.print(result[i] + " ");
    }
  }
}