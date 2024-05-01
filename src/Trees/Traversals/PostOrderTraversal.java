package Trees.Traversals;

import Trees.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(postOrder(node1));
        System.out.println(iterativePostOrder(node1));
    }

    public static List<Integer> postOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        recursivePostOrder(root, list);
        return list;
    }
    public static void recursivePostOrder(TreeNode root, List<Integer> list){ // TC - O(N) SC - O(H)
        if(root == null) return;
        recursivePostOrder(root.left, list);
        recursivePostOrder(root.right, list);
        list.add(root.val);
    }
    public static List<Integer> iterativePostOrder(TreeNode root){ // TC - O(N) SC - O(N)
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.add(root);
        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            st2.add(node);

            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }

        List<Integer> res = new ArrayList<>();
        while(!st2.isEmpty()){
            res.add(st2.pop().val);
        }
        return res;
    }
}
