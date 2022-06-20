package test;

import java.util.*;

public class _136 {
    /** runtime: 15 ms 23.47%
     *  memory usage: 54.4 MB 10.25% */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for (int num : nums)
            if (map.get(num) == 1) return num;
        return 30001;
    }
    /** runtime: 1 ms 98.83%
     *  memory usage: 50.6 MB 48.01% */
    public int singleNumber_1(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }
    /** runtime: 11 ms 30.35%
     *  memory usage: 50.6 MB 43.39% */
    public int singleNumber_2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i+=2)
            if (nums[i]!=nums[i+1]) return nums[i];
        return nums[nums.length-1];
    }

}
