package Graphs.ProblemsOnBFS_DFS;

import java.util.*;

public class DetectCycleInUnDirectedGraph_BFS {
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
    public static boolean isCycle(int V, List<List<Integer>> adjList){
        boolean[] vis = new boolean[V];
        // If graph has multiple connected components, To check cycle in all connected components
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(bfs(i, adjList, vis)) return true;
            }
        }
        return false;
    }
    public static boolean bfs(int Node, List<List<Integer>> adjList, boolean[] vis){
        Queue<int[]> queue = new LinkedList<>();

        // There is no parent for 0 node so assume it as -1
        queue.add(new int[]{Node, -1});
        vis[Node] = true;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbour : adjList.get(node)) {
//                if(vis[neighbour] && parent != neighbour) return true;
//                if(vis[neighbour]) continue;
//                vis[neighbour] = true;
//                queue.add(new int[]{neighbour, node});

                // If node is not visited yet, then add make it as visited and add to queue.
                if(!vis[neighbour]){
                    vis[neighbour] = true;
                    queue.add(new int[]{neighbour, node});
                    continue;
                }
                // If execution comes here that means node visited, so if it is visited check parent is not neighbour then return true
                if(parent != neighbour) return true;
            }
        }
        return false;
    }
}
/*
-> Detect cycle in undirected graph.
-> What is the cycle here? Cycle means If you start some point, reach same point through a path that means there is cycle.
   If there is cycle then we reach start point again.
-> How to detect cycle? Start from some point and move simultaneously, If we reach a point that already visited by
   someone means there is cycle in that path.
-> BFS traversal would be the best traversal technique to traverse level by level(One level at a time)
-> So store nodes in queue to move level by level, Maintain visited array to do not visit same node again and again.
   And track parent of node, which help to determine that the node path different from another node.
   For example 1 -- 2   moved from 1 to 2, mark as visited, when we move from 2 to 1, 1 already been visited,
   Here the path is 1 --> 2 --> 1 that means we are moving in that path from where we came. And also 1 visited
   already. so it checks and tells there is a cycle, since 1 is already visited. but that is not correct path.
   So keep track of parent node.
-> Here vis array helps to detect cycle, parent is for if vis same node again but should not be the path that node came from.

 */
