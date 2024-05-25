package Graphs.TopoSortAndProblems;

import java.util.*;

public class FindEventualSafeStates_LC802 {
    public static void main(String[] args) {
        int[][] graph = {
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        System.out.println(eventualSafeNodes(graph));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        int[] incomingEdgesCount = new int[n];
        for (int i = 0; i < n; i++) {
            int[] nodes = graph[i];
            for(int node : nodes){
                adjList.get(node).add(i);
                incomingEdgesCount[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(incomingEdgesCount[i] == 0) queue.add(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for (int adjacentNode : adjList.get(node)) {
                incomingEdgesCount[adjacentNode]--;
                if(incomingEdgesCount[adjacentNode] == 0) queue.add(adjacentNode);
            }
        }
        Collections.sort(res);
        return res;
    }
}
/*
-> We have to find all the safe nodes. Safe nodes are nodes which have all paths ending at terminal node.
   that means all paths from a node start at that node and ends at terminal node.
-> If a node has 3 paths, 2 paths end at terminal node and one path is not, then the node is not safe node.
-> To find it, find paths from terminal node to nodes. and take all nodes.
-> Here terminal nodes are node which don't have outgoing edges.
-> First reverse all edges to traverse from terminal node to all safe nodes.
-> Now find incoming edges count, add all nodes which have count is 0(terminal nodes). Add them to queue,
   add move from there to all paths, and decrease count.
-> when queue is empty and nodes still have count > 0 means those nodes doesn't have all paths to terminal node.
-> If the nodes have all paths to terminal then count will be 0.

 */
