package ds.Set;

import java.util.*;

public class _349 {

    /** runtime: 2 ms 95.25%
     *  memory usage: 43.3 MB 68.13% */
    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();

        int[] count = new int[1001];
        for (int i : nums1)
            count[i]++;

        for (int i : nums2)
            if (count[i] != 0) set.add(i);

        int i = 0;
        for (int num : set)
            count[i++] = num;
        return Arrays.copyOf(count,set.size());
    }

    /** runtime: 2 ms 95.25%
     *  memory usage: 44.1 MB 41.90% */
    public int[] intersection_1(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();

        for (int i : nums1)
            set.add(i);

        int[] a = new int[set.size()];
        int k = 0;
        for (int i : nums2)
            if (set.remove(i))
                a[k++] = i;

        return Arrays.copyOf(a,k);
    }

    /** runtime: 7 ms 19.47%
     *  memory usage: 44.4 MB 21.93% */
    public int[] intersection_2(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1)
            set1.add(i);

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2)
            set2.add(i);

        set1.retainAll(set2);

        int[] res = new int[set1.size()];
        int i = 0;
        for (int s : set1) res[i++] = s;

        return res;
    }
}
