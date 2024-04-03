package LinkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists_LC23 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,4,5,11,18);
        List<Integer> list2 = Arrays.asList(1,3,4,7,10,14);
        List<Integer> list3 = Arrays.asList(2,6,9,12,15);

        ListNode head1 = ListNode.construct(list1);
        ListNode head2 = ListNode.construct(list2);
        ListNode head3 = ListNode.construct(list3);

        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;

        ListNode res = mergeKLists(lists);
        ListNode.printListNodes(res);
    }
    public static ListNode mergeKLists(ListNode[] lists) { // TC - O(NlogN) SC - O(N)
        PriorityQueue<ListNode> heap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        Collections.addAll(heap, lists);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!heap.isEmpty()){
            ListNode minNode = heap.poll();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next != null){
                heap.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
/*
Constraints :
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.


Approach 1 :
-> Iterate over each list and to arrayList and sort it.
-> now build LL from arrayList.
-> look at constraints, lists.length max is 10^4 and LL length is max 500, so 10^4 * 500 = 5*10^6
-> so we can't sort arraylist as the size is very big it gives TL.

Approach 2 :
-> First add all heads to PQ, Why PQ? it gives minVal node. Add node to LL and move pointer to next node.
-> At max PQ can hold 10^4 nodes as it is lists.length.
-> So NlogN TC will work.
 */
