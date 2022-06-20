package test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _219 {
    /** runtime: 19 ms 84.91%
     *  memory usage: 50.6 MB 90.60% */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
            map.put(nums[i], i);
        }
        return false;
    }

    /** sliding window
     *  runtime: 34 ms 58.66%
     *  memory usage: 79.6 MB 52.46% */
    public boolean containsNearbyDuplicate_1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i-k-1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }

    /** runtime: 19 ms 84.91%
     *  memory usage: 50.6 MB 90.60% */
    public boolean containsNearbyDuplicate_2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.put(nums[i], i);
            if (val != null && i - val <= k) return true;

        }
        return false;
    }

    @Test
    void test(){
        int[] a = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(a,2));
    }
}
