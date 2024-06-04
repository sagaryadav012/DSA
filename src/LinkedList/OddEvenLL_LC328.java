package LinkedList;

import java.util.Arrays;
import java.util.List;

public class OddEvenLL_LC328 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,1,3,5,6,4,7);
        ListNode head = ListNode.construct(list);
        ListNode resHead = oddEvenList(head);
        ListNode.printListNodes(resHead);
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)  return head;

        ListNode curr = head;
        ListNode temp = head.next;

        while(curr.next != null){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr.next.next;
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }
}
