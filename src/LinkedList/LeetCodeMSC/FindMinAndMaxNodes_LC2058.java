package LinkedList.LeetCodeMSC;

import LinkedList.ListNode;

public class FindMinAndMaxNodes_LC2058 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null) return new int[]{-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        int count = 2;

        int start = -1, mid = -1, end = -1;
        int minDistance = Integer.MAX_VALUE;
        while(next != null){
            if(prev.val < curr.val && curr.val > next.val
                    || prev.val > curr.val && curr.val < next.val){
                if(start == - 1) start = count;
                mid = end;
                end = count;
                if(mid != -1) minDistance = Math.min(minDistance, end - mid);
            }
            count += 1;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if(start == end) return new int[]{-1, -1};

        return new int[]{minDistance, end- start};
    }
}
/*
Test Cases : [6,8,4,1,9,6,6,10,6]
 */