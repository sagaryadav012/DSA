package LinkedList;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates1_LC83 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,1,2,3,3,4,4,4,4);
        ListNode head = ListNode.construct(list);
        ListNode res = deleteDuplicates(head);
        ListNode.printListNodes(res);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return head;
    }
}
