package Trees.BT.HardLevel;

import Trees.LeetCodeMSC.TreeNode;

import java.util.*;

public class VerticalOrderTraversal_LC987 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(verticalTraversal(node1));
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root){
        Queue<Pairr> queue = new LinkedList<>();
        queue.add(new Pairr(0,0,root));
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        while(!queue.isEmpty()){
            Pairr p = queue.poll();
            int row = p.row;
            int col = p.col;
            TreeNode node = p.node;
            if(map.containsKey(col)){
                Map<Integer, PriorityQueue<Integer>> innerMap = map.get(col);
                PriorityQueue<Integer> innerQueue = innerMap.getOrDefault(row, new PriorityQueue<>());
                innerQueue.add(node.val);
                innerMap.put(row, innerQueue);
                map.put(col, innerMap);
//                map.get(col).getOrDefault(row, new PriorityQueue<>()).add(node.val);

            }else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(node.val);
                Map<Integer, PriorityQueue<Integer>> innerMap = new TreeMap<>();
                innerMap.put(row, pq);
                map.put(col, innerMap);
            }

            if(node.left != null) queue.add(new Pairr(row+1, col-1, node.left));
            if(node.right != null) queue.add(new Pairr(row+1, col+1, node.right));
        }

        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> entry : map.entrySet()){
            List<Integer> list = new ArrayList<>();

            for(Map.Entry<Integer, PriorityQueue<Integer>> entryy : entry.getValue().entrySet()){
                PriorityQueue<Integer> pq = entryy.getValue();
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}
class Pairr{
    int row, col;
    TreeNode node;

    Pairr(int row, int col, TreeNode node){
        this.row = row;
        this.col = col;
        this.node = node;
    }
}
/*
-> It is same as vertical order traversal but the thing is node values at row and col should be in sorted.
-> I have take TreeMap to get keys are sorted in ascending.
-> Map<Integer, Map<Integer, PriorityQueue<Integer>>> treeMap
   Here Outer map holds column and innerMap.
   InnerMap holds row and PriorityQueue.
   PQ holds nodes in ascending at row,col
 */