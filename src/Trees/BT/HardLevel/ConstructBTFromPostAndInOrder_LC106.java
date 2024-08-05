package Trees.BT.HardLevel;

import Trees.BT.Traversals.PostOrderTraversal;
import Trees.LeetCodeMSC.TreeNode;

import java.util.HashMap;

public class ConstructBTFromPostAndInOrder_LC106 {
    public static void main(String[] args) {
        int[] postOrder = {9,15,7,20,3};
        int[] inOrder = {9,3,15,20,7};
        TreeNode root = buildTree(inOrder, postOrder);
        System.out.println(PostOrderTraversal.postOrder(root));
    }
    static HashMap<Integer, Integer> indices = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int m = postorder.length;

        for(int i = 0; i < n; i++){
            indices.put(inorder[i], i);
        }

        return buildBT(0, n-1, m-1, postorder);
    }
    public static TreeNode buildBT(int inStart, int inEnd, int postEnd, int[] postOrder){
        if(inStart > inEnd) return null;
        int val = postOrder[postEnd];
        int index = indices.get(val);
        TreeNode root = new TreeNode(val);

        root.left = buildBT(inStart, index-1, postEnd - (inEnd - index) - 1, postOrder);
        root.right = buildBT(index+1, inEnd, postEnd-1, postOrder);

        return root;
    }
}
