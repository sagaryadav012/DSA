package Graphs.ProblemsOnBFS_DFS;

public class NumberOfEnclaves_LC1020 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(numEnclaves1(grid));
    }
    public static int numEnclaves1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] row = {0,0,-1,1};
        int[] col = {-1,1,0,0};

        for(int r = 0; r < n; r++){
            if(grid[r][0] == 1) dfs(r, 0, grid, vis, row, col);
            if(grid[r][m-1] == 1) dfs(r, m-1, grid, vis, row, col);
        }
        for(int c = 0; c < m; c++){
            if(grid[0][c] == 1) dfs(0, c, grid, vis, row, col);
            if(grid[n-1][c] == 1) dfs(n-1, c, grid, vis, row, col);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]) count += 1;
            }
        }
        return count;
    }
    public static void dfs(int r, int c, int[][] grid, boolean[][] vis, int[] row, int[] col) {
        vis[r][c] = true;
        for(int i = 0; i < 4; i++){
            int newRow = r + row[i];
            int newCol = c + col[i];
            if(!isValid(newRow, newCol, grid.length, grid[0].length, grid) || vis[newRow][newCol]) continue;
            dfs(newRow, newCol, grid, vis, row, col);
        }
    }
    public static boolean isValid(int r, int c, int n, int m, int[][] grid){
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) return false;
        return true;
    }

    // Approach 2
    public static int numEnclaves2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int r = 0; r < n; r++){
            if(grid[r][0] == 1) dfs(r, 0, n, m, grid);
            if(grid[r][m-1] == 1) dfs(r, m-1, n, m, grid);
        }
        for(int c = 0; c < m; c++){
            if(grid[0][c] == 1) dfs(0, c, n, m, grid);
            if(grid[n-1][c] == 1) dfs(n-1, c, n, m, grid);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) count += 1;
            }
        }
        return count;
    }
    public static void dfs(int r, int c, int n, int m, int[][] grid) {
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) return;

        grid[r][c] = 0;

        dfs(r+1, c, n, m, grid);
        dfs(r-1, c, n, m, grid);
        dfs(r, c+1, n, m, grid);
        dfs(r, c-1, n, m, grid);
    }
}

/*
Approach 1 :
-> Iterate on boundaries of matrix, If we find any land cell(1), do dfs traversal in all 4 directions.
   And make all cells are visited in result arr, result arr store state of cell that whether we can
   reach or not from boundaries.
-> Once find all cell which can be visited, then iterate over matrix and check is there any land cell,
   If yes check cell status in result arr, If it false, count += 1 it means there is a land cell
   which cannot be reached from boundary or the land cell surrounded by water cells.

Approach 2 :
-> Traverse on boundaries of grid, If we find land cell then do dfs traversal in all 4 directions.
   And make cells are water cell, So that we don't need another array to keep track of which land
   cells are reachable from boundaries.
-> Once we done, check if any land cells left and count them.
 */