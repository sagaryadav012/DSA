package Trees.BST.MediumLevel;

import Trees.BST.TreeNode;

public class KthSmallestInBST_LC230 {
    public static void main(String[] args) {

    }
    static int count = 0;
    static int ans = -1;
    public static int kthSmallest(TreeNode root, int k) {
        findKthValue(root, k);
        return ans;
    }
    public static void findKthValue(TreeNode root, int k){
        if(root == null) return;
        findKthValue(root.left, k);
        count += 1;
        if(count == k){
            ans = root.val;
            return;
        }
        findKthValue(root.right, k);
    }
}
