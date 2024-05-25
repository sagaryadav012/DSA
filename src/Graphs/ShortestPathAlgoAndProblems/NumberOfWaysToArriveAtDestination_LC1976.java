package Graphs.ShortestPathAlgoAndProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination_LC1976 {
    public static void main(String[] args) {
        int n = 9;
        int[][] roads = {
                {0, 1, 1},
                {0, 2, 2},
                {0, 3, 1},
                {0, 4 ,2},
                {1, 5, 2},
                {2, 5, 1},
                {3, 5, 2},
                {3, 7, 3},
                {3, 6, 2},
                {4, 6, 1},
                {5, 8, 1},
                {7, 8, 1},
                {6, 8, 1}
        };
        System.out.println(countPaths(n, roads));
    }
    public static int countPaths(int n, int[][] roads) {
        int mod = 1000000009;
        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adjList.get(u).add(new int[]{time, v});
            adjList.get(v).add(new int[]{time, u});
        }

        int[] ways = new int[n];
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]); // It holds {time, node}
        queue.add(new int[]{0,0});

        ways[0] = 1;
        minTime[0] = 0;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int time = pair[0];
            int node = pair[1];
            for (int[] adjacentPair : adjList.get(node)) {
                int reachTime = adjacentPair[0];
                int reachNode = adjacentPair[1];
                int totalTime = time + reachTime;
                if(totalTime < minTime[reachNode]){
                    minTime[reachNode] = totalTime;
                    ways[reachNode] = ways[node];
                    queue.add(new int[]{totalTime, reachNode});
                    continue;
                }
                if(totalTime == minTime[reachNode]) ways[reachNode] = ways[reachNode] + ways[node];
            }
        }

        return ways[n-1]%mod;
    }
}
/*
step1 :- Graph Representation: We create an adjacency list to represent the graph.
step2 :- Priority Queue: We use a priority queue to implement Dijkstra's algorithm,
         which ensures that we always process the node with the smallest current distance.
step3 :- Distance Array: The dist array keeps track of the shortest distance to each node.
step4 :- Ways Array: The ways array keeps track of the number of ways to reach each node with the shortest distance.
step5 :- Dijkstra's Algorithm: While processing each node, we update the shortest distance to its neighbors.
         If we find a new shortest path to a neighbor, we update the distance and the number of ways to reach that neighbor.
         If the shortest path to the neighbor is found again, we update the number of ways.
 */