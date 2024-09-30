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
        System.out.println(isBipartite1(graph));
        System.out.println(isBipartite2(graph));
    }
    public static boolean isBipartite1(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for(int i = 0; i < n; i++){
            if(colors[i] == -1){
                if(!dfs(i, 0, graph, colors)) return false;
            }
        }
        return true;
    }
    public static boolean dfs(int start, int color, int[][] graph, int[] colors){
        colors[start] = color;
        for(int node : graph[start]){
            if(colors[node] == -1){
                if(!dfs(node, 1-color, graph, colors)) return false;
            }
            else if(colors[node] == color){
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        int[] colorArr = new int[n];
        Arrays.fill(colorArr, -1);
        for(int i = 0; i < n; i++){
            if(colorArr[i] != -1) continue;
            if(!bfs(graph, colorArr, i)) return false;
        }
        return true;
    }
    public static boolean bfs(int[][] graph, int[] colorArr, int startNode){
        colorArr[startNode] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : graph[node]){
                if(colorArr[neighbour] == -1){
                    queue.add(neighbour);
                    colorArr[neighbour] = 1 - colorArr[node];
                }
                else if(colorArr[neighbour] == colorArr[node]) return false;
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

Approach 2 :
-> Used BFS to color adjacent nodes. Remember input graph can be not connected graph.

 */
