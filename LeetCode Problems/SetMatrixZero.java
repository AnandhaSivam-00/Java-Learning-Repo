class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
    int n = matrix[0].length;
    boolean[] rows = new boolean[m];
    boolean[] cols = new boolean[n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0) {
                rows[i] = true;
                cols[j] = true;
            }
        }
    }

    for (int i = 0; i < m; i++) {
        if (rows[i]) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    for (int j = 0; j < n; j++) {
        if (cols[j]) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }
    }
}


// Without using extra space
class Solution {
    public void setZeroes(int[][] matrix) {
        int row, col;
        boolean flag = false;

        // Mark if the zero exists or not in the subarray into the taken marker row and column
        for(row=0; row<matrix.length; row++) {
            for(col=0; col<matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    matrix[row][0] = 0;

                    if(col != 0) {
                        matrix[0][col] = 0;
                    }
                    else {
                        flag = true;
                    }
                }
            }
        }

        // Make the row and column as zero of the respective place of marker row contains zero 

        // Traverse through the matrix without taking the first row and column elements
        for(row=1; row<matrix.length; row++) {
            for(col=1; col<matrix[0].length; col++) {
                if(matrix[row][col] != 0 && (matrix[row][0] == 0 || matrix[0][col] == 0)) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Make actions based on the first element in matrix
        if(matrix[0][0] == 0) {
            for(col=0; col<matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        if(flag) {
            for(row=0; row<matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }


    }
}