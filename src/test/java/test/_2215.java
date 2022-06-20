package test;

import org.junit.jupiter.api.Test;

import java.util.*;

/** Constraints: -1000 <= nums1[i],nums2[i] <= 1000 */
public class _2215 {
    /** runtime: 19 ms 60.73%
     *  memory usage: 54.1 MB 79.79% */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int i : nums1)
            m1.put(i, m1.getOrDefault(i,0)+1);
        for (int i : nums2)
            m2.put(i, m2.getOrDefault(i,0)+1);

        for (Integer k : m1.keySet())
            if (m2.get(k) == null) answer.get(0).add(k);
        for (Integer k : m2.keySet())
            if (m1.get(k) == null) answer.get(1).add(k);

        return answer;
    }

    /** runtime: 16 ms 77.82%
     *  memory usage: 54.9 MB 51.96% */
    public List<List<Integer>> findDifference_1(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int i : nums1) s1.add(i);
        for (int i : nums2) s2.add(i);

        for (int i : s1)
            if (!s2.contains(i)) answer.get(0).add(i);
        for (int i : s2)
            if (!s1.contains(i)) answer.get(1).add(i);

        return answer;
    }

    /** runtime: 8 ms 96.18%
     *  memory usage: 54.5 MB 68.91% */
    public List<List<Integer>> findDifference_3(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        boolean[] freq1 = new boolean[1001], freq2 = new boolean[1001];
        boolean[] freq1N = new boolean[1001], freq2N = new boolean[1001];

        for (int i : nums1)
            if (i > 0) freq1[i] = true;
            else freq1N[-i] = true;
        for (int i : nums2)
            if (i > 0) freq2[i] = true;
            else freq2N[-i] = true;

        for (int i = 0; i < 1001; i++) {
            if (freq1[i] && !freq2[i]) answer.get(0).add(i);
            else if (!freq1[i] && freq2[i]) answer.get(1).add(i);
            if (freq1N[i] && !freq2N[i]) answer.get(0).add(-i);
            else if (!freq1N[i] && freq2N[i]) answer.get(1).add(-i);
        }

        return answer;
    }
    @Test
    void test(){
        int[] a = {-51,-21,-15,-22};
        int[] b = {60,-38,-24,12,-53,24,-12,37,-73,-11};
        List<List<Integer>> list = findDifference_3(a,b);
    }

}
