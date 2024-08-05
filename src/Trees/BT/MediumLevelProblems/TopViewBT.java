package Trees.BT.MediumLevelProblems;

import Trees.LeetCodeMSC.TreeNode;

import java.util.*;

public class TopViewBT {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(topView(node1));
    }
    public static List<Integer> topView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        Map<Integer, Integer> map = new HashMap<>();
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int level = p.level;
            TreeNode node = p.node;

            if(!map.containsKey(level)){
                map.put(level, node.val);
            }

            minCol = Math.min(minCol, level);
            maxCol = Math.max(maxCol, level);

            if(node.left != null) queue.add(new Pair(node.left, level-1));
            if(node.right != null) queue.add(new Pair(node.right, level+1));
        }

        while(minCol <= maxCol){
            res.add(map.get(minCol));
            minCol++;
        }

        return res;
    }
}
