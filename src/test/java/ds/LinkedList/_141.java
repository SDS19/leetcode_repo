package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Test;

public class _141 {

    /** cycle detection: tortoise and hare (start point, meeting point)
     *  2 * slow length = fast length
     *  runtime: 0 ms 100%
     *  memory usage: 46.4 MB 24.19%
     */
    public boolean hasCycle_1(ListNode head){
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    /** runtime: 0 ms 100%
     *  memory usage: 43.7 MB 82.00% */
    public boolean hasCycle_2(ListNode head){
        if (head == null || head.next == null) return false;

        if (head.next == head) return true;

        ListNode next = head.next;
        head.next = head;

        return hasCycle_2(next);
    }

    /** runtime: 2 ms 20.10%
     *  memory usage: 45.2 MB 72.53% */
    public boolean hasCycle_3(ListNode head){
        int count = 0;
        while (head != null) {
            head = head.next;
            if (++count == 10001) return true;
        }
        return false;
    }

    @Test
    void test() {
        ListNode head = new ListNode(1, null);
        System.out.println(hasCycle_1(head));
    }


}
