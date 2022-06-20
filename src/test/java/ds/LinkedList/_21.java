package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _21 {
    /** runtime: 2 ms 5.29%
     *  memory usage: 43.7 MB 11.34% */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        int i = 0;
        int[] a = new int[100];
        while (i < 100) a[i++] = 101;

        i = 0;
        ListNode curr = list1;
        while (curr != null) {
            a[i++] = curr.val;
            curr = curr.next;
        }

        curr = list2;
        while (curr != null) {
            a[i++] = curr.val;
            curr = curr.next;
        }

        Arrays.sort(a);

        ListNode head = new ListNode(a[0]);
        curr = head;
        for (int j = 1; j < i; j++) {
            curr.next = new ListNode(a[j]);
            curr = curr.next;
        }

        return head;
    }

    /** runtime: 1 ms 70.29%
     *  memory usage: 42.8 MB 63.36% */
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode curr = prev;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return prev.next;
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 41.8 MB 89.02% */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_1(l1, l2.next);
            return l2;
        }
    }

    @Test
    void test() {
        ListNode list12 = new ListNode(4);
        ListNode list11 = new ListNode(2,list12);
        ListNode list10 = new ListNode(1,list11);

        ListNode list22 = new ListNode(4);
        ListNode list21 = new ListNode(3,list22);
        ListNode list20 = new ListNode(1,list21);

        mergeTwoLists_1(list10, list20);
    }
}
