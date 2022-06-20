package test;

import java.util.HashSet;
import java.util.Set;

public class _2133 {
    /** runtime: 65 ms 30.53%
     *  memory usage: 92.8 MB 30.45% */
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < n; j++)
                if (!row.add(matrix[i][j]) || !col.add(matrix[j][i])) return false;
        }
        return true;
    }

    /** runtime: 65 ms 30.53%
     *  memory usage: 92.8 MB 30.45% */
    public boolean checkValid1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < n; j++)
                if (!row.add(matrix[i][j]) || !col.add(matrix[j][i])) return false;
        }
        return true;
    }

    /** runtime: 68 ms 28.07%
     *  memory usage: 96.7 MB 13.77% */
    public boolean checkValid2(int[][] matrix) {
        int n = matrix.length, sum = n*(n+1)/2;
        for (int i = 0; i < n; i++) {
            int row = 0, col = 0;
            for (int j = 0; j < n; j++) {
                row += matrix[i][j];
                col += matrix[j][i];
            }
            if(row != sum || col != sum) return false;
        }
        return true;
    }

}
