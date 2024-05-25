package Graphs.ShortestPathAlgoAndProblems;

import java.util.*;

public class ShortestFlightsWithInKStops_LC787 {
    public static void main(String[] args) {
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> routes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            routes.add(0, new ArrayList<>());
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            routes.get(from).add(new int[]{to, price});

        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        queue.add(new int[]{0, src, 0});
        dis[src] = 0;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int stops = pair[0];
            int fromCity = pair[1];
            int price = pair[2];

            if(stops > k) continue;

            for(int[] route : routes.get(fromCity)){
                int toCity = route[0];
                int toCost = route[1];
                int newPrice = price + toCost;
                if(newPrice < dis[toCity]){
                    dis[toCity] = newPrice;
                    queue.add(new int[]{stops+1, toCity, newPrice});
                }
            }
        }

        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}
/*
-> We use dijkstra to find the shortest path, but here this algo doesn't work directly.
-> We need to find the shortest path with at most k stops, so work on stops.
-> First take pair(stops, toCity, newPrice) add to queue, move to possible adjacent cities while moving store cost,
   If city already visited by some other path with at most k stops and gives high cost than  current cost then
   store current cost, add to queue that pair and process it.
-> We have to find the cheapest price to reach dest with in at most k stops, so do simple BFS, stops should not go beyond k
   If we can reach destination then return price to reach there. While moving update price If we can reach with low price to there.
-> Why don't we take priority queue to fetch small stops, think we are moving at each step we increase stop by +1 that means
   the pairs that were in queue are already in sorted.
-> TC - O(V+E)
 */