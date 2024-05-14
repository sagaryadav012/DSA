package Trees.BT.Traversals;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(levelOrderTraversal(node1));
        System.out.println(levelOrder(node1));
    }
    public static List<List<Integer>> levelOrderTraversal(TreeNode root){ // TC - O(N) SC - O(N)
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<Pair> queue = new LinkedList<>();
        Pair p = new Pair(root, 0);
        int prevLevel = 0;

        queue.add(p);
        List<Integer> row = new ArrayList<>();
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            if(level != prevLevel){
                prevLevel = level;
                res.add(row);
                row = new ArrayList<>();
            }
            row.add(node.val);

            if(node.left != null){
                queue.add(new Pair(node.left, level + 1));
            }
            if(node.right != null){
                queue.add(new Pair(node.right, level + 1));
            }
        }
        res.add(row);

        return res;
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
