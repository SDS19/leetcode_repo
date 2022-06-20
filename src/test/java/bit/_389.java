package bit;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _389 {
    /** runtime: 3 ms 49.82%
     *  memory usage: 41.9 MB 67.61% */
    public char findTheDifference(String s, String t) {
        int[] a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']++;
            a[t.charAt(i)-'a']--;
        }
        a[t.charAt(s.length())-'a']--;

        for (int i = 0; i < 26; i++)
            if (a[i] < 0) return (char) ('a'+i);

        return ' ';
    }

    /** runtime: 6 ms 25.35%
     *  memory usage: 40.9 MB 77.80% */
    public char findTheDifference1(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);

        for (char c : t.toCharArray()) {
            Integer val = map.put(c, map.getOrDefault(c,0)-1);
            if (val == null || val == 0) return c;
        }

        return ' ';
    }

    /** runtime: 1 ms 99.87%
     *  memory usage: 42 MB 64.28% */
    public char findTheDifference_1(String s, String t) {
        int sum= 0;
        for (int i : s.toCharArray()) sum += i;
        for (int i : t.toCharArray()) sum -= i;
        return (char) Math.abs(sum);
    }

    public char findTheDifference_11(String s, String t) {
        int sum= 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
            sum -= t.charAt(i);
        }
        sum -= t.charAt(s.length());
        return (char) Math.abs(sum);
    }

    /** runtime: 1 ms 99.87%
     *  memory usage: 42 MB 64.28% */
    public char findTheDifference_2(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray())
            c ^= cs;
        for (char ts : t.toCharArray())
            c ^= ts;
        return c;
    }

    @Test
    void test(){
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference_2(s,t));
    }
}
