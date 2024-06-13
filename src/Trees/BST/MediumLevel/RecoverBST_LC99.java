package Trees.BST.MediumLevel;

import Trees.BST.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class RecoverBST_LC99 {
    public static void main(String[] args) {
    }
    TreeNode pNode = new TreeNode(Integer.MIN_VALUE);
    TreeNode fNode = null;
    TreeNode sNode = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int val = fNode.val;
        fNode.val = sNode.val;
        sNode.val = val;
    }
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(pNode.val > root.val){
            if(fNode == null) fNode = pNode;
            sNode = root;
        }
        pNode = root;
        inOrder(root.right);
    }
}
/*
-> Inorder traversal of BST gives sorted values.
-> In this question, exactly two node values are swapped. Inorder traversal gives unsorted list.
Approach 1 :
-> Do inorder traversal and store values in list. Sort list.
-> Now again do inorder traversal and check one by one value in list, If both are not same store nodes
-> Now swap values of stored nodes.
-> TC - O(NlogN) SC - O(N)

Approach 2 :
-> Do inorder traversal and store values in list. Sort list.
-> Iterate over list, check prev value < curr val, if not store values. Swap at last.
-> Construct BST from list after swap.

Approach 3 :
-> There are two cases to check.
Ex : Inorder list of BST -> 1,2,3,4,5,6,7

Case 1 : 2 and 3 swapped result inorder list 1,3,2,4,5,6,7
-> We need to find two swapped values.
-> Iterate over list, 3 > 2 so first val = 3 and second val = 2
-> Swap those two values.

Case 1 : 2 and 6 swapped result inorder list 1,6,3,4,5,2,7
-> Iterate over list, 6>3 so firstVal = 6 and secondVal = 3.
-> But here swapped values are not 6 and 3.
-> Continue iteration, If you find second pair take second value in them.
-> 5 > 2 so second value is 2
-> Now swap first and second values.

-> This can be done by inorder traversal, InOrder -> left, root(Business logic), right.
-> Do inorder traversal, first we go to smaller val, then root and then bigger val.
-> Once we reach smaller check it with prev value whether it is violating the rule.
   If yes take first and second val, then continue If you find next pair take second only.
 */
