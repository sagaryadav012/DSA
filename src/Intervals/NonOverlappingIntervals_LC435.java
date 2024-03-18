package Intervals;

import java.util.Arrays;

public class NonOverlappingIntervals_LC435 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (I1, I2) -> I1[1] - I2[1]);

        int[] prev = intervals[0];
        int count = 0;

        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];

            if(prev[1] <= curr[0]){
                prev = curr;
                continue;
            }
            count += 1;
        }

        return count;
    }
}
