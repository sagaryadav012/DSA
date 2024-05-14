package Heaps.Hard;

import java.util.PriorityQueue;

public class MergeKSortedLists_LC23 {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node != null) pQueue.add(node);
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(!pQueue.isEmpty()){
            curr.next = pQueue.poll();
            curr = curr.next;
            if(curr.next != null){
                pQueue.add(curr.next);
            }
        }
        return head.next;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
