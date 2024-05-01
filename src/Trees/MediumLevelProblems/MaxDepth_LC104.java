package Trees.MediumLevelProblems;

import Trees.TreeNode;

public class MaxDepth_LC104 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);

        return Math.max(left_height, right_height) + 1;
    }
}
