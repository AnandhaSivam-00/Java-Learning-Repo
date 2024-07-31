class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralMatrix = new ArrayList<>();

        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        int row, col;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(col = colStart; col <= colEnd; col++) {
                spiralMatrix.add(matrix[rowStart][col]);
            }
            rowStart++;

            for(row = rowStart; row <= rowEnd; row++) {
                spiralMatrix.add(matrix[row][colEnd]);
            }
            colEnd--;

            if(rowStart <= rowEnd) {
                for(col = colEnd; col >= colStart; col--) {
                    spiralMatrix.add(matrix[rowEnd][col]);
                }

            }
            rowEnd--;

            if(colStart <= colEnd) {
                for(row = rowEnd; row >= rowStart; row--) {
                    spiralMatrix.add(matrix[row][colStart]);
                }

            }
            colStart++;
        } 

        return spiralMatrix;
    }
}