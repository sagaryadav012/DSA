package Graphs.ShortestPathAlgoAndProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinEffort_LC1631 {
    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        System.out.println(minimumEffortPath(heights));
    }
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] efforts = new int[n][m];
        for (int[] effort : efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0,0,0}); // It holds row, col, maxEffort
        efforts[0][0] = 0;

        int[] row = {0,0,-1,1};
        int[] col = {-1,1,0,0};
        while(!queue.isEmpty()){
            int[] triplet = queue.poll();
            int r = triplet[0];
            int c = triplet[1];
            int maxEffort = triplet[2];

            if(r == n-1 && c == m-1) return maxEffort;

            for(int i = 0; i < 4; i++){
                int newRow = r + row[i];
                int newCol = c + col[i];
                if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;
                int effort = Math.abs(heights[r][c] - heights[newRow][newCol]);
                int currMaxEffort = Math.max(maxEffort,effort);
                if(efforts[newRow][newCol] > currMaxEffort){
                    efforts[newRow][newCol] = currMaxEffort;
                    queue.add(new int[]{newRow, newCol, currMaxEffort});
                }
            }
        }

        return 0;
    }
}

/*
Approach 1 :
-> Generate all paths, track abs difference and take max of all 4 paths.
-> It can be done by DFS.
-> TC - O(4 ^n*m)

Approach 2 :
-> We have to find min effort of all possible paths.
   Example :
        1       2       2
        3       8       2
        5       3       5

    Some possible paths :
    1 ->  2 ->  2 ->  2 -> 5 : Here max abs difference between consecutive numbers is 3(5-3)
    1  ->  3  ->  8  ->  2  ->  5 : Here max abs difference between consecutive numbers is 6(8-2)
    1  ->  3  ->  5  ->  3  ->  5 : Here max abs difference between consecutive numbers is 2(5-3)

    From all possible paths min effort is min difference i.e. 2
-> So use dijkstra algo to find the shortest path. Add start cell to queue, and move to adjacent cells,
   If the abs difference between current cell and adjacent cell is greater than current effort, then take that
   effort, that means if we go in that path we get that difference. So track max difference while moving in path.
-> And store min Effort in cells while moving and add to queue to process all these pairs.
-> When an adjacent node is n-1,m-1 don't return it from there only, store effort, there could be a chance
   that another path can have min effort than current effort.
-> But when we poll pair, If it is n-1,m-1 then return distance, since we polled min effort, the pairs after
   this pair must have max effort, and there is no chance to get min effort than the current effort so return
   from here only.


 */