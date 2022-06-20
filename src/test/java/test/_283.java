package test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class _283 {
    /** runtime: 59 ms 8.57%
     *  memory usage: 72.6 MB 5.50% */
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums)
            if (num != 0) list.add(num);

        for (int i = 0; i < nums.length; i++) {
            try {
                nums[i] = list.get(i);
            } catch (IndexOutOfBoundsException e) {
                nums[i] = 0;
            }
        }
    }

    /** runtime: 1 ms 100.00%
     *  memory usage: 55.2 MB 13.33% */
    public void moveZeroes_1(int[] nums) {
        int i = 0;
        for (int num : nums)
            if (num != 0) nums[i++] = num;

        while (i < nums.length)
            nums[i++] = 0;
    }

    /** runtime: 2 ms 70.62%
     *  memory usage: 54.9 MB 38.89% */
    public void moveZeroes_2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
    }

    public void moveZeroes_21(int[] nums) {
        int o = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                if (i > o) {
                    nums[o] = nums[i];
                    nums[i] = 0;
                }
                o++;
            }
    }

    @Test
    void test(){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println("a".compareTo("z"));
    }
}
