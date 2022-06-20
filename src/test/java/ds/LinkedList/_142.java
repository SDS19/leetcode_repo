package ds.LinkedList;

import ds.ListNode;

import java.util.HashSet;

public class _142 {

    /** x: length from head to start point | y: length of cycle | k: length from start point to meet point
     * slow: s = x + ny + k | fast: 2s = x + my + k => x + k = (m-2n)y
     * the length from meet point to start point is x
     *
     * runtime: 0 ms 100.00%
     * memory usage: 45.1 MB 47.20%
     */
    public ListNode detectCycle_1(ListNode head){
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head, curr = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (curr != slow) {
                    curr = curr.next;
                    slow = slow.next;
                }
                return curr;
            };
        }
        return null;
    }

    /**
     * runtime: 4 ms 17.02%
     * memory usage: 46.3 MB 10.07%
     */
    public ListNode detectCycle_2(ListNode head){
        if (head == null || head.next == null) return null;

        HashSet nodes = new HashSet();
        ListNode curr = head;

        while (curr != null) {
            if (nodes.contains(curr)) return curr;
            nodes.add(curr);
            curr = curr.next;
        }

        return null;
    }
}
