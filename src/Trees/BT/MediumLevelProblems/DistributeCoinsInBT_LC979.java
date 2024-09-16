package Trees.BT.MediumLevelProblems;

import Trees.LeetCodeMSC.TreeNode;

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

-> Here every parent gets coin count from its children, The count would be no.of coins children need or no.of coins children have extra.
   Once parent get count, it sums coins of left, right and parent's coins and remove 1 coin from total count,
   that coin is for parent. parent will return extra count to their parent.
-> Moves will be absolute value of left and right coins count. for example left child return 2 coins to parent
   that means left child have extra 2 coins, so we are moving two coins that take single step, but we moved 2 coins
   so 2 * 1step = 2 steps or moves. even count is -ve that means we need to give coins so it will be also a move.

 */
