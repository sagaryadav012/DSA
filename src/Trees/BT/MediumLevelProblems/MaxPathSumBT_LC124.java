package Trees.BT.MediumLevelProblems;

import Trees.TreeNode;

public class MaxPathSumBT_LC124 {
    int maxSumm = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSumm;
    }
    public int maxSum(TreeNode root){
        if(root == null) return 0;

        int leftMaxSum = maxSum(root.left);
        int rightMaxSum = maxSum(root.right);

        int max = Math.max(Math.max(leftMaxSum, rightMaxSum) + root.val, root.val);
        maxSumm = Math.max(Math.max(max, root.val + leftMaxSum + rightMaxSum), maxSumm);

        return max;
    }
}

/*
There are 4 cases that we need to check :
case 1 : subtree : root = 30, left = 10, right = 20;
-> The whole subtree gives maxSum, Take max(root+left+right, max).

case 2 : subtree : root = 30, left = 10, right = -10;
-> In this case the whole subtree gives sum 30 only but root + left gives 40, ignore right.
-> How to ignore right value? take max of left and right, + root.

case 3 : subtree : root = 30, left = -10, right = 10;
-> In this case the whole subtree gives sum 30 only but root + right gives 40, ignore left.
-> How to ignore left value? take max of left and right, + root.

case 4 : subtree : root = 30, left = -10, right = -10;
-> In this case the whole subtree gives sum 10 only but root only gives 30, ignore left and right.
-> How to ignore left and right value? take max(max(left, right)+root), root).

-> Observe all above cases, we can't return root+left+right to root of curr, because it's not valid path,
   Valid paths are root or root+left or root+right, which path gives maxSum we will return that to root.
   As well we have to cal subtree sum(left+right+root) it may gives maxSum, so cal and store it.

 */
