package Trees.BST.EasyLevel;

import Trees.BST.TreeNode;

public class FloorInBST {
    public static void main(String[] args) {
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14, node13, null);
        TreeNode node10 = new TreeNode(10, null, node14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, node4, node7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3, node1, node6);
        TreeNode node8 = new TreeNode(8, node3, node10);
        System.out.println(findFloor(node8, 2));
        System.out.println(findFloor(node8, 7));
        System.out.println(findFloor(node8, 12));

    }
    public static int findFloor(TreeNode root, int val){
        int floor = -1;
        TreeNode curr = root;
        while(curr != null){
            if(curr.val <= val){
                floor = curr.val;
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        return floor;
    }
}
