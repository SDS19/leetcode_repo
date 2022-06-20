package test;

import org.junit.jupiter.api.Test;

public class _867 {
    /** runtime: 1 ms 52.16%
     *  memory usage: 48.5 MB 45.22% */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                res[i][j] = matrix[j][i];

        return res;
    }

    @Test
    void test(){
        int[][] m = {{1,2,3},{4,5,6}};
        System.out.println(transpose(m));
    }
}
