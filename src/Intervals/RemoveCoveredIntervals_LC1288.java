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
/*
 -> why do we need to sort on end when starts are same ?  Dry run this 2,8  2,6  2,3
 -> How do we say an interval is covered by another interval? for example there are 2 intervals  s1,e1 and s2,e2
    If we say s1,e1 covers s2,e2 that means s1 should start at s2 point or less than s2 point and
    e1 ends at e2 point or more than e2 point then only s1,e1 covers s2,e2.
-> So when starts are same then sort on ends to find easily which interval covers.
 */