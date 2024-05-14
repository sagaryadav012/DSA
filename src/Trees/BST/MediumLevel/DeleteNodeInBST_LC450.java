package Trees.BST.MediumLevel;

import Trees.BST.TreeNode;

public class DeleteNodeInBST_LC450 {
    public TreeNode deleteNode(TreeNode root, int key) { // TC - O(H) SC - O(H)
        if(root == null) return null;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null) return null; // case1
            if(root.left == null) return root.right; // case2
            if(root.right == null) return root.left; // case3
            TreeNode temp = root.left; // case4 find predecessor
            while(temp.right != null){
                temp = temp.right;
            }
            root.val = temp.val;
            root.left = deleteNode(root.left, temp.val);
        }
        return root;
    }
}

/*
-> InOrder traversal gives sorted values in BST.
-> First find deleteNode in BST.
-> There are 4 cases to check when delete node in BST.

case 1 : If deleteNode is leaf then simply return null to parent.
case 2 : If deleteNode has only left child, then attach left to parent of deleteNode.
case 3 : If deleteNode has only right child, then attach right to parent of deleteNode.
case 4: If deleteNode has both left and right child, then we need to delete this node
        and place appropriate node this place so that It doesn't violate BST.
        How can we do that?
        Find predecessor of deleteNode and place here, that doesn't violate BST.
        So find predecessor, swap curr node value with predecessor value and delete predecessor,
        Now the problem boils down to deleteNode again but this it is delete leafNode.
 */
