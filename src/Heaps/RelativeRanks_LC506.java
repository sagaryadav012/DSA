package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks_LC506 {
    public static void main(String[] args) {
        int[] score = {5,4,3,2,1};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        if(n == 0) return new String[]{};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i = 0; i < n; i++){
            pq.add(new int[]{score[i], i});
        }

        String[] ans = new String[n];

        int[] p1 = pq.poll();
        ans[p1[1]] = "Gold Medal";

        int[] p2 = pq.poll();
        ans[p2[1]] = "Silver Medal";

        int[] p3 = pq.poll();
        ans[p3[1]] = "Bronze Medal";

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int index = p[1];
            int val = p[0];
            ans[index] = val + "";
        }
        return ans;
    }
}
