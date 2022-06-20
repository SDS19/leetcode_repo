package string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class A_242 {
    /** runtime: 3 ms 92.75%
     *  memory usage: 44 MB 45.59% */
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c-'a']++;

        for (char c : t.toCharArray())
            count[c-'a']--;

        for(int i : count)
            if (i != 0) return false;

        return true;
    }
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int i : count)
            if (i != 0) return false;

        return true;
    }
    /** runtime: 3 ms 92.75%
     *  memory usage: 43.9 MB 47.77% */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c-'a']++;

        for (char c : t.toCharArray())
            if (--count[c-'a'] < 0) return false;

        return true;
    }

    /** runtime: 8 ms 46.07%
     *  memory usage: 44.9 MB 36.68% */
    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);

        for (int i = 0; i < s_chars.length; i++)
            if (s_chars[i] != t_chars[i]) return false;

        return true;
    }
    /** runtime: 5 ms 70.03%
     *  memory usage: 45.2 MB 30.53% */
    public boolean isAnagram_11(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();
        Arrays.sort(s_chars);
        Arrays.sort(t_chars);

        return new String(s_chars).equals(new String(t_chars));
    }

    @Test
    void test() {
        String s = "ab", t = "a";
        System.out.println(isAnagram(s,t));
    }
}
