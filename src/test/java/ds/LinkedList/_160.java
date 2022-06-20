package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Constraints:
 * The number of nodes of listA is m, listB is n
 * 1 <= m, n <= 30000
 */
public class _160 {
    /**
     *  time complexity: O(m*n)
     *  space complexity: O(1)
     */
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB){
        ListNode a = headA;
        while (a != null) {
            ListNode b = headB;
            while (b != null) {
                if (a == b) return a;
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }

    /**
     *  time complexity: O(m+n)
     *  space complexity: O(1)
     *
     *  case 1: have intersection & same length
     *  case 2: have intersection & different length
     *  case 3: no intersection & same length
     *  case 4: no intersection & different length
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    /**
     * runtime: 1ms 98.87%
     * memory usage: 55.8MB 19.53%
     */
    public ListNode getIntersectionNode_21(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;

        ListNode a = headA, b = headB;

        int m = 0, n = 0;
        while (a != null) {
            m++;
            a = a.next;
        }
        while (b != null) {
            n++;
            b = b.next;
        }

        a = headA;
        b = headB;
        if (m > n) for (int i = 0; i < m-n; i++) a = a.next;
        else for (int i = 0; i < n-m; i++) b = b.next;

        while (a!=b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    /** find the 1/2 length of m+n
     *  time complexity: O(n)  runtime: 2ms 46.80%
     *  space complexity: O(1) memory usage: 54.8MB 62.74%
     */
    public ListNode getIntersectionNode_3(ListNode headA, ListNode headB){
        if (headA == null || headB == null) return null;

        ListNode lastA = headA;
        while (lastA.next != null) lastA = lastA.next;
        lastA.next = headB;

        ListNode start = null;
        ListNode slow = headA, fast = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                start = headA;
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                break;
            }
        }

        lastA.next = null;
        return start;
    }


    /**
     * A:      4 -> 1 ->
     *                  8 -> 4 -> 5
     * B: 5 -> 6 -> 1 ->
     */
    private ListNode node_5 = new ListNode(5,null);
    private ListNode node_4 = new ListNode(4,node_5);
    private ListNode node_8 = new ListNode(8,node_4);

    private ListNode node_A_1 = new ListNode(1,node_8);
    private ListNode head_A = new ListNode(4,node_A_1);

    private ListNode node_B_1 = new ListNode(1,node_8);
    private ListNode node_B_6 = new ListNode(6,node_B_1);
    private ListNode head_B = new ListNode(5,node_B_6);

    @Test
    void test_1(){
        Assertions.assertEquals(8,getIntersectionNode_21(head_A,head_B).val);
    }

    /**
     * A: 1 -> 9 -> 1 ->
     *                  2 -> 4
     * B:           3 ->
     */
    private ListNode n2_4 = new ListNode(4,null);
    private ListNode n2_2 = new ListNode(2,n2_4);

    private ListNode n2_A_1 = new ListNode(1,n2_2);
    private ListNode n2_A_9 = new ListNode(9,n2_A_1);
    private ListNode h2_A = new ListNode(1,n2_A_9);

    private ListNode h2_B = new ListNode(3,n2_2);

    @Test
    void test_2(){
        Assertions.assertEquals(2,getIntersectionNode_21(h2_A,h2_B).val);
    }

    /**
     * A: 2 -> 6 -> 4
     * B: 1 -> 5
     */
    private ListNode n3_A_4 = new ListNode(4,null);
    private ListNode n3_A_6 = new ListNode(6,n3_A_4);
    private ListNode h3_A = new ListNode(2,n3_A_6);

    private ListNode n3_B_5 = new ListNode(5,null);
    private ListNode h3_B = new ListNode(1,n3_B_5);

    @Test
    void test_3(){
        Assertions.assertEquals(null,getIntersectionNode_21(h3_A,h3_B));
    }
}
