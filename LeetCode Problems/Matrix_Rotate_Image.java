class Solution {
    protected static void swapping(int[][] matrix, int row, int col) {
        matrix[row][col] = matrix[row][col] + matrix[col][row];
        matrix[col][row] = matrix[row][col] - matrix[col][row];
        matrix[row][col] = matrix[row][col] - matrix[col][row];
    }

    public void rotate(int[][] matrix) {
        // To Transpose the matrix

        int row, col, col1, col2;

        for (row = 0; row < matrix.length; row++) {
            for (col = row; col < matrix.length; col++) {
                if (col != row) {
                    swapping(matrix, row, col);
                }
            }
        }

        // To reverse the row

        for (row = 0; row < matrix.length; row++) {
            col1 = 0;
            col2 = matrix.length-1;

            while (col1 < col2) {
                matrix[row][col1] = matrix[row][col1] + matrix[row][col2];
                matrix[row][col2] = matrix[row][col1] - matrix[row][col2];
                matrix[row][col1] = matrix[row][col1] - matrix[row][col2];
                col1++;
                col2--;
            }
        }
    }
}