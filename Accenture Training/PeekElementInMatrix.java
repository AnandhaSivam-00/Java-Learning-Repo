// Determine the methodology to identify a peak element within a given 2D Array or Matrix. Develop an algorithm that can effectively pinpoint a peak element in the matrix, adhering to the specified task requirements.

// Example:

// Input: [[10 20 15], [21 30 14], [7  16 32]]
// Output: 1, 1

// Input: [[10 7], [11 17]]
// Output : 1, 1


import java.util.*;

public class PeekElementInMatrix {
  int result[] = new int[2];
  int max = Integer.MIN_VALUE;
  
  protected static findingMax(int arr[][], int row, int col) {
    if(max < arr[row][col]) {
      max = arr[row][col];
      result[0] = row;
      result[1] = col;
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), m = sc.nextInt(), row = 0, col = 0, max = Integer.MIN_VALUE;
    int arr[][] = new int[n][m];

    for(row=0; row<n; row++) {
      for(col=0; col<m; col++) {
        arr[row][col] = sc.nextInt();
      }
    }

    for(row=0; row<n; row++) {
      for(col=0; col<m && col+1<m; col++) {
        if(
          (row == 0 && col == 0) && 
          (arr[row][col] >= arr[row][col+1] && arr[row][col] >= arr[row+1][col])
        ) {
          findingMax(arr, row, col);
        }
        else if(
          (row == 0 && col == m-1) &&
          (arr[row][col] >= arr[row][col-1] && arr[row][col] >= arr[row+1][col])
        ) {
          findingMax(arr, row, col);
        }
        else if(
          (row == n-1 && col == 0) &&
          (arr[row][col] >= arr[row][col+1] && arr[row][col] >= arr[row-1][col])
        ){
          findingMax(arr, row, col);
        }
        else if(
          (row == n-1 && col == m-1) &&
          (arr[row][col] >= arr[row][col-1] && arr[row][col] >= arr[row-1][col])
        ) {
          findingMax(arr, row, col);
        }
        else if(
          (row == 0 && col != 0 && col != m-1) &&
          (arr[row][col] >= arr[row][col-1] && arr[row][col] >= arr[row][col+1] && arr[row][col] >= arr[row+1][col])
        )
      }
    }

    if(max < arr[0][0]) {
      result[0] = 0;
      result[1] = 0;
    }
    else if(max < arr[n-1][m-1]) {
      result[0] = n-1;
      result[1] = m-1;
    }

    System.out.println(result[0] + ", " + result[1]);
  }
}