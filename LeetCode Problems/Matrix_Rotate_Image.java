import java.util.*;

public class RotateArray90 {
    protected static void swap(int matrix[][], int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
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
        
        // Transpose the matrix
        for(row=0; row<n; row++) {
            for(col=row; col<n; col++) {
                if(row != col) {
                    swap(matrix, row, col);
                }
            }
        }
        
        // Reverse the columns of the matrix
        for(row=0; row<n; row++) {
            for(col=0; col<n/2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n-col-1];
                matrix[row][n-col-1] = temp;
            }
        }
        
        for(row=0; row<n; row++) {
            for(col=0; col<n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

