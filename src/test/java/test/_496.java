package test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _496 {
    /** runtime: 8 ms 18.39%
     *  memory usage: 43.8 MB 65.62% */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            a:for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int p = j+1;
                    while (p < nums2.length) {
                        if (nums2[p] > nums2[j]) {
                            list.add(nums2[p]);
                            break a;
                        }
                        p++;
                    }
                    list.add(-1);
                    break a;
                }
            }
        }

        int i = 0;
        for (Integer num : list)
            ans[i++] = num;

        return ans;
    }

    /** runtime: 7 ms 27.18%
     *  memory usage: 44 MB 59.63% */
    public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int p = -1, j = nums2.length-1;
            while (j >= 0 && nums2[j] != nums1[i]) {
                if (nums2[j] > nums1[i])
                    p = nums2[j];
                j--;
            }
            ans[i] = p;
        }

        return ans;
    }

    @Test
    void test(){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(nextGreaterElement(nums1,nums2));
    }

}
