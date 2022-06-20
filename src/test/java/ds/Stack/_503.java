package ds.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _503 {
    /** runtime: 69 ms 10.58%
     *  memory usage: 54.8 MB 49.76% */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        a:for (int i = 0; i < n; i++) {
            int p = 0;
            if (i < n-1) p = i + 1;
            while (true) {
                if (nums[p] > nums[i]) {
                    ans[i] = nums[p];
                    continue a;
                }
                if (p++ == n-1) p = 0;
                if (p == i) break;
            }
            ans[i] = -1;
        }

        return ans;
    }

    /** runtime: 39 ms 57.50%
     *  memory usage: 55.5 MB 15.82% */
    public int[] nextGreaterElements_1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >= 0; i--)
            stack.push(nums[i]);

        for (int i = nums.length-1; i >= 0; i--) {
            int num = nums[i];
            while (!stack.empty() && stack.peek() <= num)
                stack.pop();
            nums[i] = stack.empty() ? -1 : stack.peek();
            stack.push(num);
        }

        return nums;
    }

    /** runtime: 35 ms 67.07%
     *  memory usage: 54.7 MB 59.50% */
    public int[] nextGreaterElements_2(int[] nums) {
        int[] ans = new int[nums.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[stack.peek()] < nums[i]) {
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
        }

        while (!stack.empty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }

        return ans;
    }

    @Test
    void test(){
        int[] nums1 = {1,2,1};
        int[] nums2 = {1,2,3,4,3};
        int[] nums3 = {1,2,3,4,5};
        int[] nums4 = {5,4,3,2,1};
        //Assertions.assertArrayEquals(new int[] {2,-1,2},nextGreaterElements(nums1));
        Assertions.assertArrayEquals(new int[] {2,3,4,-1,4},nextGreaterElements_1(nums2));
        Assertions.assertArrayEquals(new int[] {2,3,4,5,-1},nextGreaterElements(nums3));
        Assertions.assertArrayEquals(new int[] {-1,5,5,5,5},nextGreaterElements(nums4));
    }
}
