package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1971_DFS_AdjMatrix {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
//                {0,1},
//                {1,2},
//                {3,5},
//                {5,4},
//                {4,3}
                {0,1},
                {1,2},
                {2,0}
        };
        int source = 0;
        int destination = 5;
        System.out.println(validPathDFSAdjMatrix(n, edges, source, destination));
        System.out.println(validPathBFSAdjMatrix(n, edges, source, destination));
        System.out.println(validPathDFSAdjList(n, edges, source, destination));
        System.out.println(validPathBFSAdjMatrix(n, edges, source, destination));
    }

    //Using Adjacency matrix - DFS : TC - O(V^2)  SC - O(V^2 + V + V(recursive stack))
    // Why Tc v^2 -> since we are checking each row(children) of each node
    public static boolean validPathDFSAdjMatrix(int n, int[][] edges, int source, int destination) {
        // step1 : create a graph(adjacency matrix)
        boolean[][] graph = new boolean[n][n];

        //step2 : establish connections, if there is an edge between two vertices then make it true;
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            // since graph is bidirectional
            graph[u][v] = true;
            graph[v][u] = true;
        }
        // step3 : We need visited array to mark the nodes as visited
        boolean[] vis = new boolean[n];

        // step4 : do traversal and return ans;
        return bfs(graph, source, destination, n, vis);
    }
    public static boolean bfs(boolean[][] graph, int curr_node, int dest, int n, boolean[] vis){
        if(curr_node == dest) return true;
        vis[curr_node] = true;

        // since each node has n neighbours(row len). So check all does it have any edge their.
        for(int i = 0; i < n; i++){
           if(graph[curr_node][i] && !vis[i]){
               if(bfs(graph, i, dest, n, vis)) return true;
           }
        }
        return false;
    }

    //Using Adjacency matrix - BFS : TC - O(V^2)  SC - O(V^2 + V + V)
    public static boolean validPathBFSAdjMatrix(int n, int[][] edges, int source, int destination) {
        // step1 : create a graph(adjacency matrix)
        boolean[][] graph = new boolean[n][n];

        //step2 : establish connections, if there is an edge between two vertices then make it true;
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            // since graph is bidirectional
            graph[u][v] = true;
            graph[v][u] = true;
        }
        // step3 : We need visited array to mark the nodes as visited
        boolean[] vis = new boolean[n];

        // Use queue to track nodes
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        vis[source] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 0; i < n; i++){
                if(graph[node][i] && !vis[i]){
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }

        return vis[destination];
    }

    //Using Adjacency List - DFS : TC - O(V + E)  SC - O((V + E) + V + V)
    public static boolean validPathDFSAdjList(int n, int[][] edges, int source, int destination) {
        // step1 : create a graph(adjacency matrix)
        List<List<Integer>> graph = new ArrayList<>();

        // step2 : initially graph doesn't have inner lists. So add lists to hold children or neighbours
        for(int i = 0; i < n; i++){
            graph.add(i, new ArrayList<>());
        }

        //step3 : now add neighbours of node
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            // since graph is bidirectional
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // step4 : We need visited array to mark the nodes as visited
        boolean[] vis = new boolean[n];

        return bfsAdjList(graph, source, destination, vis);

    }
    public static boolean bfsAdjList(List<List<Integer>> graphs, int curr, int dest, boolean[] vis){
        if(curr == dest) return true;
        vis[curr] = true;

        for(int neighbour : graphs.get(curr)){
            if(!vis[neighbour]){
                if(bfsAdjList(graphs, neighbour, dest, vis)) return true;
            }
        }
        return false;
    }
    public static boolean validPathBFSAdjList(int n, int[][] edges, int source, int destination) {
        // step1 : create a graph(adjacency matrix)
        List<List<Integer>> graph = new ArrayList<>();

        // step2 : initially graph doesn't have inner lists. So add lists to hold children or neighbours
        for(int i = 0; i < n; i++){
            graph.add(i, new ArrayList<>());
        }

        //step3 : now add neighbours of node
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            // since graph is bidirectional
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // step4 : We need visited array to mark the nodes as visited
        boolean[] vis = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        vis[source] = true;

        while(!queue.isEmpty()){
            int currNode = queue.poll();
            if(currNode == destination) return true;
            for(int neighbour : graph.get(currNode)){
                if(!vis[neighbour]){
                    queue.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return false;
    }

}
