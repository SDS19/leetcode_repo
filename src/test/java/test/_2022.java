package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _2022 {
    /** runtime: 7 ms 56.43%
     *  memory usage: 120 MB 28.93% */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m*n != original.length) return new int[0][0];

        int[][] res = new int[m][n];
        for (int i = 0, k = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                res[i][j] = original[k++];

        return res;
    }

    @Test
    void test(){
        int[] a = {1,2,3,4};
        int[] b = {1,2,3};
        Assertions.assertArrayEquals(new int[][] {{1,2},{3,4}},construct2DArray(a,2,2));
        Assertions.assertArrayEquals(new int[][] {{1,2,3}},construct2DArray(b,1,3));
    }
}
