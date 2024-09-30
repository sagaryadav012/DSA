package Trees.BT.MediumLevelProblems;

public class PopulatingNextRightPointer_LC116 {
    public Node connect(Node root) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node curr = root;

        while(curr != null){
            if(curr.left != null){
                temp.next = curr.left;
                temp = curr;
            }
            if(curr.right != null){
                temp.next = curr.right;
                temp = curr;
            }
            curr = curr.next;
            if(curr == null){
                curr = dummy.next;
                dummy.next = null;
                temp = dummy;
            }
        }

        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
