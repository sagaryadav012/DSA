package LinkedList;

import java.util.Arrays;
import java.util.List;

public class SwapNodesInPairs_LC24 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        ListNode head = ListNode.construct(list);
        ListNode res = swapPairs(head);
        ListNode.printListNodes(res);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = head, curr = head.next;
        head = curr;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            if(next == null || next.next == null){
                prev.next = next;
                return head;
            }
            prev.next = next.next;
            prev = next;
            curr = prev.next;
        }
        return head;
    }
}
