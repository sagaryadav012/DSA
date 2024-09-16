package LinkedList.LeetCodeMSC;

import LinkedList.ListNode;

public class SplitLLInParts_LC725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if(head == null) return res;

        int size = getSize(head);

        int minSize = size/k;
        int x = size%k;

        ListNode curr = head;

        int index = 0;

        while(curr != null){
            ListNode newHead = curr;
            ListNode prev = null;
            for(int i = 0; i < minSize; i++){
                prev = curr;
                curr = curr.next;
            }
            if(x > 0){
                prev = curr;
                curr = curr.next;
                x--;
            }
            prev.next = null;

            res[index++] = newHead;
        }

        return res;
    }
    public int getSize(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        int count = 1;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            count += 1;
        }

        if(fast.next == null) return (count*2) - 1;

        return count*2;
    }
}
/*
-> Split linked list in k parts, difference between size of any linked list should not be greater than 1.
-> Find size, size/k gives minimum size of each linked list part. size%k will be extra nodes,
   so add one node to each linked list part, so that size difference will not be greater than 1.

-> For example totalSize of  LL is 9, split it into 5 parts. Each part min size is 9/5 = 1,
   9%5 = 4, so add one node to each part then result will be
   1->2     3->4    5->6    7->8    9        --> Here difference size of any LL is not more than 1.
      
 */