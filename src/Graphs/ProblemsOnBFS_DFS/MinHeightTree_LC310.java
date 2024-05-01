package Graphs.ProblemsOnBFS_DFS;

import java.util.*;

public class MinHeightTree_LC310 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {3,0},
                {3,1},
                {3,2},
                {3,4},
                {5,4}
        };
        System.out.println(findMinHeightTrees(n, edges));
    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return new ArrayList<>(Arrays.asList(0));

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<Integer> leafNodes = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int label = entry.getKey();
            if(entry.getValue().size() == 1){
                leafNodes.add(label);
            }
        }

        while(n > 2){
            n -= leafNodes.size();
            List<Integer> newLeafNodes = new ArrayList<>();
            for(int leaf : leafNodes){
                int child = (int)graph.get(leaf).iterator().next();
                graph.get(child).remove(leaf);
                if(graph.get(child).size() == 1){
                    newLeafNodes.add(child);
                }
            }
            leafNodes = newLeafNodes;
        }

        return leafNodes;
    }
}
/*
Approach 1 :
-> Create graph, take each node as root node and do BFS to find level(height)
-> TC - O(N * N+E)

Approach 2 :
-> For example a tree is linear tree like a -> b -> c -> d -> e, If where we pick(root) then the height is min?
   If consider leaf node as root then height would be long, If we consider mid node as root then Height would be min.
-> So create graph, check which are leaf nodes, remove edge and again check for leaf nodes repeat this process till
   there could one or two nodes left in graph, If no.of nodes are odd there could be only one root node,
   nodes are even there could to possible ans so repeat till 2 or 1 nodes left.
-> TC - O(V+E)
 */