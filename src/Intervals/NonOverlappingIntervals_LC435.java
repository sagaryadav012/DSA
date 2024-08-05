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

/*
-> Why do we need to sort on end time?
   Let's see example {[1,50], [1,10], [11, 20], [21,30]} these intervals sorted on start time.
   Here interval 1,50 covered all other intervals. When we check [1,50] with other intervals, they overlap.
   So we increment count, instead of removing all other, remove bigger interval, To remove it sort intervals
   on end time. [1,10], [1,50], [11, 20], [21,30].
   [1,10], [1,50] are overlapping so remove second one and count += 1, except those non overlapping.
   So here min intervals to remove count is 1.
 */