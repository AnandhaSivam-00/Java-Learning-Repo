class Solution {
    protected static boolean containsReputation(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
        boolean isVisited[] = new boolean[10]; // sudukko contains 0 to 9
        int i, j;

        for(i=rowStart; i<=rowEnd; i++) {
            for(j=colStart; j<=colEnd; j++) {
                if(board[i][j] != '.') {
                    if(isVisited[board[i][j] - '0']) {
                        return true;
                    }

                    isVisited[board[i][j] - '0'] = true;
                }
            }
        }

        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        // checking in row
        int row, col;

        for(row=0; row<=8; row++) {
            if(containsReputation(board, row, row, 0, 8)) {
                return false;
            }
        }

        // checking in col
        for(col=0; col<=8; col++) {
            if(containsReputation(board, 0, 8, col, col)) {
                return false;
            }
        }

        // Checking in sub boxes
        for(row=0; row<=2; row++) {
            for(col=0; col<=2; col++) {
                if(containsReputation(board, row*3, row*3+2, col*3, col*3+2)) {
                    return false;
                }
            }
        }

        return true;
    }
}