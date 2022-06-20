package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _260 {
    /** runtime: 7 ms 22.75%
     *  memory usage: 46.6 MB 9.99% */
    public int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for (int num : nums)
            if (map.get(num) == 1) list.add(num);

        return new int[] {list.get(0),list.get(1)};
    }

    /** runtime: 7 ms 22.75%
     *  memory usage: 46.6 MB 9.99% */
    public int[] singleNumber1(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for (int num : nums)
            if (map.get(num) == 1) list.add(num);

        return new int[] {list.get(0),list.get(1)};
    }
}
