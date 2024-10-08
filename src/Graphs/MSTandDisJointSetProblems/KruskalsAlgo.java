package Graphs.MSTandDisJointSetProblems;

import java.util.Arrays;

public class KruskalsAlgo {
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
        int n = 6;
        System.out.println(mst(edges, n));
    }
    public static int mst(int[][] edges, int n) { // TC - O(ELogE) SC - O(E+V)
        // step1 : sort all edges on their weights
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        // step2 : Take each edge, do union, If return yes that means edge doesn't form cycle
        int mst = 0;
        DisjointSet dsu = new DisjointSet(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dsu.union(u, v)) {
                mst += w;
            }
        }
        return mst;
    }
}
/*
-> We need to create MST means all nodes should be connected with min no.of edges
   and weight all edges should be minimum.

Kruskal's Algo :
-> Sort all edges on weight of edge.
-> Take each edge from sorted edges, while choosing edge, make sure edge should not form cycle.
-> Use Disjoint set to check cycle.
-> Count edges which are chosen.
 */
