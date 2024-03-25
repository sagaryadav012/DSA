package LinkedList;

import java.util.Arrays;
import java.util.List;

public class ReOrderList_LC143 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        ListNode head = ListNode.construct(list);
        ListNode res = reorderList(head);
        ListNode.printListNodes(res);
    }
    public static ListNode reorderList(ListNode head) { // TC - O(N) SC - O(N) for new List
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode head1 = head;
        ListNode head2 = prev;

        ListNode dummy = new ListNode(-1);
        curr = dummy;

        while(head2 != null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            curr.next = head1;
            head1.next = head2;
            curr = head2;
            head1 = next1;
            head2 = next2;
        }

        if(head1 != null) curr.next = head1;

        return dummy.next;
    }

}
/*
-> Can do it using list, store all nodes in list and connect first and last nodes and move pointer.
-> connect list.get(i) -> list.get(n-1-i) -> i++ till n/2.
-> This approach takes Tc - O(N) SC - O(N+N) for list and new LL
 */