package ds.Set;

import org.junit.jupiter.api.Test;

import java.util.*;

public class _350 {

    /** runtime: 4 ms 59.94%
     *  memory usage: 42.7 MB 73.61% */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        if (nums1.length >= nums2.length)
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) i++;
                else if (nums1[i] > nums2[j]) j++;
                else {
                    list.add(nums2[j]);
                    i++;
                    j++;
                }
            }
        else
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) i++;
                else if (nums1[i] > nums2[j]) j++;
                else {
                    list.add(nums1[i]);
                    i++;
                    j++;
                }
            }
        int[] res = new int[list.size()];
        for (int k = 0; k < res.length; k++)
            res[k] = list.get(k);
        return res;
    }

    /** runtime: 2 ms 95.28%
     *  memory usage: 42.2 MB 91.60% */
    public int[] intersect_1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k =0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }

        return Arrays.copyOf(nums1,k);
    }

    /** runtime: 1 ms 99.50%
     *  memory usage: 44 MB 39.05% */
    public int[] intersect_2(int[] nums1, int[] nums2) {
        int[] map = new int[1001];
        int[] res = new int[Math.min(nums1.length, nums2.length)];

        for (int i : nums1)
            map[i]++;

        int k = 0;
        for (int i : nums2)
            if (map[i] > 0) {
                res[k++] = i;
                map[i]--;
            }

        return Arrays.copyOf(res,k);
    }

    /** runtime: 2 ms 95.28%
     *  memory usage: 44.2 MB 32.92% */
    public int[] intersect_3(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {//frequency
            Integer freq = map.get(i);
            map.put(i, freq == null ? 1 : freq+1);
        }

        for (int i : nums2) {
            Integer freq = map.get(i);
            if (freq != null && freq > 0){//NullPointerException
                list.add(i);
                map.put(i, freq - 1);
            }
        }

        int[] a = new int[list.size()];
        int k = 0;
        for (int i : list) a[k++] = i;

        return a;
    }

    @Test
    void test(){
        int[] a1 = {4,7,9,7,6,7};
        int[] a2 = {5,0,0,6,1,6,2,2,4};
        for (int a:intersect(a1,a2))
            System.out.println(a);
    }
}
