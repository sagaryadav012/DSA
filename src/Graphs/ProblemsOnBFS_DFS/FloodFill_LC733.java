package Graphs.ProblemsOnBFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill_LC733 {
    public static void main(String[] args) {
        int[][] image = {
//                {1,1,1},
//                {1,1,0},
//                {1,0,1}
                {0,0,0},
                {0,0,0}
        };
        int sr = 0;
        int sc = 0;
        int color = 0;
        for (int[] row : floodFill1(image, sr, sc, color)) {
            System.out.println(Arrays.toString(row));
        }
    }

    // BFS Traversal
    public static int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initialColor = image[sr][sc];

        if(initialColor == color) return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        image[sr][sc] = color;

        int[] row = {0,0,-1,1};
        int[] col = {-1,1,0,0};

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            for(int r = 0; r < 4; r++){
                int newRow = i + row[r];
                int newCol = j + col[r];
                if(!isValid(newRow, newCol, image, n, m, initialColor)) continue;
                image[newRow][newCol] = color;
                queue.add(new int[]{newRow, newCol});
            }
        }
        return image;
    }
    public static boolean isValid(int i, int j, int[][] image,int n, int m, int initialColor){
        if(i < 0 || i == n || j < 0 || j == m || image[i][j] != initialColor) return false;
        return true;
    }

    // DFS Traversal
    public static int[][] floodFill2(int[][] image, int sr, int sc, int color){
        int rows = image.length;
        int cols = image[0].length;

        int val = image[sr][sc];

        dfs(image,sr,sc,color,val);

        return image;
    }
    public static void dfs(int[][] grid, int i , int j, int color,int val){

        int rows = grid.length;
        int cols = grid[0].length;

        if(i<0 || j<0 || j>=cols || i>=rows || grid[i][j]!=val || grid[i][j]==color){
            return;
        }

        if(grid[i][j]==val){
            grid[i][j]=color;
        }

        dfs(grid,i,j+1,color,val);
        dfs(grid,i-1,j,color,val);
        dfs(grid,i,j-1,color,val);
        dfs(grid,i+1,j,color,val);

    }
}
