package LinkedList;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists_LC21 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,3,5);
        List<Integer> list2 = Arrays.asList(2,6,8,9);
        ListNode head1 = ListNode.construct(list1);
        ListNode head2 = ListNode.construct(list2);
        ListNode resNode = mergeTwoLists(head1, head2);
        ListNode.printListNodes(resNode);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                curr.next = p1;
                curr = curr.next;
                p1 = p1.next;
            }
            else{
                curr.next = p2;
                curr = curr.next;
                p2 = p2.next;
            }
        }

        while(p1 != null){
            curr.next = p1;
            curr = curr.next;
            p1 = p1.next;
        }
        while(p2 != null){
            curr.next = p2;
            curr = curr.next;
            p2 = p2.next;
        }

        return dummy.next;
    }
}
/*
-> Initially I will take two pointers, assign one pointer to head of first list, another pointer to head of second list.
-> Now compare node values of two pointers points to nodes, add smaller one to resList, add move pointer to next node.
-> Do this process until both pointers shouldn't point to null.
-> Last check two lists, if there are any nodes left.
 */
