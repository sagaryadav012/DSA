package Trees.BST.EasyLevel;

import Trees.LeetCodeMSC.TreeNode;

public class SearchInBST_LC700 {
    public TreeNode searchBST(TreeNode root, int val) { // TC - O(H) SC - O(H)
        if(root == null || root.val == val) return root;

        if(val < root.val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
    public TreeNode searchBST1(TreeNode root, int val) { // TC - O(H) SC - O(1)
        TreeNode curr = root;
        while(curr != null){
            if(curr.val > val) curr = curr.left;
            else if(curr.val < val) curr = curr.right;
            else return curr;
        }
        return null;
    }
}
