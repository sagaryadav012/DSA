package Trees.LeetCodeMSC;

import LinkedList.ListNode;

public class LinkedListInBT_LC1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;

        return isContinuousSubPath(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    public boolean isContinuousSubPath(TreeNode root, ListNode head){
        if(head == null) return true;
        if(root == null || root.val != head.val) return false;

        return isContinuousSubPath(root.left, head.next) || isContinuousSubPath(root.right, head.next);
    }
}
