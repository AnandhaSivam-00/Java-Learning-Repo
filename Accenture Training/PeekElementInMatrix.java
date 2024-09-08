// Determine the methodology to identify a peak element within a given 2D Array or Matrix. Develop an algorithm that can effectively pinpoint a peak element in the matrix, adhering to the specified task requirements.

// Example:

// Input: [[10 20 15], [21 30 14], [7  16 32]]
// Output: 1, 1

// Input: [[10 7], [11 17]]
// Output : 1, 1


import java.util.*;

public class PeekElementInMatrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), m = sc.nextInt(), row = 0, col = 0;
    
    int arr[][] = new int[n][m];
    int result[] = new int[2];

    for(row=0; row<n; row++) {
      for(col=0; col<m; col++) {
        arr[row][col] = sc.nextInt();
      }
    }

    for(row=0; row<n; row++) {
      for(col=0; col<m; col++) {
        if(col-1 >= 0 && arr[row][col] < arr[row][col-1]) {
          continue;
        }
        if(col+1 < m && arr[row][col] < arr[row][col+1]) {
          continue;
        }
        if(row-1 >= 0 && arr[row][col] < arr[row-1][col]) {
          continue;
        }
        if(row+1 < n && arr[row][col] < arr[row+1][col]) {
          continue;
        }
        result[0] = row;
        result[1] = col;
      }
    }

    System.out.println(result[0] + ", " + result[1]);
  }
}



// Leetcode

// class Solution {
//     public int[] findPeakGrid(int[][] mat) {
//     int row = 0, col = 0, m = mat[0].length, n = mat.length;

//     int result[] = new int[2];

//     for(row=0; row<n; row++) {
//       for(col=0; col<m; col++) {
//         if(col-1 >= 0 && mat[row][col] < mat[row][col-1]) {
//           continue;
//         }
//         if(col+1 < m && mat[row][col] < mat[row][col+1]) {
//           continue;
//         }
//         if(row-1 >= 0 && mat[row][col] < mat[row-1][col]) {
//           continue;
//         }
//         if(row+1 < n && mat[row][col] < mat[row+1][col]) {
//           continue;
//         }
//         result[0] = row;
//         result[1] = col;
//       }
//     }

//     return result;
//     }
// }