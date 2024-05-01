package Trees.MediumLevelProblems;

import Trees.TreeNode;

public class BalancedBT_LC110 {

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        solve(root);
        return isBalanced;
    }
    public int solve(TreeNode root){
        if(root == null) return 0;

        int left_height = solve(root.left);
        int right_height = solve(root.right);

        if(Math.abs(left_height - right_height) > 1){
            isBalanced = false;
        }

        return Math.max(left_height, right_height)+1;
    }
}
