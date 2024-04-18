package Trees;

import java.util.List;

public class BuildTree {
    public static void main(String[] args) {

    }
    public static TreeNode buildTree(int[] nums){
        int n = nums.length;
        TreeNode[] nodes = new TreeNode[n];
        for(int i = 0; i < n; i++){
            TreeNode node = new TreeNode(nums[i]);
            nodes[i] = node;
        }

        for(int i = 0; i <= ((n/2)-1); i++){
            TreeNode node = nodes[i];
            node.left = nodes[(i*2)+1];
            if((i*2)+2 < n) node.right = nodes[(i*2)+2];
        }

        return nodes[0];
    }
}
