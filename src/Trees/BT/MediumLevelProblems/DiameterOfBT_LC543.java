package Trees.BT.MediumLevelProblems;

import Trees.TreeNode;

public class DiameterOfBT_LC543 {
    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return maxDiameter;
    }
    int maxDiameter = 0;
    public int postOrder(TreeNode root){ // TC - O(N) SC - O(H)
        if(root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int max = Math.max(left, right);
        maxDiameter = Math.max(maxDiameter, left+right);

        return max+1;
    }
}
/*
-> Cal height of left and right, diameter = height(left+right), take max_diameter.
-> Return max height(left,right) because if left height is 6, right height is 3, we need max diameter so return max + current level(+1).

 */