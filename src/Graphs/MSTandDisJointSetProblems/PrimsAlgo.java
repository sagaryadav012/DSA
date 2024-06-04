package Graphs.MSTandDisJointSetProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2,7}, // {u, v, w}
                {1,4,8},
                {2,3,6},
                {2,3,8},
                {2,4,3},
                {3,4,4},
                {3,5,2},
                {3,6,5},
                {4,5,3},
                {5,6,5}
        };
        int n = 6; // nodes start from 1 to n
        System.out.println(mst(edges, n));
    }
    public static int mst(int[][] edges, int n){
        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new int[]{w,v});
            adjList.get(v).add(new int[]{w,u});
        }

        boolean[] vis = new boolean[n+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]); // It holds {weight, node v}
        queue.add(new int[]{0,1});

        int mst = 0;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int w = pair[0];
            int v = pair[1];

            if(vis[v]) continue;

            vis[v] = true;
            mst += w;

            for (int[] neighbour : adjList.get(v)) {
                if(vis[neighbour[1]]) continue;
                queue.add(neighbour);
            }
        }
        return mst;
    }
}
/*

Prims Algo :

step1 : Start traverse from any node, add node and distance or weight to Priority Queue.
step2 : poll pair, make node visited, add all neighbours to PQ.
step3 : repeat step2 until queue gets empty.

 */