package test;

import java.util.HashSet;
import java.util.Set;

public class _36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = null;
        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.')
                    if(!set.add(c)) return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.')
                    if(!set.add(c)) return false;
            }
        }

        int row = 2, col = 2;
        for (int i = 0; i <= row; i++) {
            set.clear();
            for (int j = 0; j <= col; j++) {
                char c = board[i][j];
                if (c != '.') if(!set.add(c)) return false;
                if (i == row && j == col) {
                    i = 0;
                    col = 6;
                }
            }
        }

        return true;
    }

    /** runtime: 3 ms 81.92%
     *  memory usage: 42.2 MB 93.98% */
    public boolean isValidSudoku_1(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                int r = 3*(i/3), c = 3*(i%3);
                if (board[r+j/3][c+j%3] != '.' && cube.add(board[r+j/3][c+j%3])) return false;
            }
        }
        return true;
    }
}
