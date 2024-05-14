package Trees.BT.HardLevel;

import Trees.TreeNode;

import java.util.*;

public class AllNodesDistanceKinBT_LC863 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode node3 = new TreeNode(3, node5, node1);
        System.out.println(distanceK(node3, node5, 2));
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) { // TC -O(N) SC -O(N)
        Map<TreeNode, TreeNode> parent_nodes = new HashMap<>();
        findParent(root, parent_nodes);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> vis = new HashSet<>();
        int cur_level = 0;
        while(!queue.isEmpty()){
            if(cur_level == k) break;

            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                vis.add(node);

                if(node.left != null && !vis.contains(node.left)){
                    queue.add(node.left);
                }
                if(node.right != null && !vis.contains(node.right)){
                    queue.add(node.right);
                }
                TreeNode parent = parent_nodes.get(node);
                if(parent != null && !vis.contains(parent)){
                    queue.add(parent);
                }
                size--;
            }
            cur_level += 1;
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll().val);
        }
        return res;
    }
    public static void findParent(TreeNode root, Map<TreeNode, TreeNode> parent_nodes){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    parent_nodes.put(node.left, node);
                }
                if(node.right != null){
                    queue.add(node.right);
                    parent_nodes.put(node.right, node);
                }
                size--;
            }
        }
    }
}
/*
-> Observe example 1 in LeetCode question, We can find the nodes at k distance from the target in down the line
   but we can't move back to parent trees.
-> If it is a graph we can find simply doing BFS.
-> In tree evey node has max two connections, If we can find parent connection then we can find nodes by doing BFS.
-> So First find parent of each node and store somewhere, then do normal BFS.
-> For each node, find parent node so use map to store these.
 */
