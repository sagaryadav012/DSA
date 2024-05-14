package Trees.BST.MediumLevel;

import Trees.BST.TreeNode;

public class ValidateBST_LC98 {

    // Approach 1
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean validateBST(TreeNode root, int minVal, int maxVal){
        if(root == null) return true;

        if(minVal >= root.val || root.val >= maxVal) return false;

        return validateBST(root.left, minVal, root.val) && validateBST(root.right, root.val, maxVal);
    }


    // Approach 2
    boolean isBST = true;
    public boolean isValidBST1(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        validate(root);
        return isBST;
    }
    public Pair validate(TreeNode root){
        if(root == null) return new Pair(Long.MIN_VALUE, Long.MAX_VALUE);

        Pair leftTree = validate(root.left);
        Pair rightTree = validate(root.right);

        if(leftTree.max >= root.val || rightTree.min <= root.val){
            isBST = false;
        }

        long max_val = Math.max(Math.max(leftTree.max, root.val), rightTree.max);
        long min_val = Math.min(Math.min(leftTree.min, root.val), leftTree.min);

        return new Pair(max_val, min_val);
    }
}
class Pair{
    long max;
    long min;
    Pair(long max, long min){
        this.max = max;
        this.min = min;
    }
}