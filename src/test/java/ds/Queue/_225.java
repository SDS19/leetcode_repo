package ds.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a LIFO stack using only two queues.
 * push, top, pop, empty
 */
public class _225 {

    /** runtime: 0 ms 100.00%
     *  memory usage: 40.2 MB 83.90% */
    private Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);

        //poll(): retrieves and removes the head (first element) of this list.
        int n = q.size();
        while (n-- > 1) q.add(q.poll());
    }

    //remove and return the element on the top of the stack
    public int pop() {
        return q.poll();
    }

    //return the element on the top of the stack
    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }


}
