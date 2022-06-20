package dynamic_programming;

import org.junit.jupiter.api.Test;

public class _53 {
    /** runtime: 2 ms 58.94%
     *  memory usage: 81.5 MB 11.27% */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0) sum = 0;
        }

        return max;
    }

    @Test
    void test(){
        int[] nums = {-1,-2,-3,-4,-5};
        System.out.println(maxSubArray(nums));
    }
}
