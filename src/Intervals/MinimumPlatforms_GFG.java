package Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumPlatforms_GFG {
    public static void main(String[] args) {

    }
    public static int findPlatform(int arr[], int dep[], int n) {
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++){
            intervals[i] = new int[]{arr[i], dep[i]};
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(int[] interval : intervals){
            if(pq.isEmpty()){
                pq.add(interval);
                continue;
            }
            if(pq.peek()[1] < interval[0]) pq.poll();
            pq.add(interval);
        }
        return pq.size();
    }
}
/*

Given arrival and departure times of all trains that reach a railway station.
Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day.
Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other.
At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.


Example 1:

Input: n = 6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation:
Minimum 3 platforms are required to
safely arrive and depart all trains.

 */