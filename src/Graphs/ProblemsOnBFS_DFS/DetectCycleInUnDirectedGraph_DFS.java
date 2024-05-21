package Graphs.ProblemsOnBFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInUnDirectedGraph_DFS {
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(Arrays.asList(1,2));
        adjList.add(Arrays.asList(0,3));
        adjList.add(Arrays.asList(0,4,5));
        adjList.add(Arrays.asList(1,6));
        adjList.add(Arrays.asList(2));
        adjList.add(Arrays.asList(2,6));
        adjList.add(Arrays.asList(3,5));
        System.out.println(isCycle(7, adjList));

    }
    public static boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, -1,  adj, vis)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(int node, int parent, List<List<Integer>> adjList, boolean[] vis){
        vis[node] = true;
        for (int neighbour : adjList.get(node)) {
            if(!vis[neighbour]){
                if(dfs(neighbour, node, adjList, vis)) return true;
            }
            else if(parent != neighbour) return true;
        }
        return false;
    }
}
