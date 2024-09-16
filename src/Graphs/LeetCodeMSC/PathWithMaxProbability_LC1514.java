package Graphs.LeetCodeMSC;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaxProbability_LC1514 {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0,1},
                {1,2},
                {0,2}
        };
        double[] succProb = {0.5, 0.5, 0.3};
        int start_node = 0;
        int end_node = 2;
        System.out.println(maxProbability(n, edges, succProb, start_node, end_node));
    }
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList());
        }

        int m = edges.length;
        for(int i = 0; i < m; i++){
            int[] edge = edges[i];
            double probVal = succProb[i];
            adjList.get(edge[0]).add(new Pair(edge[1], probVal));
            adjList.get(edge[1]).add(new Pair(edge[0], probVal));
        }

        boolean[] vis = new boolean[n];
        dfs(vis, adjList, start_node, end_node, 1.0);

        return maxProb;
    }
    private static double maxProb = 0.0;
    private static boolean dfs(boolean[] vis, List<List<Pair>> adjList, int currNode, int endNode, double currProb){
        if(currNode == endNode) return true;
        vis[currNode] = true;

        for(Pair neighbour : adjList.get(currNode)){
            if(vis[neighbour.v]) continue;
            currProb = currProb * neighbour.prob;
            if(dfs(vis, adjList, neighbour.v, endNode, currProb)){
                maxProb = Math.max(maxProb, currProb);
            }
            currProb /= neighbour.prob;
        }
        vis[currNode] = false;
        return false;
    }

    public double maxProbability1(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList());
        }

        int m = edges.length;
        for(int i = 0; i < m; i++){
            int[] edge = edges[i];
            double probVal = succProb[i];
            adjList.get(edge[0]).add(new Pair(edge[1], probVal));
            adjList.get(edge[1]).add(new Pair(edge[0], probVal));
        }

        double[] probs = new double[n];
        probs[start_node] = 1.0;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> Double.compare(p2.prob, p1.prob));
        maxHeap.add(new Pair(start_node, 1.0));

        while(!maxHeap.isEmpty()){
            Pair p = maxHeap.poll();
            int node = p.v;
            double curProb = p.prob;

            if(node == end_node) return probs[node];

            for(Pair neighbour : adjList.get(node)){
                int nextNode = neighbour.v;
                double edgeProb = neighbour.prob;
                double newProb = curProb * edgeProb;

                if(newProb > probs[nextNode]){
                    probs[nextNode] = newProb;
                    maxHeap.add(new Pair(nextNode, newProb));
                }
            }
        }

        return 0.0;
    }
}
class Pair{
    int v;
    double prob;
    Pair(int v, double prob){
        this.v = v;
        this.prob = prob;
    }
}
