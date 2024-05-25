package Graphs.TopoSortAndProblems;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(1,3));
        adj.add(Arrays.asList(2,3));
        adj.add(Arrays.asList(4,5));
        adj.add(Arrays.asList(4));
        adj.add(Arrays.asList(5));
        adj.add(Arrays.asList());
        adj.add(Arrays.asList(3,5));
        int V = 7;
        System.out.println(Arrays.toString(topoSort(V, adj)));
    }
    public static int[] topoSort(int V, List<List<Integer>> adj) { // TC - O(V+E)
        int[] edgeCount = new int[V];
        for(List<Integer> list : adj){
            for(int node : list){
                edgeCount[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(edgeCount[i] == 0) queue.add(i);
        }

        int[] res = new int[V];
        int index = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            res[index++] = node;

            for(int neighbour : adj.get(node)){
                edgeCount[neighbour]--;
                if(edgeCount[neighbour] == 0) queue.add(neighbour);
            }
        }
        return res;
    }
}
/*
Topological sort : Topological sorting is an algorithm used in graph theory, specifically for directed acyclic graphs (DAGs).
                   It provides a linear ordering of the vertices such that for every directed edge from u to v,
                   u comes before v in ordering.

Approach 1 : BFS traversal technique.
-> If there is an edge between u to v, then u comes before v.
-> so count incoming edges to node, and process the nodes which don't have incoming edges first.
-> or process the nodes in order of which nodes have less count of incoming edges.
-> So first count incoming edges of nodes, take nodes which have 0 count of incoming edges, add them to queue.
-> Take each node from queue and decrease the count of incoming edges of current node neighbours.
-> If neighbour node count is 0 add it to queue.
 */
