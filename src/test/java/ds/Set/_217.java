package ds.Set;

import org.junit.jupiter.api.Test;

import java.util.*;

public class _217 {

    /** runtime: 31 ms 6.91%
     *  memory usage: 72.6 MB 8.59% */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        return nums.length != set.size();
    }

    /** runtime: 7 ms 83.84%
     *  memory usage: 69.7 MB 39.73% */
    public boolean containsDuplicate_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) if (!set.add(num)) return true;
        return false;
    }

    /** runtime: 25 ms 16.69%
     *  memory usage: 71.6 MB 17.11% */
    public boolean containsDuplicate_11(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1) return true;
        }
        return false;
    }

    /** runtime: 24 ms 19.41%
     *  memory usage: 68.5 MB 58.41% */
    public boolean containsDuplicate_2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++)
            if (nums[i] == nums[i+1]) return true;
        return false;
    }


    @Test
    void test(){
        int[] a = {1,2,3,1};
        System.out.println(containsDuplicate_1(a));
    }
}
