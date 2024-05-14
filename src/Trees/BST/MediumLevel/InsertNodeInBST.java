package Trees.BST.MediumLevel;

import Trees.BST.TreeNode;

public class InsertNodeInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insertNode = new TreeNode(val);
        if(root == null) return insertNode;

        TreeNode parent = root;
        TreeNode curr = root;

        while(curr != null) {
            parent = curr;
            if(curr.val < val){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        if(parent.val > val) parent.left = insertNode;
        else parent.right = insertNode;

        return root;
    }
}
