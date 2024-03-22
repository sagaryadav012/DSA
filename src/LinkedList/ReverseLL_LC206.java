package LinkedList;

import java.util.Arrays;
import java.util.List;

public class ReverseLL_LC206 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        ListNode head = ListNode.construct(list);
     //   ListNode.printListNodes(head);
        ListNode resNode = reverseList(head);
        ListNode.printListNodes(resNode);

    }
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return  prev;
    }
}

/*
            1 -> 2 -> 3 -> 4 -> 5 -> null
    null <- 1 <- 2 <- 3 <- 4 <- 5

    To reverse LL, Change pointers.

-> curr = head i.e. 1
-> First Take null node as prev
-> connect to curr.next, if do that we lost curr.next node so store curr.next
-> node next = curr.next
-> now connect prev to curr.next
-> move prev to curr
-> move curr = curr.next
-> do this until reverse the list.
 */
