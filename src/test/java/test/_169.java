package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169 {
    /** runtime: 11 ms 32.69%
     *  memory usage: 56 MB 49.17% */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0)+1);
        for (Integer key : map.keySet())
            if (map.get(key) > nums.length/2) return key;
        return 0;
    }

    /** runtime: 4 ms 50.42% O(nlogn)
     *  memory usage: 56.4 MB 35.79% */
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /** runtime: 2 ms 82.12% O(nlogn)
     *  memory usage: 56 MB 45.93% */
    public int majorityElement_2(int[] nums) {
        int count = 0, major = 0;

        for (int num : nums) {
            if (count == 0) major = num;
            if (num == major) count++;
            else count--;
        }

        return major;
    }

    @Test
    void test(){
        int[] a = {2,2,1,1,1,2,2};
        System.out.println(majorityElement_2(a));
    }

}
