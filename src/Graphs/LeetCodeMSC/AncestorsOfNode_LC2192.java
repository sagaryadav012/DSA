package Graphs.LeetCodeMSC;

import java.util.ArrayList;
import java.util.List;

public class AncestorsOfNode_LC2192 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0,1}, {0,2}, {0,3}, {0,4},
                {1,2}, {1,3}, {1,4},
                {2,3}, {2,4}, {3,4}
        };
        System.out.println(getAncestors(n, edges));
    }
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        List<List<Integer>> ancestors = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
            ancestors.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }

        for(int i = 0; i < n; i++){
            boolean[] vis = new boolean[n];
            dfs(i, i, vis, adjList, ancestors);
        }

        return ancestors;
    }
    public static void dfs(int ancestor, int node, boolean[] vis, List<List<Integer>> adjList, List<List<Integer>> ancestors){
        vis[node] = true;
        for(int neighbour : adjList.get(node)){
            if(vis[neighbour]) continue;
            ancestors.get(neighbour).add(ancestor);
            dfs(ancestor, neighbour, vis, adjList, ancestors);
        }
    }
}
