package test;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/** Implement a FIFO queue using only two stacks. */
public class _232 {

    /** runtime: 1 ms 54.21%
     *  memory usage: 42 MB 38.27% */
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x){
        input.push(x);
    }

    public int pop(){
        peek();
        return output.pop();
    }

    public int peek(){
        if (output.empty()) {//only push element when output is empty
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty(){
        return input.empty() && output.empty();
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 40.2 MB 79.18% */
    //
    private Stack<Integer> queue(){
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output;
    }

    public void push1(int x){
        input.push(x);
    }

    public int pop1(){
        return queue().pop();
    }

    public int peek1(){
        return queue().peek();
    }

    public boolean empty1(){
        return queue().empty();
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 41.9 MB 46.46% */
    //
    public void push2(int x){//if push then output stack is null
        while (!output.empty()) {
            input.push(output.pop());
        }
        input.push(x);
    }

    public int pop2(){
        peek2();
        return output.pop();
    }

    public int peek2(){
        while (!input.empty()) {
            output.push(input.pop());
        }
        return output.peek();
    }

    public boolean empty2(){
        return input.empty() && output.empty();
    }

    @Test
    void test(){
        _232 queue = new _232();
        queue.push(1);
        queue.push(2);
        int peek = queue.peek();
        queue.push(3);
        peek = queue.peek();
        queue.pop();
        queue.empty();
    }
}
