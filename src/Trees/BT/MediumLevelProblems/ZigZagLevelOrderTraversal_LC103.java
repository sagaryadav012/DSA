package Trees.BT.MediumLevelProblems;

import Trees.LeetCodeMSC.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal_LC103 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(zigzagLevelOrder(node1));
        System.out.println(zigzagLevelOrder1(node1));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){ // TC - O(N) SC - O(N)
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(flag) list.add(node.val);
                else list.add(0, node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
    public static List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        List<Integer> list = new ArrayList<>();
        queue.add(new Pair(root, 0));
        int preLevel = 0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if(preLevel != level){
                result.add(list);
                preLevel = level;
                list = new ArrayList<>();
            }
            if(level % 2 == 0) list.add(node.val);
            else list.add(0, node.val);

            if(node.left != null){
                queue.add(new Pair(node.left, level+1));
            }
            if(node.right != null){
                queue.add(new Pair(node.right, level+1));
            }
        }
        result.add(list);
        return result;
    }
}
class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}
