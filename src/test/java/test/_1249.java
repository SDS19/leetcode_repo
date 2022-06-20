package test;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Stack;

public class _1249 {

    /** open>0 => ( remains
     *  open=0 => valid
     *  runtime: 7 ms 99.39%
     *  memory usage: 42.7 MB 92.99% */
    public String minRemoveToMakeValid_1(String s) {
        char[] a = s.toCharArray();

        int open = 0;//num of '('
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') open++;
            else if (a[i] == ')') {
                if (open > 0) open--;
                else a[i] = '*';//mark the remaining ) as *
            }
        }

        if (open > 0) {
            for (int i = a.length-1; i >= 0; i--) {//mark the remaining ( as *
                if (open > 0 && a[i] == '(') {
                    a[i] = '*';
                    open--;
                }
            }
        }

        int p = 0;
        for (char c:a) if (c != '*') a[p++] = c;

        return new String(a,0,p);
    }

    /** push the index of remaining parentheses into stack
     *  runtime: 75 ms 11.25%
     *  memory usage: 53.8 MB 39.15% */
    public String minRemoveToMakeValid_2(String s) {
        Stack<Integer> stack = new Stack<>();

        //push the index of remaining parenthesis into stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) continue;
            if (c == '(') stack.push(i);
            else {
                if (!stack.empty() && s.charAt(stack.peek())=='(') stack.pop();
                else stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(stack);
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    /** runtime: 8 ms 98.88%
     *  memory usage: 50.6 MB 61.09% */
    public String minRemoveToMakeValid_21(String s) {
        char[] charArr = s.toCharArray();

        int[] stack = new int[s.length()];

        int i, open = 0;//num of '('
        for (i = 0; i < s.length(); i++) {
            if (charArr[i] == '(') stack[open++] = i;//count the num of remaining '('
            else if (charArr[i] == ')') {
                if (open > 0) open--;
                else charArr[i] = '*';//mark the remaining ')' as '*'
            }
        }

        stack[open] = -1;
        open = i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (charArr[j] != '*') charArr[i++] = charArr[j];
            else if (j == stack[open]) open++;
        }

        return new String(charArr,0,i);
    }

    @Test
    void test(){
        String s1 = "lee(t(c)o)de)";
        String s2 = "a)b(c)d";
        String s3 = "))((";
        System.out.println(minRemoveToMakeValid_21(s1));
    }
}
