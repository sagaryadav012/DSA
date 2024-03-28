package LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class SortList_LC148 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,7,9,14,2,5,6,10);
        ListNode head = ListNode.construct(list);
        ListNode res = sortList(head);
        ListNode.printListNodes(res);
    }
    public static ListNode sortList(ListNode head) {
        return divideAndMerge(head);
    }
    public static ListNode divideAndMerge(ListNode head){ // TC - O(NlogN) SC - O(1)
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode left = divideAndMerge(head);
        ListNode right = divideAndMerge(head2);
        return merge(left, right);
    }
    public static ListNode getMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode merge(ListNode A, ListNode B){
        if(A == null) return B;
        if(B == null) return A;

        ListNode head;

        if(A.val < B.val){
            head = A;
            A = A.next;
        }
        else{
            head = B;
            B = B.next;
        }
        ListNode curr = head;
        while(A != null && B != null){
            if(A.val < B.val){
                curr.next = A;
                A = A.next;
            }
            else{
                curr.next = B;
                B = B.next;
            }
            curr = curr.next;
        }
        if(A == null) curr.next = B;
        if(B == null) curr.next = A;

        return head;
    }
}
