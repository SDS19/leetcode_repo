package ds.ArrayList;

import java.util.Arrays;

public class A_88 {
    /** runtime: 2 ms 13.88%
     *  memory usage: 43.5 MB 5.54% */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++)
            nums1[m+i] = nums2[i];
        Arrays.sort(nums1);
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 42.2 MB 89.14% */
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while (i >= 0 && j >= 0)
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 42.8 MB 44.38% */
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m-1, j = n-1, k = m+n-1; j >= 0; k--) {
            if (i >= 0 && nums1[i] > nums2[j]) nums1[k] = nums1[i--];
            else nums1[k] = nums2[j--];
        }
    }
}
