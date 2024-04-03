package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_LC142 {
    public static void main(String[] args) {

    }
    public ListNode detectCycle1(ListNode head) { // TC - O(N) SC - O(N)
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while(curr != null){
            if(!set.add(curr)) return curr;
            curr = curr.next;
        }
        return null;
    }
    public ListNode detectCycle2(ListNode head) { // TC - O(N) SC - O(1)
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next != null) return null;
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
