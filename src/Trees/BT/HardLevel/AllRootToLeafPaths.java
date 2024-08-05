package Trees.BT.HardLevel;

import Trees.LeetCodeMSC.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllRootToLeafPaths {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(allPaths(node1));
    }
    public static List<List<Integer>> allPaths(TreeNode root){
        paths(root, new ArrayList<>());
        return res;
    }

    static List<List<Integer>> res = new ArrayList<>();
    public static void paths(TreeNode root, List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        paths(root.left, list);
        paths(root.right, list);
        list.remove(list.size()-1);
    }
}
