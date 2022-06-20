package test;

import java.util.ArrayList;
import java.util.List;

public class _119 {
    /** runtime: 1 ms 89.21%
     *  memory usage: 41.3 MB 66.86% */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size()-1; j++)
                row.set(j, row.get(j)+row.get(j+1));
        }

        return row;
    }
}
