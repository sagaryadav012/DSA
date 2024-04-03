package LinkedList;

import java.util.Arrays;
import java.util.List;

public class SwappingNodesInLL_LC1721 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7,9,6,6,7,8,3,0,9,5);
        ListNode head = ListNode.construct(list);
        int k = 5;
        ListNode res = swapNodes(head, k);
        ListNode.printListNodes(res);
    }
    public static ListNode swapNodes(ListNode head, int k) {
        int len = findLen(head);
        ListNode node1 = head;
        for(int i = 1; i < k; i++){
            node1 = node1.next;
        }
        ListNode node2 = head;
        for(int i = 1; i <= len - k; i++){
            node2= node2.next;
        }

        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;

        return head;
    }
    public static int findLen(ListNode head){
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len += 1;
            curr = curr.next;
        }
        return len;
    }
}
