package ds.Map;

import java.util.*;

public class _2248 {

    /** runtime: 2 ms 99.40%
     *  memory usage: 46.5 MB 51.52% */
    public List<Integer> intersection_1(int[][] nums){
        List<Integer> list = new ArrayList<>();

        int[] count = new int[1001];
        for (int[] num : nums)
            for (int i : num)
                count[i]++;

        for (int i = 0; i < 1001; i++)//use index to represent num
            if (count[i] == nums.length)
                list.add(i);

        return list;
    }

    /** runtime: 7 ms 52.00%
     *  memory usage: 47.8 MB 13.32% */
    public List<Integer> intersection_2(int[][] nums){
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] num : nums)
            for (int i : num) {
                map.put(i, map.getOrDefault(i,0)+1);
                if (map.get(i) == nums.length) list.add(i);
            }

        list.sort(Comparator.naturalOrder());
        return list;
    }

    /** runtime: 10 ms 26.05%
     *  memory usage: 47.5 MB 20.92% */
    public List<Integer> intersection_21(int[][] nums){
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] num : nums)
            for (int i : num)
                map.put(i, map.getOrDefault(i,0)+1);

        for (Integer i : map.keySet())
            if (map.get(i) == nums.length) list.add(i);

        list.sort(Comparator.naturalOrder());
        return list;
    }
}
