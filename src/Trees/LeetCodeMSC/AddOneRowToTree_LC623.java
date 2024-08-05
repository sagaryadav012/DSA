package Trees.LeetCodeMSC;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree_LC623 {
    public static void main(String[] args) {
        int[] nums = {4,2,6,3,1,5};
        TreeNode root = BuildTree.buildTree(nums);
        int val = 1;
        int depth = 2;
        addOneRow2(root, val, depth);
    }

    // Approach 1 : TC - O(N) SC - O(N)
    public static TreeNode addOneRow1(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        Queue<Pair> queue = getNodes(root, depth);
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            TreeNode left = node.left;
            TreeNode right = node.right;
            TreeNode newLeftNode = new TreeNode(val);
            TreeNode newRightNode = new TreeNode(val);
            node.left = newLeftNode;
            node.right = newRightNode;
            newLeftNode.left = left;
            newRightNode.right = right;
        }
        return root;
    }
    public static Queue<Pair> getNodes(TreeNode root, int depth){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));

        while(!queue.isEmpty()){
            if(queue.peek().depth == depth-1) break;
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int curDepth = pair.depth;

            if(node.left != null) queue.add(new Pair(node.left, curDepth + 1));
            if(node.right != null) queue.add(new Pair(node.right, curDepth + 1));
        }

        return queue;
    }


    // Approach 2 : TC - O(N) SC - O(H)
    public static TreeNode addOneRow2(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newNode = new TreeNode(val, root, null);
            return newNode;
        }
        addRow(root, 1, val, depth);
        return root;
    }
    public static void addRow(TreeNode root, int curDepth, int val, int depth){
        if(root == null) return;

        if(curDepth == depth - 1){
            TreeNode newLeftNode = new TreeNode(val, root.left, null);
            TreeNode newRightNode = new TreeNode(val, null, root.right);
            root.left = newLeftNode;
            root.right = newRightNode;
            return;
        }

        addRow(root.left, curDepth + 1, val, depth);
        addRow(root.right, curDepth + 1, val, depth);

    }
}
class Pair{
    TreeNode node;
    int depth;
    Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}


/*
-> Iterate over tree and find nodes at depth = depth - 1 and add new node to it.
 */