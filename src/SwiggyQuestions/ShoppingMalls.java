package SwiggyQuestions;

import java.util.*;

public class ShoppingMalls {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1,5)); // 0
        graph.add(Arrays.asList(0,2,3,4)); // 1
        graph.add(Arrays.asList(1)); // 2
        graph.add(Arrays.asList(1,6)); // 3
        graph.add(Arrays.asList(1)); // 4
        graph.add(Arrays.asList(0)); // 5
        graph.add(Arrays.asList(3)); // 6

//        int n = graph.size();
//        int maxDistance = 0;
//        for(int i = 0; i < n; i++){
//            maxDistance = Math.max(maxDistance, bfs(i, graph, n));
////            System.out.println(Arrays.toString(bfs));
//        }
//        System.out.println(maxDistance);


        System.out.println(maxDiameter(graph));
    }

    // Approach 1 : TC - O(V * (V+E))
    public static int bfs(int start, List<List<Integer>> graph, int n){
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distances[start] = 0;

        int maxDistance = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : graph.get(node)){
                if(distances[node] + 1 < distances[neighbour]){
                    distances[neighbour] = distances[node] + 1;
                    queue.add(neighbour);
                    maxDistance = Math.max(distances[neighbour], maxDistance);
                }
            }
        }

        return maxDistance;
    }

    public static int[] bfs1(int start, List<List<Integer>> graph, int n){
        int[] distances = new int[n];
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        distances[start] = 0;
        vis[start] = true;

        int maxDistance = 0;
        int farthestNode = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : graph.get(node)){
                if(vis[neighbour]) continue;

                vis[neighbour] = true;
                distances[neighbour] = distances[node] + 1;
                queue.add(neighbour);

                if(maxDistance < distances[neighbour]){
                    maxDistance = distances[neighbour];
                    farthestNode = neighbour;
                }
            }
        }
        return new int[]{farthestNode, maxDistance};
    }
    public static int maxDiameter(List<List<Integer>> graph){
        int n = graph.size();

        int[] pair1 = bfs1(6, graph, n);
        int farthestNode = pair1[0];

        System.out.println(pair1[0]+" : "+pair1[1]);

        int[] pair2 = bfs1(farthestNode, graph, n);
        System.out.println(pair2[0]+" : "+pair2[1]);

        return pair2[1];
    }
}

/*
Question :
Shopping malls of a particular company, X, are represented as a graph network of N nodes
with N-1 edges (path from Node X to residential Node Y).
The stock transfer time between any two connected malls is 1 unit.
Given the graph G,find the maximum time taken to transfer the item between any two malls in the system.

-> We need to find maxDistance between any two nodes so that will be the maxTime to transfer items.

Approach 1 : TC - O(v * (v+e))
-> Calculate the shortest path between all the nodes and take maxDistance.
-> Apply BFS traversal to find the shortest path, since time taken to transfer item to between
   any adjacent nodes is 1(constant), So BFS would be best approach.


Approach 2 :
-> Choose any node(src) and calculate the shortest between src to all nodes.
-> Now take the farthest node which is at maxDistance from src.
-> Calculate again the shortest path between the farthest node to all nodes.
-> Again take the farthest node and maxDistance from result array, which is the maxDistance between any two nodes
   or which maxTime taken to transfer item between any two nodes.
-> How it gives maxTime by following Approach 2 ?
   Example Ar of nodes : 0, 1, 2, 3, 4, 5, 6 Assume distance between any adjacent nodes is 1.
   Here max time taken is 6 to transfer items from 0 to 6 or 6 to 0.

   Now find the farthest node for all above nodes.
   Nodes :              0   1   2   3           4   5   6
   The Farthest Node :  6   6   6   0 or 6      0   0   0

-> The farthest node of any node is 6 or 0.
-> The farthest node of 0 node is 6 and the farthest node of 6 node is 0.
-> Distance between them will be maxTime.

 */