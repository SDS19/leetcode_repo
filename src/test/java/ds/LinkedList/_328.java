package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class _328 {

    /**
     * runtime: 0 ms 100.00%
     * memory usage: 41.7 MB 89.45%
     */
    public ListNode oddEvenList_1(ListNode head){
        //case: null | 1 | 1 -> 2
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode anchor = new ListNode(0);
        anchor.next = head;

        int i = 0;
        ListNode even = head.next;

        ListNode curr = head;
        ListNode next;
        while (curr.next.next != null) {
            next = curr.next;
            curr.next = curr.next.next;
            curr = next;
            i++;
        }

        if (i%2==0) curr.next = even;
        else {
            curr.next.next = even;
            curr.next = null;
        }

        return anchor.next;
    }

    /**
     * runtime: 0 ms 100.00%
     * memory usage: 43.8 MB 71.40%
     */
    public ListNode oddEvenList_2(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList_21(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while (odd.next != null && even.next != null) {
            odd = odd.next = even.next;
            even = even.next = odd.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * runtime: 0 ms 100.00%
     * memory usage: 45.3 MB 14.03%
     */
    public ListNode oddEvenList_3(ListNode head){
        Queue<Integer> queue = new LinkedList<>();
        if (head == null || head.next == null) return head;

        ListNode curr = head, oddHead = null, oddTail = null, evenHead = null, evenTail = null;
        int i = 1;
        while (curr != null) {
            if (i%2!=0) {
                if (oddHead == null) oddTail = oddHead = curr;
                else oddTail = oddTail.next = curr;
            } else {
                if (evenHead == null) evenTail = evenHead = curr;
                else evenTail = evenTail.next = curr;
            }
            curr = curr.next;
            i++;
        }

        evenTail.next = null;
        oddTail.next = evenHead;

        return oddHead;
    }

    //1 -> 2 -> 3 -> 4 -> 5
    ListNode node_5 = new ListNode(5,null);
    ListNode node_4 = new ListNode(4,node_5);
    ListNode node_3 = new ListNode(3,node_4);
    ListNode node_2 = new ListNode(2,node_3);
    ListNode node_1 = new ListNode(1,node_2);

    @Test
    void odd(){
        ListNode node = oddEvenList_2(node_1);
        for (int i = 0; i < 5; i++) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
