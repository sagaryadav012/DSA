package Trees.Traversals;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(preOrder(node1));
        System.out.println(iterativePreOrder1(node1));
        System.out.println(iterativePreOrder2(node1));
        System.out.println(morriesPreOrder(node1));
    }

    public static List<Integer> preOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        recursivePreOrder(root, list);
        return list;
    }
    public static void recursivePreOrder(TreeNode root, List<Integer> list){ // TC - O(N) SC - O(H)
        if(root == null) return;
        list.add(root.val);
        recursivePreOrder(root.left, list);
        recursivePreOrder(root.right, list);
    }

    public static List<Integer> iterativePreOrder1(TreeNode root){ // TC - O(N) SC - O(N)
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return res;
    }
    public static List<Integer> iterativePreOrder2(TreeNode root){ // TC - O(N) SC - O(N)
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);

            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
    }
    public static List<Integer> morriesPreOrder(TreeNode root){ // TC - O(N) SC - O(1)
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            res.add(curr.val);
            if(curr.left == null){
                curr = curr.right;
                continue;
            }
            TreeNode temp = curr.left;
            while(temp.right != null && temp.right != curr.right){
                temp = temp.right;
            }
            if(temp.right == null){
                temp.right = curr.right;
                curr = curr.left;
            }
        }
        return res;
    }
}
