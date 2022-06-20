package test;

public class _74 {
    /** runtime: 0 ms 100.00%
     *  memory usage: 42.3 MB 64.18% */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                    if (matrix[i][j] == target) return true;

        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length-1; i++)
            if (target > matrix[i][0] && target < matrix[i+1][0])
                for (int j = 0; j < matrix[0].length; j++)
                    if (matrix[i][j] == target) return true;

        return false;
    }

    public boolean searchMatrix_1(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length-1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;

        }

        return false;
    }
}
