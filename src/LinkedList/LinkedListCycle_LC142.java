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
/*
-> Assume there are two runners slower and faster, If they meet at some point in path that cycle in it, then
   If we assume slower runner covers x+y and faster runner covers x+2y+z then
   2*slower = faster
   2(x+y) = x + 2y+ z
   2x + 2y = x + 2y + z
   x = z
   So start two runners, one is at start point, second is at meet point, then move them equally, where they meet then
   that is cycle start point.
 */