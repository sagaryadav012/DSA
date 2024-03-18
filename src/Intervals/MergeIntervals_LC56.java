package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_LC56 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        for(int[] interval : merge(intervals)){
            System.out.println(Arrays.toString(interval));
        }
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->  a[0] - b[0]);

        int[] prev = intervals[0];
        int n = intervals.length;

        List<int[]> res = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int[] cur = intervals[i];
            if(prev[1] <= cur[0]){
                res.add(prev);
                prev = cur;
                continue;
            }
            prev[0] = Math.min(prev[0], cur[0]);
            prev[1] = Math.max(prev[1], cur[1]);
        }
        res.add(prev);

        int[][] result = new int[res.size()][];
        int idx = 0;
        for(int[] interval : res){
            result[idx++] = interval;
        }

       // int[][] array = res.toArray(new int[res.size()][]);
        return result;
    }
}
