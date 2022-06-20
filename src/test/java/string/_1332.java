package string;

/** palindrome + subsequence */
public class _1332 {
    /** runtime: 0 ms 100.00%
     *  memory usage: 40.2 MB 83.68% */
    public int removePalindromeSub_1(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return 2;
        return 1;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 39.8 MB 97.57% */
    public int removePalindromeSub_2(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString()) ? 1 : 2;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 41.6 MB 59.72% */
    public int removePalindromeSub_3(String s) {
        for (int i = 0; i < s.length()/2; i++)
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return 2;
        return 1;
    }

}
