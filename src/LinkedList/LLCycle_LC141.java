package LinkedList;

public class LLCycle_LC141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
/*

-> Assume there are two runners slow runner and fast runner, if slow runner takes one step, fast runner takes 2 steps.
-> Two runners are running on straight line. will they meet again? No.
-> Two runners are running on cyclic path. Will they meet again? yes.
-> So Take Nodes and check if they are meeting at any point means there is cycle in LL, else no cycle.

 */
