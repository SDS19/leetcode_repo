package ds.ArrayList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _118 {
    /** runtime: 0 ms 100.00%
     *  memory usage: 40.2 MB 81.39% */
    public List<List<Integer>> generate_1(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0,1);
            for (int j = 1; j < row.size()-1; j++)
                row.set(j, row.get(j) + row.get(j+1));
            rows.add(new ArrayList<>(row));
        }

        return rows;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 41.7 MB 50.01% */
    public List<List<Integer>> generate_2(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++)
                if (j == 0 || j == i) row.add(1);
                else row.add(rows.get(i-1).get(j-1)+rows.get(i-1).get(j));
            rows.add(row);
        }

        return rows;
    }

    /** runtime: 1 ms 57.34%
     *  memory usage: 42 MB 27.90% */
    public List<List<Integer>> generate_3(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i+1);
            while (row.size() <= i) row.add(1);
            int mid = i >> 1;
            for (int j = 1; j <= mid; j++) {
                int val = rows.get(i-1).get(j-1) + rows.get(i-1).get(j);
                row.set(j, val);
                row.set(row.size()-j-1, val);
            }
            rows.add(row);
        }

        return rows;
    }


    @Test
    void test(){
        generate_3(5);
    }
}
