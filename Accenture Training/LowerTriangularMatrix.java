// Given a square 2D matrix of size N x N, where N is a positive integer, write a program to 
//check whether the matrix is a Lower Triangular Matrix. A Lower Triangular Matrix is a square 
//matrix in which all the entries above the main diagonal are zero.
// Input Format
// size of an array elements of an array

// Constraints
// 1 <= N <= 1000

// Output Format
// integer

// Sample Input 0
// 3
// 1 0 0
// 5 7 0
// 1 8 9
// Sample Output 0
// 1

// Sample Input 1
// 5
// 1 0 0 2 0
// 2 8 0 9 0
// 4 1 3 0 7
// 6 2 1 8 0
// 1 2 3 4 5

// Sample Output 1
// 0

import java.util.*;

public class LowerTriangularMatrix {
    protected static boolean isLowerTriangularMatrix(int matrix[][], int n) {
        int row, col;
        
        for(row=0; row<n; row++) {
            for(col=0; col<n; col++) {
                if(col > row && matrix[row][col] != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(), row, col;
        int matrix[][] = new int[n][n];
        
        for(row=0; row<n; row++) {
            for(col=0; col<n; col++) {
                matrix[row][col] = sc.nextInt();
            }
        }
        
        if(isLowerTriangularMatrix(matrix, n)) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}
