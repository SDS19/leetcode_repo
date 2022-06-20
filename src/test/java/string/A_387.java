package string;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class A_387 {
    /** runtime: 5 ms 98.16%
     *  memory usage: 42.3 MB 98.74% */
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c-'a']++;

        for (int i = 0; i < s.length(); i++)
            if (count[s.charAt(i)-'a'] == 1) return i;

        return -1;
    }

    /** runtime: 44 ms 35.53%
     *  memory usage: 54.3 MB 20.34% */
    public int firstUniqChar1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1) return i;

        return -1;
    }

    /** runtime: 2 ms 99.60%
     *  memory usage: 48.1 MB 69.83% */
    public int firstUniqChar_1(String s) {
        int res = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            int idx = s.indexOf(i);
            if (idx != -1 && idx == s.lastIndexOf(i))
                res = Math.min(res, idx);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /** runtime: 26 ms 64.50%
     *  memory usage: 50.4 MB 41.04% */
    public int firstUniqChar_11(String s) {
        for (char c : s.toCharArray()) {
            int idx = s.indexOf(c);
            if (idx == s.lastIndexOf(c)) return idx;
        }
        return -1;
    }

    @Test
    void test() {
        String s = "leetcode";
        System.out.println(firstUniqChar_1(s));
    }
}
