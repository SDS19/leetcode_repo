package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _203 {
    /** runtime: 6 ms 15.42%
     *  memory usage: 50.6 MB 5.62% */
    public ListNode removeElements(ListNode head, int val) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        ListNode prev = new ListNode(0);
        curr = prev;
        for (Integer i : list) {
            if (i != val) {
                curr.next = new ListNode(i);
                curr = curr.next;
            }
        }
        return prev.next;
    }

    /** runtime: 1 ms 98.34%
     *  memory usage: 42.8 MB 96.20% */
    public ListNode removeElements_1(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements_1(head.next, val);
        return head.val == val ? head.next : head;
    }

    @Test
    void test(){
        ListNode node_7 = new ListNode(6);
        ListNode node_6 = new ListNode(5,node_7);
        ListNode node_5 = new ListNode(4,node_6);
        ListNode node_4 = new ListNode(3,node_5);
        ListNode node_3 = new ListNode(6,node_4);
        ListNode node_2 = new ListNode(2,node_3);
        ListNode head = new ListNode(1,node_2);

        removeElements(head,6);
    }
}
