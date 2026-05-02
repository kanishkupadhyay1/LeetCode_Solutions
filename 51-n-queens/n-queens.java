import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // fill with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(board, 0);
        return ans;
    }

    public void backtrack(char[][] board, int row) {

        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (check(board, row, col)) {

                board[row][col] = 'Q';

                backtrack(board, row + 1);

                board[row][col] = '.'; // backtrack
            }
        }
    }

    public boolean check(char[][] board, int row, int col) {

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();

        for (char[] row : board) {
            res.add(new String(row));
        }

        return res;
    }
}