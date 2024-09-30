package Trees.BT.MediumLevelProblems;

import Trees.LeetCodeMSC.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryPaths_LC257 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2,null, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(binaryTreePaths(node1));

    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        findPaths(paths, new ArrayList<>(), root);

        return paths;
    }
    public static void findPaths(List<String> paths, List<String> path, TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            path.add(root.val+"");
            StringBuilder sb = new StringBuilder();
            for(String str : path){
                sb.append(str);
            }
            paths.add(sb.toString());
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val+"->");
        findPaths(paths, path, root.left);
        findPaths(paths, path, root.right);
        path.remove(path.size() - 1);
    }
}
