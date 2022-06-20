package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _54 {
    /** runtime: 0 ms 100.00%
     *  memory usage: 41.9 MB 57.04% */
    public List<Integer> spiralOrder_1(int[][] matrix) {

        List<Integer> a = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            //traverse right
            for (int i = colStart; i <= colEnd; i++) {
                a.add(matrix[rowStart][i]);
            }
            rowStart++;

            //traverse down
            for (int i = rowStart; i <= rowEnd; i++) {
                a.add(matrix[i][colEnd]);
            }
            colEnd--;

            //traverse left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    a.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            //traverse left
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    a.add(matrix[i][colStart]);
                }
            }
            colStart++;

        }
        return a;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 41.6 MB 64.30% */
    public List<Integer> spiralOrder_2(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int top = 0, bottom = matrix.length-1;
        int left = 0, right = matrix[0].length-1;

        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if (left > right) break;

            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if (top > bottom) break;

            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if (left > right) break;
        }

        return res;
    }

    private int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

    @Test
    void test(){
        Integer[] expected = {1,2,3,6,9,8,7,4,5};
        Integer[] actual = spiralOrder_1(matrix).toArray(new Integer[0]);
        Assertions.assertArrayEquals(expected,actual);
    }
}
