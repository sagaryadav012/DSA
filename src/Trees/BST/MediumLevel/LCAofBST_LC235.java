package Trees.BST.MediumLevel;

import Trees.BST.TreeNode;

public class LCAofBST_LC235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // TC - O(H) SC - O(H)
        if(root == null ) return null;
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) { // TC - O(H) SC - O(1)
        TreeNode curr = root;
        while(curr != null){
            if(curr.val < p.val && curr.val < q.val){
                curr = curr.right;
            }
            else if(curr.val > p.val && curr.val > q.val){
                curr = curr.left;
            }
            else{
                break;
            }
        }
        return curr;
    }
}
