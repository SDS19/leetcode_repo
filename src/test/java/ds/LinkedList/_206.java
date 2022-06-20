package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Test;

public class _206 {

    public ListNode reverseList_i (ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next_node = head.next;
            head.next = prev;
            prev = head;
            head = next_node;
        }
        return prev;
    }

    public ListNode reverseList_r(ListNode head){
        return reverse(null,head);
    }
    private ListNode reverse(ListNode prev, ListNode curr){
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverse(curr, next);
    }

    /** runtime: 0 ms 100.00%
     *  memory usage: 43.3 MB 21.27% */
    public ListNode reverse_i (ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /** recursive
     *  time  complexity: O(n)
     *  space complexity: O(n)
     */
    public ListNode reverse_r (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse_r(head.next);
        head.next.next = head; //build the new reference
        head.next = null; //delete original reference
        return newHead;
    }

    @Test
    void test(){
        /** 1->2->3->4->5
         * head: 1 head.next: 2
         */
        ListNode node_5 = new ListNode(5);
        ListNode node_4 = new ListNode(4,node_5);
        ListNode node_3 = new ListNode(3,node_4);
        ListNode node_2 = new ListNode(2,node_3);
        ListNode head = new ListNode(1,node_2);

        System.out.println(reverse_r(head).val);
    }



}
