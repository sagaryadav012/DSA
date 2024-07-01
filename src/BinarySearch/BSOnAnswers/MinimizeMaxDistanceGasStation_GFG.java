package BinarySearch.BSOnAnswers;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceGasStation_GFG {
    public static void main(String[] args) {
        int[] stations = {1,2,3,4,5,6,7,8,9,10};
        int k = 9;
        System.out.println(findSmallestMaxDist(stations, k));
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> a < b ? 1 : b > a ? -1 : 0);
        int n = stations.length;

        for(int i = 1; i < n; i++){
            double diff = stations[i] - stations[i-1];
            pq.add(diff);
        }

        while(k > 0){
            double diff = pq.poll();
            double placed = diff / 2;
            pq.add(placed);
            pq.add(placed);
            k--;
        }

        return pq.peek();
    }
}
