package LinkedList;

import java.util.Arrays;
import java.util.List;

public class RotateList_LC61 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int k = 2;
        ListNode head = ListNode.construct(list);
        ListNode res = rotateRight(head , k);
        ListNode.printListNodes(res);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        k %= size;
        size = size - k;
        if(k == 0) return head;

        curr = head;
        while(size > 1){
            curr = curr.next;
            size--;
        }

        ListNode newHead = curr.next;
        curr.next = null;
        curr = newHead;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = head;

        return newHead;
    }
}
