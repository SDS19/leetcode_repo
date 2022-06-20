package ds.Array;

public class A_566 {
    /** runtime: 1 ms 81.55%
     *  memory usage: 43.2 MB 87.15% */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (r*c != m*n) return mat;

        int[] arr = new int[m*n];
        for (int i = 0, k = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[k++] = mat[i][j];

        int[][] res = new int[r][c];
        for (int i = 0, k = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                res[i][j] = arr[k++];

        return res;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 43 MB 96.61% */
    public int[][] matrixReshape_1(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (r*c != m*n) return mat;

        int[][] res = new int[r][c];
        for (int i = 0, x = 0, y = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                res[x][y++] = mat[i][j];
                if (y == c) {
                    x++;
                    y = 0;
                }
            }

        return res;
    }

    /** runtime: 1 ms 81.55%
     *  memory usage: 43.2 MB 90.75% */
    public int[][] matrixReshape_2(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (r*c != m*n) return mat;

        int[][] res = new int[r][c];
        for (int i = 0; i < r*c; i++)
            res[i/c][i%c] = mat[i/n][i%n];

        return res;
    }
}
