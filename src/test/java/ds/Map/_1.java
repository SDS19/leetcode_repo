package ds.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1 {
    /** runtime: 90 ms 19.82%
     *  memory usage: 44.6 MB 65.62% */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++)
            for (int j = i+1; j < nums.length; j++)
                if (nums[i]+nums[j]==target)
                    return new int[] {i, j};

        return null;
    }

    /** runtime: 1 ms 99.65%
     *  memory usage: 42 MB 99.66% */
    public int[] twoSum_1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[] {map.get(diff), i};
            map.put(nums[i], i);
        }

        return null;
    }

    /** runtime: 3 ms 85.93%
     *  memory usage: 44.2 MB 71.60% */
    public int[] twoSum_2(int[] nums, int target) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int a = 0, b = 0, start = 0, end = copy.length-1;
        while (start < end) {
            int sum = copy[start] + copy[end];
            if (sum < target)
                start++;
            else if (sum > target)
                end--;
            else {
                a = copy[start];
                b = copy[end];
                break;
            }
        }

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == a) {
                res[0] = i;
                break;
            }

        if (a != b) {
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == b) {
                    res[1] = i;
                    break;
                }
        } else {
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == b && i != res[0]) {
                    res[1] = i;
                    break;
                }
        }

        return res;
    }
}
