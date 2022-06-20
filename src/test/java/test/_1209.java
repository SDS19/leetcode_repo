package test;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _1209 {

    /** runtime: 129 ms 19.94%
     *  memory usage: 56.6 MB 13.22% */
    public String removeDuplicates(String s, int k) {

        Stack<Character> charStk = new Stack<>();
        Stack<Integer> countStk = new Stack<>();

        for (char c:s.toCharArray()) {
            if (!charStk.empty() && c==charStk.peek()) countStk.push(countStk.peek()+1);
            else countStk.push(1);

            charStk.push(c);

            if (countStk.peek()==k) {
                for (int i = 0; i < k; i++) {
                    charStk.pop();
                    countStk.pop();
                }
            }
        }

        StringBuilder b = new StringBuilder();
        for (char c:charStk) b.append(c);
        return b.toString();
    }

    /** use StringBuilder as a stack
     *  runtime: 16 ms 88.21%
     *  memory usage: 49.6 MB 58.67% */
    public String removeDuplicates_1(String s, int k) {
        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();

        for (char c:s.toCharArray()) {
            sb.append(c);
            int last = sb.length()-1;
            count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last-1) ? count[last-1] : 0);
            if (count[last] >= k) sb.delete(sb.length()-k,sb.length());
        }

        return sb.toString();
    }

    /** two pointers: i, j
     *  runtime: 9 ms 93.98%
     *  memory usage: 48.8 MB 69.15% */
    public String removeDuplicates_2(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();

        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i-1] == stack[j] ? count[i-1]+1 : 1;
            if (count[i] == k) i -= k;
        }

        return new String(stack,0,i);
    }

    @Test
    void test(){
        String s = "deeedbbcccbdaa";
        System.out.println(removeDuplicates_1(s,3));
    }
}
