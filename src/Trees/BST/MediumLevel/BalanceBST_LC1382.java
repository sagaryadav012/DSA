package Trees.BST.MediumLevel;

import Trees.BST.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST_LC1382 {
    public static void main(String[] args) {

    }
    public static TreeNode balanceBST(TreeNode root) {
        getTree(root);
        return buildTree(0, nodes.size() - 1);
    }
    static List<TreeNode> nodes = new ArrayList<>();
    public static void getTree(TreeNode root){
        if(root == null) return;
        getTree(root.left);
        nodes.add(root);
        getTree(root.right);
    }
    public static TreeNode buildTree(int s, int e){
        if(s > e) return null;
        int m = (s+e)/2;
        TreeNode root = nodes.get(m);
        root.left = buildTree(s, m-1);
        root.right = buildTree(m+1, e);
        return root;
    }
}
/*
-> Take all nodes using inorder traversal which gives in sorted manner.
-> Now build BST using list.
 */