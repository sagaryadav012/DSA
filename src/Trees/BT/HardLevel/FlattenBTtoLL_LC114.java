package Trees.BT.HardLevel;

import Trees.LeetCodeMSC.TreeNode;

public class FlattenBTtoLL_LC114 {
    public static void main(String[] args) {

    }
    static TreeNode pNode = null;
    public static void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pNode;
        root.left = null;
        pNode = root;
    }
}
/*
Approach 1 :
-> Take values of all nodes in list with help of pre order traversal.
-> Now build flatten tree with value in list
-> TC - O(N) SC - O(N)

Approach 2 :
-> Follow reverse pre order traversal, Right Left Root.
-> TC - O(N) SC - O(H)
 */