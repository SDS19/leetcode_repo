package test;

import java.util.*;

public class _137 {
    /** runtime: 8 ms 20.36%
     *  memory usage: 45.7 MB 7.37% */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for (int num : nums)
            if (map.get(num) == 1) return num;
        return 30001;
    }

    /** runtime: 5 ms 51.99%
     *  memory usage: 44.3 MB 41.09% */
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i+=3)
            if (nums[i] != nums[i+2]) return nums[i];
        return nums[nums.length-1];
    }

    /** runtime: 5 ms 51.99%
     *  memory usage: 44.3 MB 41.09% */
    public int singleNumber_1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i+=3)
            if (nums[i] != nums[i+2]) return nums[i];
        return nums[nums.length-1];
    }
}
