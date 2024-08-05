package Trees.BT.MediumLevelProblems;

import Trees.LeetCodeMSC.TreeNode;

public class SymmetricTree_LC101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)  return false;
        return check(root.left, root.right);
    }
    public boolean check(TreeNode A, TreeNode B){
        if(A == null && B == null) return true;
        if(A == null || B == null || A.val != B.val) return false;
        return check(A.left, B.right) && check(A.right, B.left);
    }
}
