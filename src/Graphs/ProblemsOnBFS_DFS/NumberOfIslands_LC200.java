package Graphs.ProblemsOnBFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_LC200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) { // TC - O(N^2) SC -O(N^2)
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    bfs(grid, vis, i, j, n, m);
                    count += 1;
                }
            }
        }
        return count;
    }
    public static void bfs(char[][] grid, boolean[][] vis, int i, int j, int n, int m){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        vis[i][j] = true;
        int[] delRow = {-1,1,0,0};
        int[] delCol = {0,0,-1,1};
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int row = pair[0];
            int col = pair[1];
            for(int k = 0; k < 4; k++){
                int nRow = row + delRow[k];
                int nCol = col + delCol[k];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    if(grid[nRow][nCol] == '1' && !vis[nRow][nCol]){
                        queue.add(new int[]{nRow, nCol});
                        vis[nRow][nCol] = true;
                    }
                }
            }
        }
    }

    static int rows;
    static int cols;

    public static int numIslands1(char[][] grid) {
        if (grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        int islands = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    bfs1(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void bfs1(char[][] grid, int r, int c) {
        grid[r][c] = '*';
        if (r > 0 && grid[r - 1][c] == '1') {
            bfs1(grid, r - 1, c);
        }
        if (r + 1 < rows && grid[r + 1][c] == '1') {
            bfs1(grid, r + 1, c);
        }
        if (c > 0 && grid[r][c - 1] == '1') {
            bfs1(grid, r, c - 1);
        }
        if (c + 1 < cols && grid[r][c + 1] == '1') {
            bfs1(grid, r, c + 1);
        }
    }
}
