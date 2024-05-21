package Trees.BT.MediumLevelProblems;

import Trees.TreeNode;

public class DistributeCoinsInBT_LC979 {
    public static void main(String[] args) {

    }
    public int distributeCoins(TreeNode root) {
        findMoves(root) ;
        return moves;
    }
    int moves = 0;
    public int findMoves(TreeNode root) {
        if(root == null) return 0;
        int left = findMoves(root.left);
        int right = findMoves(root.right);
        moves += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
/*
-> Instead of moving coins, check how many coins need to move or how many coins need at that node.
-> Use post order traversal to get no.of coins required or no.of coins get from children.
-> Here left and right child tells no.of coins they need or no.of coins they have extra to give.
-> For example if left child need 2 coins(-2) and right child need 2 coins(-2) and curr node has 3 coins, then
   (3-2-2)-1(Here -1 represents root node need one coin so remove one coin from total) = -2 coins needed so return it to its parent.
-> And the final task is to find moves. If child return -ve or +ve value except 0 that means move is happening
   there so take abs value of left and right then take moves += left + right
 */
