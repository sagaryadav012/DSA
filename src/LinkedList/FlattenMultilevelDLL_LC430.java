package LinkedList;

public class FlattenMultilevelDLL_LC430 {
    public NodeDL flatten(NodeDL head) {
        for(NodeDL curr = head; curr != null; curr = curr.next){
            if(curr.child == null) continue;

            NodeDL next = curr.next;
            curr.next = curr.child;
            curr.next.prev = curr;
            curr.child = null;
            NodeDL tail = curr.next;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = next;
            if(next != null) tail.next.prev = tail;

        }
        return head;
    }
}
class NodeDL {
    public int val;
    public NodeDL prev;
    public NodeDL next;
    public NodeDL child;
}