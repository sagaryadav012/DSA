package LinkedList;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(){ }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode construct(List<Integer> list){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int val : list){
            ListNode node = new ListNode(val);
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printListNodes(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
