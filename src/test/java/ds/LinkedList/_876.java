package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _876 {

    public ListNode middleNode_1(ListNode head){
        int size = 0;
        ListNode node = head;
        while (node!=null) {
            node = node.next;
            size++;
        }

        for (int i = 0; i < size>>1; i++) head = head.next;

        return head;
    }

    public ListNode middleNode_2(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode node_5 = new ListNode(5);
    private ListNode node_4 = new ListNode(4,node_5);
    private ListNode node_3 = new ListNode(3,node_4);
    private ListNode node_2 = new ListNode(2,node_3);
    private ListNode node_1 = new ListNode(1,node_2);

    @Test
    void test(){
        Assertions.assertEquals(3,middleNode_1(node_1).val);
        Assertions.assertEquals(4,middleNode_1(node_2).val);
        Assertions.assertEquals(3,middleNode_2(node_1).val);
        Assertions.assertEquals(4,middleNode_2(node_2).val);
    }
}
