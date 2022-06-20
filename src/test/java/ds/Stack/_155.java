package ds.Stack;

import java.util.Stack;

/** save the "new min" and "old min" */
public class _155 {
    /** runtime: 5 ms 78.72%
     *  memory usage: 48.5 MB 41.07% */
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x){
        if (x <= min) {//push twice: old min + new min
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop(){
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();//update the new min
        } else stack.pop();
    }
    public void pop_new(){
        if (stack.pop() == min) min = stack.pop();//pop twice: new min + old min
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min;
    }

    /** runtime: 4 ms 92.38%
     *  memory usage: 44.1 MB 86.85% */
    Stack<Integer> stk, minStk;

    public _155(){
        stk = new Stack<>();
        minStk = new Stack<>();
    }

    public void push1(int x){
        stk.push(x);
        if (minStk.empty()) minStk.push(x);
        else if (x <= minStk.peek()) minStk.push(x);
    }

    public void pop1(){
        int p = stk.pop();
        if (p == minStk.peek()) minStk.pop();
    }

    public int top1(){
        return stk.peek();
    }

    public int getMin1(){
        return minStk.peek();
    }

    Integer min2;
    Stack<Integer> stack2 = new Stack<>();

    public void push2(int x){
        if (stack2.empty()) {
            stack2.push(0);
            min2 = x;
        } else {
            stack2.push(x - min2);
            if (x < min2) min2 = x;
        }
    }

    public void pop2(){
        if (stack2.empty()) return;
        int p = stack2.pop();
        if (p < 0) min = min - p;
    }

    public int top2(){
        int t = stack2.peek();
        if (t > 0) return min + t;
        else return min2;
    }

    public int getMin2(){
        return min2;
    }
}
