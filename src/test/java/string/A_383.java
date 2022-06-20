package string;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class A_383 {
    /** runtime: 4 ms 77.55%
     *  memory usage: 45.7 MB 64.25% */
    public boolean canConstruct(String a, String b) {
        int[] count = new int[26];
        for (char c : a.toCharArray())
            count[c-'a']++;

        for (char c : b.toCharArray())
            count[c-'a']--;

        for (int i : count)
            if (i > 0) return false;

        return true;
    }

    /** runtime: 22 ms 35.88%
     *  memory usage: 53.4 MB 11.98% */
    public boolean canConstruct1(String a, String b) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : b.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : a.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }

        return true;
    }

    /** runtime: 2 ms 99.41%
     *  memory usage: 42.9 MB 82.01% */
    public boolean canConstruct_1(String a, String b) {
        int[] count = new int[26];
        for (char c : b.toCharArray())
            count[c-'a']++;

        for (char c : a.toCharArray())
            if (--count[c-'a'] < 0) return false;

        return true;
    }


    @Test
    void test() {
        String a = "aab", b = "bab";
        System.out.println(canConstruct(a,b));
    }
}
