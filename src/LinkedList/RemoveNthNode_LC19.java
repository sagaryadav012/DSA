package LinkedList;

import java.util.Arrays;
import java.util.List;

public class RemoveNthNode_LC19 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        ListNode head = ListNode.construct(list);
        int n = 2;
        ListNode res = removeNthFromEnd(head, n);
        ListNode.printListNodes(res);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode temp = head;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }

        if(size == n) return head.next;

        size = size - n;

        temp = head;
        for(int i = 1; i < size; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
