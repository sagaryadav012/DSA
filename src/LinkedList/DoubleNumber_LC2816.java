package LinkedList;

import java.util.Arrays;
import java.util.List;

public class DoubleNumber_LC2816 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,4,5,4,2,5,5,9,9,9);
        ListNode head = ListNode.construct(list);
        ListNode resNode = doubleIt(head);
        ListNode.printListNodes(resNode);
    }
    public static ListNode doubleIt(ListNode head) {
        ListNode curr = reverseList(head);
        int carry = 0;
        ListNode newHead = null;
        while(curr != null){
            int val = curr.val;
            val *= 2;
            val += carry;
            int last_digit = val % 10;
            carry = val / 10;
            ListNode node = new ListNode(last_digit);
            node.next = newHead;
            newHead = node;
            curr = curr.next;
        }
        if(carry > 0){
            ListNode node = new ListNode(carry);
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
    public static ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
