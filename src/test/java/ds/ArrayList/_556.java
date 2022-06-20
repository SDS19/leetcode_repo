package ds.ArrayList;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _556 {
    /** runtime: 0 ms 100.00%
     *  memory usage: 39.1 MB 85.53% */
    public int nextGreaterElement_1(int n) {
        char[] chars = String.valueOf(n).toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = chars.length-2;
        while (i >= 0 && chars[i] >= chars[i+1])
            i--;
        if (i == -1) return -1;

        int j = chars.length-1;
        while (chars[j] <= chars[i])
            j--;

        swap(chars, i, j);

        for (int k = 0; k <= i; k++)
            sb.append(chars[k]);

        for (int k = chars.length-1; k > i; k--)
            sb.append(chars[k]);

        long res = Long.valueOf(sb.toString());

        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    private void swap(char[] chr, int i, int j) {
        char tmp = chr[i];
        chr[i] = chr[j];
        chr[j] = tmp;
    }

    /** runtime: 0 ms 100.00% 159214SDSsds
     *  memory usage: 39.1 MB 85.53% */
    public int nextGreaterElement_2(int n) {
        char[] chars = String.valueOf(n).toCharArray();

        int i = chars.length-2;
        while (i >= 0 && chars[i] >= chars[i+1]) i--;
        if (i == -1) return -1;

        int j = chars.length-1;
        while (chars[j] <= chars[i]) j--;

        swap(chars, i, j);

        Arrays.sort(chars, i+1, chars.length);

        long res = Long.valueOf(new String(chars));

        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    @Test
    void test(){
        int n = 6537421;
        System.out.println(nextGreaterElement_1(n));
    }
}
