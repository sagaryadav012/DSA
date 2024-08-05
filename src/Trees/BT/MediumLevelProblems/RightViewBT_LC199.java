package Trees.BT.MediumLevelProblems;

import Trees.LeetCodeMSC.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBT_LC199 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(rightView(node1));
        System.out.println(rightView1(node1));
    }
    public static List<Integer> rightView(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                size--;
                if(size == 0) res.add(node.val);
            }
        }
        return res;
    }
    public static List<Integer> rightView1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode pNode = new TreeNode(-101);
        int preLevel = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int level = pair.level;
            TreeNode node = pair.node;

            if(preLevel != level){
                preLevel = level;
                res.add(pNode.val);
            }
            pNode = node;

            if(node.left != null) queue.add(new Pair(node.left, level+1));
            if(node.right != null) queue.add(new Pair(node.right, level+1));
        }
        res.add(pNode.val);
        return res;
    }
}
