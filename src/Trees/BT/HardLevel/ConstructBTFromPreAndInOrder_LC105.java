package Trees.BT.HardLevel;

import Trees.BT.Traversals.PreOrderTraversal;
import Trees.TreeNode;

import java.util.HashMap;

public class ConstructBTFromPreAndInOrder_LC105 {
    public static void main(String[] args) {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode root = buildTree(preOrder, inOrder);
        System.out.println(PreOrderTraversal.preOrder(root));
    }
    static HashMap<Integer, Integer> indices = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        int m = preorder.length;
        for(int i = 0; i <n; i++) {
            indices.put(inorder[i], i);
        }
        return buildBT(0, m-1, 0, n-1, preorder);
    }
    public static TreeNode buildBT(int preStart, int preEnd, int inStart, int inEnd, int[] preorder){
        if(inStart > inEnd) return null;
        int val = preorder[preStart];
        int index = indices.get(val);
        TreeNode root = new TreeNode(val);

        root.left = buildBT(preStart + 1, index, inStart, index -1, preorder);
        root.right = buildBT(preStart + index - inStart + 1, preEnd, index + 1, inEnd, preorder);

        return root;
    }
}
