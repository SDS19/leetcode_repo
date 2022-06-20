package ds.Stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/** operand: integer or expression */
public class _150 {
    /** runtime: 6 ms 80.60%
     *  memory usage: 42 MB 88.14% */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);

        Stack<Integer> stack = new Stack<>();

        for (String s:tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Integer.valueOf(s));
            } else {
                Integer a = stack.pop(), b = stack.pop();
                if (s.equals("+")) stack.push(b+a);
                else if (s.equals("-")) stack.push(b-a);
                else if (s.equals("*")) stack.push(b*a);
                else stack.push(b/a);
            }
        }
        return stack.pop();
    }

    /** runtime: 7 ms 67.87%
     *  memory usage: 43.6 MB 68.92% */
    public int evalRPN_1(String[] tokens) {
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);

        Stack<Integer> stack = new Stack<>();

        for (String s:tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop()+stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    Integer a = stack.pop(), b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }

    /** runtime: 2 ms 99.94%
     *  memory usage: 42.1 MB 81.22% */
    public int evalRPN_2(String[] tokens) {
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);

        //运算符优先级：算术运算>移位运算>位运算 (tokens.length>>1)+1 == tokens.length/2+1
        int[] a = new int[tokens.length/2+1];

        int i = 0;//pointer
        for (String token:tokens) {
            switch (token) {
                case "+":
                    a[i-2] += a[--i];
                    break;
                case "-":
                    a[i-2] -= a[--i];
                    break;
                case "*":
                    a[i-2] *= a[--i];
                    break;
                case "/":
                    a[i-2] /= a[--i];
                    break;
                default:
                    a[i++] = Integer.valueOf(token);
                    break;
            }
        }
        return a[0];
    }

    @Test
    void test(){
        //["2","1","+","3","*"]
        String[] t1 = {"2","1","+","3","*"};
        String[] t2 = {"4","13","5","/","+"};
        String[] t3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN_2(t1));
    }
}
