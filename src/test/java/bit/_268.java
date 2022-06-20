package bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _268 {
    /** runtime: 9 ms 12.24%
     *  memory usage: 51.2 MB 42.15% */
    public int missingNumber(int[] nums){
        Arrays.sort(nums);
        int i = 0;
        for (int num : nums)
            if (num != i++) return i-1;
        return nums.length;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 43 MB 91.25% */
    public int missingNumber1(int[] nums){
        int n = nums.length;
        int sum1 = 0, sum2 = 0;
        for (int num : nums) {
            sum1 += n--;
            sum2 += num;
        }
        return sum1-sum2;
    }
    public int missingNumber11(int[] nums){
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += n--;
            sum -= num;
        }

        return sum;
    }

    /** runtime: 1 ms 67.28%
     *  memory usage: 51.1 MB 42.15% */
    public int missingNumber_1(int[] nums){
        int res = 0, n = nums.length;
        for (int num : nums) {
            res ^= num;
            res ^= n--;
        }
        return res;
    }

    @Test
    void test(){
        int[] a = {3,0,1};
        int[] b = {0,1};
        int[] c = {9,6,4,2,3,5,7,0,1};
        Assertions.assertEquals(2,missingNumber_1(a));
        Assertions.assertEquals(2,missingNumber_1(b));
        Assertions.assertEquals(8,missingNumber_1(c));
    }
}
