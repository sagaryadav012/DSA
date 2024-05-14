package Trees.BT.Traversals;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(inOrder(node1));
        System.out.println(iterativeInOrder1(node1));
        System.out.println(iterativeInOrder2(node1));
        System.out.println(morriesInOrder(node1));
    }

    public static List<Integer> inOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        recursiveInOrder(root, list);
        return list;
    }
    public static void recursiveInOrder(TreeNode root, List<Integer> list){ // TC - O(N) SC - O(H)
        if(root == null) return;
        recursiveInOrder(root.left, list);
        list.add(root.val);
        recursiveInOrder(root.right, list);
    }
    public static List<Integer> iterativeInOrder1(TreeNode root){ // TC - O(N) SC - O(N)
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    public static List<Integer> iterativeInOrder2(TreeNode root){ // TC - O(N) SC - O(N)
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.add(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
    public static List<Integer> morriesInOrder(TreeNode root){ // TC - O(N) SC - O(1)
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                res.add(curr.val);
                curr = curr.right;
                continue;
            }
            TreeNode temp = curr.left;
            while(temp.right != null && temp.right != curr){
                temp = temp.right;
            }
            if(temp.right == null){
                temp.right = curr;
                curr = curr.left;
            }
            else{
                temp.right = null;
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }
}
