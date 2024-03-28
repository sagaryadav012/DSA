package LinkedList;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates2_LC82 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,3,3,4,5,5,5,6);
        ListNode head = ListNode.construct(list);
        ListNode res = deleteDuplicates(head);
        ListNode.printListNodes(res);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode prevNode = dummy;

        ListNode curr = head;
        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if(prevNode.next == curr){
                prevNode = curr;
            }
            else{
                prevNode.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
