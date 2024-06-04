package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class    InsertInterval_LC57 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval = {4,8};
        for (int[] interval : insert(intervals, newInterval)) {
            System.out.println(Arrays.toString(interval));
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int[] interval = intervals[i];

            if(interval[1] < newInterval[0]){
                res.add(interval);
                continue;
            }

            if(newInterval[1] < interval[0]){
                res.add(newInterval);
                for(int j = i; j < n; j++){
                    res.add(intervals[j]);
                }
                return res.toArray(new int[res.size()][]);
            }

            int s = Math.min(interval[0], newInterval[0]);
            int e = Math.max(interval[1], newInterval[1]);
            newInterval = new int[]{s, e};
        }
        res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}
