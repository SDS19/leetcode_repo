package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _92 {

    public ListNode reverseBetween_1(ListNode head, int left, int right){
        if (head==null) return null;
        if (head.next == null || left==right) return head;

        ListNode anchor = new ListNode(0);
        anchor.next = head;

        //start from anchor for (1,n) case
        ListNode prev = anchor;
        for (int i = 0; i < left-1; i++) prev = prev.next;

        ListNode start = prev.next;
        ListNode next = start.next;

        for (int i = 0; i < right-left; i++) {
            start.next = next.next;
            next.next = prev.next;//move "next" to the prev.next
            prev.next = next;
            next = start.next;//move next forward
        }

        return anchor.next;
    }

    public ListNode reverseBetween_2(ListNode head, int left, int right){
        if (head==null) return null;
        if (head.next == null || left==right) return head;

        ListNode anchor = new ListNode(0);
        anchor.next = head;

        int i = 1;
        ListNode prev = anchor;
        ListNode curr = head;
        ListNode next;

        while (i < left) {//"curr" points to the start node
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode node = prev;
        while (i <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        //reconnect the start node and end node
        node.next.next = curr;
        node.next = prev;

        return anchor.next;
    }

    public ListNode reverseBetween_3(ListNode head, int left, int right){

        //prev node before start node
        ListNode a = head;
        for (int i = 1 ; i < left-1; i++) a = a.next;

        ListNode l = null;
        if (a.next!=null) l = a.next;

        ListNode r = l;
        for (int i = left; i < right; i++) r = r.next;

        ListNode b = null;
        if (r!=null) b = r.next;

        ListNode prev = null;
        ListNode curr = l;
        ListNode next = null;
        while (next != b) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        a.next = r;
        l.next = b;

        return head;
    }


    /****************************** Test ******************************/

    //1 -> 2 -> 3 -> 4 -> 5
    private ListNode node_5 = new ListNode(5);
    private ListNode node_4 = new ListNode(4,node_5);
    private ListNode node_3 = new ListNode(3,node_4);
    private ListNode node_2 = new ListNode(2,node_3);
    private ListNode node_1 = new ListNode(1,node_2);

    private void print(int left,int right) {
        ListNode node = reverseBetween_2(node_1,left,right);
        for (int i = 0; i < 5; i++) {
            if (i!=4) System.out.print(node.val+",");
            else System.out.println(node.val);
            node = node.next;
        }
    }

    @Test
    void test_1(){
        print(1,1);
    }

    @Test
    void test_2(){
        print(2,4);
    }

    @Test
    void test_3(){
        print(1,5);
    }



    //1
    private ListNode head_single = new ListNode(1,null);

    @Test//(1,1)
    void test_4(){
        ListNode node = reverseBetween_1(head_single,1,1);
        Assertions.assertEquals(1,node.val);
    }
}
