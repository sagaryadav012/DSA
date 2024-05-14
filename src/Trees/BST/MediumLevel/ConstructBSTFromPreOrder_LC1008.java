package Trees.BST.MediumLevel;

import Trees.BST.TreeNode;

public class ConstructBSTFromPreOrder_LC1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, 0, preorder.length-1);
    }
    public TreeNode constructBST(int[] preOrder, int left, int right){
        if(left > right) return null;

        TreeNode root = new TreeNode(preOrder[left]);
        int rightIndex = left + 1;
        while(rightIndex <= right && preOrder[rightIndex] < preOrder[left]){
            rightIndex++;
        }

        root.left = constructBST(preOrder, left+1, rightIndex-1);
        root.right = constructBST(preOrder, rightIndex, right);

        return root;
    }
}
