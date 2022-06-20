package string;

import org.junit.jupiter.api.Test;

public class _58 {
    /** runtime: 1 ms 50.97%
     *  memory usage: 42.1 MB 58.32% */
    public int lengthOfLastWord_1(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 42 MB 58.32% */
    public int lengthOfLastWord_2(String s) {
        int len = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ') len++;
            else if (len > 0) return len;
        }

        return len;
    }

    @Test
    void test(){
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord_2(s));
    }
}
