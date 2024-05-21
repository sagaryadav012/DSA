package Graphs.ProblemsOnBFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges_LC994 {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2) queue.add(new int[]{i, j, 0});
            }
        }

        int[] row = {0,0,-1,1};
        int[] col = {-1,1,0,0};
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int[] cell = queue.poll();
                int i = cell[0];
                int j = cell[1];
                int t = cell[2];
                time = Math.max(time, t);
                for(int p = 0; p < 4; p++){
                    int newRow = i + row[p];
                    int newCol = j + col[p];
                    if(!isValidCell(newRow, newCol, grid, n, m)) continue;
                    grid[newRow][newCol] = 2;
                    queue.add(new int[]{newRow, newCol, t+1});
                }
                size--;
            }
        }

        for (int[] oranges : grid) {
            for (int orange : oranges) {
                if(orange == 1) return -1;
            }
        }
        return time;
    }
    public static boolean isValidCell(int i, int j, int[][] grid, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 2 || grid[i][j] == 0) return false;
        return true;
    }
}
/*
Approach 1 :
-> Oranges that are adjacent to rotten oranges will be rottener.
-> So first find places where rotten oranges are, then move all 4 sides simultaneously if we find fresh oranges
   then make them are rotten. Calculate time while moving.
-> So first I will take places of rotten oranges, add them to queue, with help of queue can process all rotten oranges
   at a time. Do multiple BFS traversals;

 */
