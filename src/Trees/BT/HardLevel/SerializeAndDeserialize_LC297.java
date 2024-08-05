package Trees.BT.HardLevel;

import Trees.BT.Traversals.LevelOrderTraversal;
import Trees.LeetCodeMSC.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize_LC297 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node4, node5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node2, node3);
        String data = serialize(node1);
        System.out.println(data);
        TreeNode root = deserialize(data);
        System.out.println(LevelOrderTraversal.levelOrderTraversal(root));
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                sb.append("#,");
                continue;
            }
            String s = String.valueOf(node.val);
            sb.append(s+",");

            queue.add(node.left);
            queue.add(node.right);
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] strings = data.split(",");

        if(strings[0].equals("#")) return null;
        int num = Integer.parseInt(strings[0]);
        TreeNode root = new TreeNode(num);

        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            String leftString = strings[i++];
            String rightString = strings[i++];
            if(!leftString.equals("#")){
                int leftNum = Integer.parseInt(leftString);
                node.left = new TreeNode(leftNum);
                queue.add(node.left);
            }
            if(!rightString.equals("#")){
                int rightNum = Integer.parseInt(rightString);
                node.right = new TreeNode(rightNum);
                queue.add(node.right);
            }
        }
        return root;
    }
}
