package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyList_LC138 {
    public Node copyRandomList(Node head) { // TC - O(N) SC - O(N+N)
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        // Map to store original nodes as keys and corresponding copied nodes as values
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Second pass: set next and random pointers for copied nodes
        curr = head;
        while(curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
    public Node copyRandomList1(Node head){ // TC - O(N) SC - O(N)
        Node curr = head;

        // Create new LL and connect with original LL.
        while(curr != null){
            Node next = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }

        curr = head;
        // Connect random pointer of new LL with help of Original LL
        while(curr != null){
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // break connections
        curr = head;
        Node newHead = curr.next;
        while(curr != null){
            Node next = curr.next;
            curr.next = next.next;
            curr = curr.next;
            if(next.next != null) next.next = curr;
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
/*
Approach 1 :
-> Create new node for each corresponding node and store it in hashmap.
-> Now iterate over LL, get corresponding node from map, get random and next nodes of corresponding node and connect them.
-> TC - O(N) SC - O(N+N)

Approach 2 :
-> Create copy of LL and connect it with Original LL
-> Now connect random points of new LL with help of Original LL : curr.next.random = curr.random.next
-> Now break connections with Original LL.
 */