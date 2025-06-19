// A matrix diagonal is a diagonal line of cells starting from some 
// cell in either the topmost row or leftmost column and going in the bottom-right 
// direction until reaching the matrix's end.

// For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, 
// includes cells mat[2][0], mat[3][1], and mat[4][2].

// Given an m x n matrix mat of integers, sort each matrix diagonal 
// in ascending order and return the resulting matrix.

class Solution {
    protected void sortList(int row, int col, int[][] mat) {
        int diagonalLength = Math.min(
            mat.length - row,
            mat[0].length - col
        );

        List<Integer> diagonal = new ArrayList<>();
        for(int i=0; i<diagonalLength; i++) {
            diagonal.add(mat[row + i][col + i]);
        }

        Collections.sort(diagonal);

        for(int j=0; j<diagonalLength; j++) {
            mat[row + j][col + j] = diagonal.get(j);
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        for(int row=0; row<mat.length; row++) {
            sortList(row, 0, mat);
        }

        for(int col=0; col<mat[0].length; col++) {
            sortList(0, col, mat);
        }

        return mat;
    }
}