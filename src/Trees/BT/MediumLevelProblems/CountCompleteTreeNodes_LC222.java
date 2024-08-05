package Trees.BT.MediumLevelProblems;

import Trees.LeetCodeMSC.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes_LC222 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair( root, 1));

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Pair p = queue.poll();
                TreeNode node = p.node;
                int index = p.level;
                if(node.left == null) return index * 2 - 1;
                if(node.right == null) return index * 2 + 1 - 1;
                queue.add(new Pair(node.left, index * 2));
                queue.add(new Pair(node.right, index * 2 + 1));
                size -= 1;
            }
        }
        return 0;
    }
    public int countNodes1(TreeNode root) {
        if(root == null) return 0;

        return 1 + countNodes1(root.left) + countNodes1(root.right);
    }
}
