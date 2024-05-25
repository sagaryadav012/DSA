package Graphs.ProblemsOnBFS_DFS;

public class DetectCycleInDirectedGraph_DFS {
    public static void main(String[] args) {
        int[][] adjList = {
                {1,3},
                {2},
                {3},
                {}
        };
        System.out.println(isCycle(adjList));
    }
    public static boolean isCycle(int[][] adjList){
        int n = adjList.length;
        boolean[] vis = new boolean[n];
        boolean[] path_visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]){
               if(dfs(i, adjList, path_visited, vis)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(int node, int[][] adjList,boolean[] path_visited, boolean[] vis){
        vis[node] = true;
        path_visited[node] = true;
        for (int neighbourNode : adjList[node]) {
            if(!vis[neighbourNode]){
                if(dfs(neighbourNode, adjList, path_visited, vis)) return true;
            }
            else if(path_visited[neighbourNode]) return true;
        }
        path_visited[node] = false;
        return false;
    }
}
/*
-> Is it possible to detect cycle in Directed graph using BFS ?
   Yes, it is possible to detect a cycle in a directed graph using Breadth-First Search (BFS).
   The approach for detecting cycles in a directed graph using BFS is known as Kahn's Algorithm, which is typically
   used for topological sorting. The key idea is to keep track of the in-degrees (number of incoming edges) of each node.
   If there is a cycle, we won't be able to reduce the in-degrees of all nodes to zero.

Approach 1 : DFS
-> It is not possible to detect cycle in Directed graph with help of only visited array.
    1------->2   1 -> 2, 1 -> 3, 2 -> 4, 3 -> 4 dry run this to know why visited array is enough to check cycle.
    |        |
    |        |
    3-------->4

-> Cycle means the node has been visited again in the same path.
-> Track the path of dfs traversal, if path visited again then check that node is in the same path, if yes
   then there is a cycle in it.
 */
