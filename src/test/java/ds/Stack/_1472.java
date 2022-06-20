package ds.Stack;

import java.util.Stack;

public class _1472 {

    Stack<String> in = new Stack<>();
    Stack<String> out = new Stack<>();

    public _1472(String homepage) {
        in.push(homepage);
    }

    public void visit(String url) {
        out.clear();//clears up all the forward history
        in.push(url);
    }

    /** runtime: 101 ms 45.97%
     *  memory usage: 50.5 MB 82.46% */
    public String back(int steps) {
        int size = in.size();
        if (steps < size) for (int i = 0; i < steps; i++) out.push(in.pop());
        else for (int i = 1; i < size; i++) out.push(in.pop());
        return in.peek();
    }

    public String forward(int steps) {
        int size = out.size();
        if (steps <= size) for (int i = 0; i < steps; i++) in.push(out.pop());
        else for (int i = 0; i < size; i++) in.push(out.pop());
        return in.peek();
    }

    /** runtime: 133 ms 24.69%
     *  memory usage: 82.6 MB 43.85% */
    public String back_1(int steps){
        while (steps > 0 && in.size() > 1){
            out.push(in.pop());
            steps--;
        }
        return in.peek();
    }

    public String forward_1(int steps){
        while (steps > 0 && out.size() > 0){
            in.push(out.pop());
            steps--;
        }
        return in.peek();
    }

    /** runtime: 54 ms 90.85%
     *  memory usage: 50.4 MB 85.60% */
    class Node {
        Node next;
        Node back;
        String page;

        public Node(String page, Node back){
            this.page = page;
            this.back = back;
            next = null;
        }
    }

    String homepage = "google.com";
    Node curr = new Node(homepage,null);

    public void visit_2(String url){
        if (curr.next != null) curr.next.back = null;//curr = null;
        curr = (curr.next = new Node(url,curr));
    }

    public String back_2(int steps){
        while (steps --> 0 && curr.back != null)
            curr = curr.back;
        return curr.page;
    }

    public String forward_2(int steps){
        while (steps --> 0 && curr.next != null)
            curr = curr.next;
        return curr.page;
    }

}
