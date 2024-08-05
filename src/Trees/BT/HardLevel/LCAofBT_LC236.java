package Trees.BT.HardLevel;

import Trees.LeetCodeMSC.TreeNode;

public class LCAofBT_LC236 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(lowestCommonAncestor(node1, node5, node4).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}
/*
Approach 1 :
-> Find a path from root to p node and store it in list.
-> Similarly find path from root to q node, store it in list.
-> Now compare two lists, the last common node from both lists is LCA
-> TC - O(N) SC - O(N)

Approach 2 :
-> LCA means Lowest common ancestor, that means the lowest common root for both p and q.
-> So find left and right are equal to p, q of each node in tree. If it's equal then that is LCA of p and q
-> Take Pre Order traversal and search for p, q node. If found it return node.
-> If a node's left is p and right is null then the node is not LCA so return p.
-> If left and right are not null of a node(LCA node) return node, if left null return right or right null then return left.
-> TC - O(N) SC - O(H)

 */
