package Graphs.ShortestPathAlgoAndProblems;

import java.util.Arrays;

public class MinCostToConvertString1_LC2976 {
    public static void main(String[] args){
        String source = "abcd";
        String target = "acbe";
        char[] original = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2,5,5,1,2,20};
        System.out.println(minimumCost(source, target,original, changed, cost));
    }
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long ans = 0;
        int n = source.length();
        final long INF = Long.MAX_VALUE / 2;
        long[][] dist = new long[26][26];

        for (int i = 0; i < 26; ++i) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; ++i) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < 26; ++k)
            for (int i = 0; i < 26; ++i)
                for (int j = 0; j < 26; ++j)
                    if (dist[i][k] < INF && dist[k][j] < INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        for (int i = 0; i < n; ++i) {
            if (source.charAt(i) != target.charAt(i)) {
                int u = source.charAt(i) - 'a';
                int v = target.charAt(i) - 'a';
                if (dist[u][v] == INF) {
                    return -1;
                }
                ans += dist[u][v];
            }
        }

        return ans;
    }
}
