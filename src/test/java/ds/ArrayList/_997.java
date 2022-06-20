package ds.ArrayList;

import java.util.Arrays;

public class _997 {
    /** runtime: 9 ms 20.68%
     *  memory usage: 55.6 MB 42.90% */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] *= nums[i];
        Arrays.sort(nums);
        return nums;
    }
}
