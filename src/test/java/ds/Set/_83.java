package ds.Set;

import ds.ListNode;

import java.util.LinkedHashSet;
import java.util.Set;

public class _83 {
    /** runtime: 4 ms 6.09%
     *  memory usage: 44.3 MB 34.42% */
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new LinkedHashSet<>();
        while (head != null) {
            set.add(head.val);
            head = head.next;
        }

        ListNode prev = new ListNode(0);
        ListNode curr = prev;
        for (int i : set) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return prev.next;
    }

    /** runtime: 1 ms 69.65%
     *  memory usage: 44.2 MB 41.14% */
    public ListNode deleteDuplicates_1(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null)
            if (curr.val == curr.next.val) curr.next = curr.next.next;
            else curr = curr.next;
        return head;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 41.6 MB 98.57% */
    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
