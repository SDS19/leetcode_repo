package ds.Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _20 {

    /** runtime: 1 ms 99.46%
     *  memory usage: 40.1 MB 95.10% */
    public boolean isValid_1(String s){
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.empty() || stack.pop() != c) return false;
        }
        return stack.empty();
    }

    /** runtime: 1 ms 99.43%
     *  memory usage: 40 MB 94.97% */
    public boolean isValid_2(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);//returns the char value at the specified index
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else if (stack.empty()) return false;
            else if (c == ')' && stack.pop() != '(') return false;
            else if (c == ']' && stack.pop() != '[') return false;
            else if (c == '}' && stack.pop() != '{') return false;
        }
        return stack.empty();
    }
    /** runtime: 47 ms 6.25%
     *  memory usage: 42.2 MB 31.24% */
    public boolean isValid_3(String s){
        int length;
        do{
            length = s.length();
            s = s.replace("()","").replace("[]","").replace("{}","");
        } while (length != s.length());
        return s.length() == 0;
    }

    @Test
    void test(){
        /** 1. Open brackets must be closed by the same type of brackets.
            2. Open brackets must be closed in the correct order. */
        String s1 = "()[]{}";//true
        String s2 = "]{}";//false
        String s3 = "([)]";//false
        String s4 = "(({{}}))";//true
        String s5 = "(([{}])}";//false
        Assertions.assertEquals(true,isValid_1(s1));
        Assertions.assertEquals(false,isValid_1(s2));
        Assertions.assertEquals(false,isValid_1(s3));
        Assertions.assertEquals(true,isValid_1(s4));
        Assertions.assertEquals(false,isValid_1(s5));
    }

}
