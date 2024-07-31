class Solution {
    protected static int findMappingValue(int[][] board, int rowIndex, int colIndex) {
        int i, j, countingOne = 0;

        for (i = rowIndex - 1; i < rowIndex + 2; i++) {
            for (j = colIndex - 1; j < colIndex + 2; j++) {
                if ((i != rowIndex || j != colIndex) && i >= 0 && j >= 0 && i < board.length && j < board[0].length) {
                    // System.out.print("(" + i + "," + j + ") ");
                    if (board[i][j] == 1 || board[i][j] == 3) { // the 1 becomes 2
                        countingOne++;
                    }
                }
            }
        }
        // System.out.println();

        if (board[rowIndex][colIndex] == 1 && (countingOne == 2 || countingOne == 3)) {
            return 3;
        } 
        else if (countingOne == 3) {
            return 2;
        }

        return board[rowIndex][colIndex];
    }

    public void gameOfLife(int[][] board) {
        int row, col;

        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[0].length; col++) {
                board[row][col] = findMappingValue(board, row, col);
            }
        }

        // Changing the temp assigned values
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[0].length; col++) {
               if(board[row][col] == 1) {
                board[row][col] = 0;
               }
               else if(board[row][col] == 2 || board[row][col] == 3) {
                board[row][col] = 1;
               }
            }
        }
    }
}


// 0 1 0
// 0 0 1
// 1 1 1
// 0 0 0

// Takes Orginal State and New State --> Mapping value
//          0                   0             0
//          0                   1             2
//          1                   0             1
//          1                   1             3

// In the first itertion
// takes 0 and see the all neighbours for the if any one of the condition is matches