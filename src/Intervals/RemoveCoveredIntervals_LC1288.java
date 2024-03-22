package Intervals;

import java.util.Arrays;

public class RemoveCoveredIntervals_LC1288 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,4},
                {3,6},
                {2,8},
                {1,9}
        };
        System.out.println(removeCoveredIntervals(intervals));
    }
    public static int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
        int c = intervals[0][0];
        int d = intervals[0][1];
        int count = 0;
        for(int i = 1; i < n; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];

            if(c <= a && b <= d){
                count += 1;
                continue;
            }
            c = a;
            d = b;
        }
        return n - count;
    }
}
