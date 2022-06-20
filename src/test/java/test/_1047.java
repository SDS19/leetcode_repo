package test;

import java.util.Stack;

public class _1047 {
    /** runtime: 76 ms 42.60%
     *  memory usage: 53.7 MB 45.15% */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c:s.toCharArray()) {
            if (!stack.empty() && c == stack.peek()) stack.pop();
            else stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c:stack) sb.append(c);
        return sb.toString();
    }

    /** runtime: 6 ms 96.62%
     *  memory usage: 49.6 MB 54.62% */
    public String removeDuplicates_1(String s) {
        char[] stack = new char[s.length()];

        int p = 0;
        for (char c:s.toCharArray()) {
            if (p>0 && c==stack[p-1]) p--;
            else stack[p++] = c;
        }

        return new String(stack,0,p);
    }

    /** runtime: 16 ms 75.71%
     *  memory usage: 49.7 MB 54.62% */
    public String removeDuplicates_2(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c:s.toCharArray()) {
            int size = sb.length();
            if (size>0 && c==sb.charAt(size-1)) sb.deleteCharAt(size-1);
            else sb.append(c);
        }

        return sb.toString();
    }


}
