package Graphs.ProblemsOnBFS_DFS;

import java.util.*;

public class DetectCycleInDirectedGraph_BFS {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(1,2));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList());
        int V = 3;
        System.out.println(isCyclic(V, adj));
    }
    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        // code here
        int[] edgeCount = new int[V];
        for(List<Integer> list : adj){
            for(int node : list){
                edgeCount[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(edgeCount[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int neighbour : adj.get(node)){
                edgeCount[neighbour]--;
                if(edgeCount[neighbour] == 0) queue.add(neighbour);
            }
        }

        for(int i = 0; i < V; i++){
            if(edgeCount[i] > 0) return false;
        }
        return true;
    }
}
/*
-> Detect cycle in graph using BFS is possible only with topological sort technique.
-> Topological sort is not possible in cyclic graph.
-> Count incoming edges of each node, process nodes which have 0 incoming edges and decrease the edge count of
   neighbour nodes. If they 0 count add to queue and process it.
-> If there is a cycle in graph then any of node incoming edge count will be 1.
 */