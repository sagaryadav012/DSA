package Trees.LeetCodeMSC;

public class SumRootToLeafNumbers_LC129 {
    public static void main(String[] args) {
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node9 = new TreeNode(9, node5, node1);
//        TreeNode node4 = new TreeNode(4, node9, node0);
        int[] nums = {4,9,0,5,1};
        TreeNode root = BuildTree.buildTree(nums);

        SumRootToLeafNumbers_LC129 obj = new SumRootToLeafNumbers_LC129();

        System.out.println(obj.sumNumbers(root));
    }
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        getNums(root, 0);
        return totalSum;
    }
    public void getNums(TreeNode root, int num){
        if(root == null) return;
        if(root.left == null && root.right == null){
            num = num * 10 + root.val;
            totalSum += num;
            return;
        }
        num = num * 10 + root.val;
        getNums(root.left, num);
        getNums(root.right, num);
    }
}
