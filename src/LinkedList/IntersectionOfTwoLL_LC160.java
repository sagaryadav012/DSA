package LinkedList;

import java.util.HashSet;

public class IntersectionOfTwoLL_LC160 {

    // TC - O(M+N) SC - O(M)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while(curr != null){
            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while(curr != null){
            if(set.contains(curr)) return curr;
            curr = curr.next;
        }

        return null;
    }

    // TC - O(M+N) SC - O(1)
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = findLen(headA);
        int lenB = findLen(headB);

        while(lenA > lenB){
            lenA--;
            headA = headA.next;
        }
        while(lenB > lenA){
            lenB--;
            headB = headB.next;
        }

        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
    public static int findLen(ListNode head){
        int len = 1;
        ListNode curr = head;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }

    // TC - O(M+N) SC - O(1)
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = (p1 == null)?headB:p1.next;
            p2 = (p2 == null)?headA:p2.next;
        }
        return p1;
    }
}
/*
Approach 1 : TC - O(M * N) SC - O(1)
-> Check each node address of list1 equals to any of the node address in list2
-> we can do it by taking two loops

Approach 2 : TC - O(M + N) SC - O(N)
-> Store all nodes of list 1 in HashSet.
-> Iterate over on 2nd list and check node exists in hashSet. if exists then there will be intersecting node.

Approach 3 : TC - O(M + N) SC - O(1)
-> Count length of two lists.
-> Assume list1 len is 10, list2 len is 6. It means list1 has 4 nodes extra then list2.
-> So move point in list1 until list1 and list2 have same len.
-> Once they are in same len, now move pointers in both lists and check whether they are equal or not.
 */
