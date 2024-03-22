package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyList_LC138 {
    public Node copyRandomList(Node head) { // TC - O(N) SC - O(N+N)
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        Node dummy = new Node(-1);
        Node hold = dummy;
        curr = head;
        while(curr != null){
            Node temp = map.get(curr);
            temp.random = map.get(curr.random);
            temp.next = map.get(curr.next);

            hold.next = temp;
            hold = hold.next;
            curr = curr.next;
        }
        return dummy.next;
    }
    public Node copyRandomList1(Node head){
        Node curr = head;
        // Create newLL and interwave old LL with new LL
        while(curr != null){
            Node next = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }
        curr = head;
        while(curr != null){
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = curr.next;
        while(curr != null){
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return newHead;
    }
}
class Node{
    int val;
    Node next;
    Node random;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
