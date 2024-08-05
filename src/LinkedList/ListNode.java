package LinkedList;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){ }
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
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
