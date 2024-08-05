package Trees.BT.HardLevel;

import Trees.LeetCodeMSC.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxWidthOfBT_LC662 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9, node7, null);
        TreeNode node2 = new TreeNode(2, null, node9);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, null);
        TreeNode node3 = new TreeNode(3, node5, null);
        TreeNode node1 = new TreeNode(1, node3, node2);
        System.out.println(widthOfBinaryTree(node1));
    }
    public static int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> queue = new ArrayDeque<>();
        queue.addLast(new Pair(1, root));

        int maxWidth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int leftMostIndex = queue.peekFirst().index;
            int rightMostIndex = queue.peekLast().index;
            while(size > 0){
                Pair p = queue.pollFirst();
                int index = p.index;
                TreeNode node = p.node;

                if(node.left != null) queue.addLast(new Pair(index*2, node.left));
                if(node.right != null) queue.addLast(new Pair(index*2+1, node.right));
                size--;
            }
            maxWidth = Math.max(maxWidth, rightMostIndex - leftMostIndex + 1);
        }
        return maxWidth;
    }
}
class Pair{
    int index;
    TreeNode node;

    public Pair(int index, TreeNode node) {
        this.index = index;
        this.node = node;
    }
}
/*
-> We have to find max width among all levels. It includes null values also.
-> It would be easy when we know the index of node. Once we know index, width of that level is rightMostIndex - leftMostIndex + 1
-> TC - O(N) SC - O(N)
 */
