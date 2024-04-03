package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseNodesInKGroups_LC25 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
        ListNode head = ListNode.construct(list);
        int k = 4;
//        ListNode res = reverseKGroup1(head, k);
        ListNode res1 = reverseKGroup2(head, k);
        ListNode.printListNodes(res1);
    }
    public static ListNode reverseKGroup1(ListNode head, int k) { // TC - O(N*K) SC - O(N)
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            list.add(curr);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(-1);
        curr = dummy;
        for(int i = k-1; i < list.size(); i += k){
            for(int j = i; j >= i-(k-1); j--){
                curr.next = list.get(j);
                curr = curr.next;
            }
        }
        if(list.size() % k != 0){
            int index = list.size() - (list.size()%k + k);
            ListNode node = list.get(index);
            node.next = list.get(list.size() - list.size()%k);
        }
        return dummy.next;
    }
    public static ListNode reverseKGroup2(ListNode head, int k) { // TC - O(N) SC - O(1)
        int len = findLen(head);
        ListNode curr = head;
        ListNode p1 = head, p2 = null;
        ListNode  newHead = null;

        for(int i = 0; i < len/k; i++){
            ListNode prev = null;
            for(int j = 0; j < k; j++){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(newHead == null) newHead = prev;
            else{
                p1.next = prev;
                p1 = p2;
            }
            p2 = curr;
        }
        if(curr != null) p1.next = curr;

        return newHead;
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
