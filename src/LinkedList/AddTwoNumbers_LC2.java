package LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers_LC2 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2,3,7);
        List<Integer> list2 = Arrays.asList(1,5,8);
        ListNode l1 = ListNode.construct(list1);
        ListNode l2 = ListNode.construct(list2);
        ListNode resNode = addTwoNumbers(l1, l2);
        ListNode.printListNodes(resNode);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) { // TC - O(M+N) SC - O(M+N)
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            int lastDigit = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(lastDigit);
            curr.next = newNode;
            curr = newNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
