package Graphs.ProblemsOnBFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_LC785 {
    public static void main(String[] args) {
        int[][] graph = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for(int i = 0; i < n; i++){
            if(colors[i] == -1){
                if(!checkIsBipartite(i, 0, graph, colors)) return false;
            }
        }
        return true;
    }
    public static boolean checkIsBipartite(int start, int color, int[][] graph, int[] colors){
        colors[start] = color;
        for(int node : graph[start]){
            if(colors[node] == -1){
                if(!checkIsBipartite(node, 1-color, graph, colors)) return false;
            }
            else if(colors[node] == color){
                return false;
            }
        }
        return true;
    }
}
/*
-> Question says that A graph is bipartite if the nodes can be partitioned into two independent
   sets A and B such that every edge in the graph connects a node in set A and a node in set B.
-> That means there is no edge between the nodes in same set, All edges in graph connected one node from set A
   and another node from set B.

Approach 1 :
-> Bipartite means, graph can be colored by two colors. If not, it means graph can't be bipartite.
-> Graph can't be bipartite only when it has cycle with odd no.of nodes.
-> Take array help to store color of node. use BFS traversal and color the node.
-> If adjacent node has same color then return false.

 */
