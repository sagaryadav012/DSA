package Trees.LeetCodeMSC;

public class SmallestStringStartingFromLeaf_LC988 {
    public static void main(String[] args) {
//        TreeNode node_1 = new TreeNode(1);
//        TreeNode node_3 = new TreeNode(3);
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3, node0, node2);
//        TreeNode node1 = new TreeNode(1, node_1, node_3);
//        TreeNode node25 = new TreeNode(25, node1, node3);
        int[] nums = {25,1,3,1,3,0,2};
        TreeNode root = BuildTree.buildTree(nums);

        SmallestStringStartingFromLeaf_LC988 obj = new SmallestStringStartingFromLeaf_LC988();
        System.out.println(obj.smallestFromLeaf(root));
    }
    public String smallestFromLeaf(TreeNode root) {
        String[] min = {"~"};
        getStrings(root, new StringBuilder(), min);

        return min[0];
    }
    public void getStrings(TreeNode root, StringBuilder sb, String[] min){
        if(root == null) return;

        if(root.left == null && root.right == null){
            sb.append((char)(root.val + 'a'));
            min[0] = getMin(min[0], sb.reverse().toString());
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append((char)(root.val + 'a'));
        getStrings(root.left, sb, min);
        getStrings(root.right, sb, min);
        sb.deleteCharAt(sb.length() - 1);

    }
    public String getMin(String a, String b){
        if(a.compareTo(b) < 0) return a;
        return b;
    }
}
/*
-> Iterate over tree, use stringBuilder to append all chars, now reverse it compare with min[0] and take min string.

 */