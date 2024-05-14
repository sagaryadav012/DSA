package Trees.BST.EasyLevel;

import Trees.BST.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumBST_LC653 {

    // Approach 1 :
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        int l = 0, r = ans.size() - 1;
        while(l < r){
            int sum = ans.get(l) + ans.get(r);
            if(sum == k) return true;
            else if(sum < k) l++;
            else r--;
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> ans){
        if(root != null){
            inorder(root.left, ans);
            ans.add(root.val);
            inorder(root.right, ans);
        }
    }

    // Approach 2
    boolean isExist = false;
    HashSet<Integer> hs = new HashSet<>();
    public boolean findTarget1(TreeNode root, int k) {
        sum(root, k);
        return isExist;
    }
    public TreeNode sum(TreeNode root, int k){
        if(root == null) return null;
        if(hs.contains(k - root.val)){
            isExist = true;
        }
        else{
            hs.add(root.val);
            sum(root.left, k);
            sum(root.right, k);
        }
        return root;
    }
}
