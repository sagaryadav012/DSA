package Graphs.ShortestPathAlgoAndProblems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_LC1091 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1}); // It holds cell and distance(cell count)
        vis[0][0] = true;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int r = pair[0];
            int c = pair[1];
            int distance = pair[2];

            if(r == n-1 && c == n-1) return distance;

            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    int newRow = r + i;
                    int newCol = c + j;
                    if(isValidCell(newRow, newCol, n, grid, vis)){
                        queue.add(new int[]{newRow, newCol, distance+1});
                        vis[newRow][newCol] = true;
                    }
                }
            }
        }
        return -1;
    }
    public static boolean isValidCell(int r, int c, int n, int[][] grid, boolean[][] vis){
        if(r < 0 || r >= n || c < 0 || c >= n || grid[r][c] == 1 || vis[r][c]) return false;
        return true;
    }
}
/*
-> We need to count cells, there is no weights to edges. so simple BFS is enough to calculate shortest path
   when weights are constant.
-> Take cell, search in all 8 directions, If cell value is 0 and not visited yet then add to queue, increment distance.
-> TC - O(V+E)
 */