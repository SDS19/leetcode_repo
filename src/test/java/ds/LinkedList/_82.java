package ds.LinkedList;

import ds.ListNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class _82 {
    /** runtime: 5 ms 6.02%
     *  memory usage: 44.6 MB 5.48% */
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        ListNode prev = new ListNode(0);
        curr = prev;
        for(Integer key : map.keySet())
            if (map.get(key) == 1) {
                curr.next = new ListNode(key);
                curr = curr.next;
            }

        return prev.next;
    }

    @Test
    void test() {
        ListNode list6 = new ListNode(5);
        ListNode list5 = new ListNode(4,list6);
        ListNode list4 = new ListNode(4,list5);
        ListNode list3 = new ListNode(3,list4);
        ListNode list2 = new ListNode(3,list3);
        ListNode list1 = new ListNode(2,list2);
        ListNode head = new ListNode(1,list1);

        System.out.println(deleteDuplicates(head));

    }
}
