package LinkedList.LeetCodeMSC;

import LinkedList.ListNode;

public class MergeNodesInBetweenZeros_LC2181 {
    public static void main(String[] args) {

    }
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int sum = 0;
        ListNode curr = head.next;

        while(curr != null){
            if(curr.val != 0){
                sum += curr.val;
                curr = curr.next;
                continue;
            }

            if(sum > 0){
                ListNode newNode = new ListNode(sum);
                prev.next = newNode;
                prev = newNode;
                sum = 0;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
