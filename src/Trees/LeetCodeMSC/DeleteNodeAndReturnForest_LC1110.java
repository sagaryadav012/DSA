package Trees.LeetCodeMSC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodeAndReturnForest_LC1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int val : to_delete){
            set.add(val);
        }

        List<TreeNode> roots = new ArrayList<>();
        TreeNode rootNode = deleteNodes(root, set, roots);

        if(rootNode != null) roots.add(rootNode);

        return roots;
    }
    public TreeNode deleteNodes(TreeNode root, Set<Integer> set, List<TreeNode> roots){
        if(root == null) return null;

        root.left = deleteNodes(root.left, set, roots);
        root.right = deleteNodes(root.right, set, roots);

        if(set.contains(root.val)){
            if(root.left != null) roots.add(root.left);
            if(root.right != null) roots.add(root.right);
            return null;
        }

        return root;
    }
}
