package Graphs.ShortestPathAlgoAndProblems;

import java.util.*;

public class DijkstraAlgo_ShortestPath {
    public static void main(String[] args) {
        int[][] edges = { // UnDirected Graph
                {1,2,7}, // {u,v,distance}
                {1,3,8},
                {2,4,6},
                {2,3,3},
                {3,4,4},
                {3,5,3},
                {4,6,5},
                {4,5,2},
                {5,6,5},
                {5,7,2},
                {6,7,2}
        };
        int V = 7;
        int src = 1;
        System.out.println(Arrays.toString(shortestPath(edges, V, src)));
    }
    public static int[] shortestPath(int[][] edges, int V, int src){ // TC - O(V+E)
        List<List<int[]>> adjList = new ArrayList<>(); // it holds list of {v,distance}
        for(int i = 0; i <= V; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            adjList.get(u).add(new int[]{v, dist});
            adjList.get(v).add(new int[]{u, dist});
        }

        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src - 1] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int node = pair[0];
            int distance = pair[1];
            for (int[] adjacentPair : adjList.get(node)) {
                int adjacentNode = adjacentPair[0];
                int adjacentDist = adjacentPair[1];
                int newDistance = distance + adjacentDist;
                if(distances[adjacentNode - 1] > newDistance){
                    distances[adjacentNode - 1] = newDistance;
                    queue.add(new int[]{adjacentNode, newDistance});
                }
            }
        }
        return distances;
    }
}
/*
-> Dijkstra algo is used to find shortest path between all nodes from source node.
-> We use BFS traversal to find this. First add distance 0 and source node to queue.
-> Take an array to keep track of min distance to reach a node, Initially all are assigned to infinity means
   They are not yet visited.
-> Take pair from queue, calculate distance to reach neighbour, if distance is less than previous reachable distance,
   then update distance and add to queue.
-> It can be done without using priority queue. PQ helps to fetch min distance first for example to reach 14 node
   there were two pairs in queue like 20,14 and 10,14. First we get 20,14 pair and we calculate dist to all
   adjacent nodes with distance 20. Again we get pair 10,14 then again calculate distance, this time we get
   min distance for sure, so will update distance array again. Instead of this If we can fetch min distance
   pair first, max distance pair next then we update distance array only once.
-> This is how PQ helps.
-> If we use PQ then TC - O(ElogE) no.of edges added to PQ.
-> Without PQ, TC - O(V+E) Simple BFS traversal.
 */