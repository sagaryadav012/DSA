package Graphs.ProblemsOnBFS_DFS;

public class NumberOfEnclaves_LC1020 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(numEnclaves(grid));
    }
    public static int numEnclaves(int[][] grid) {
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
}

/*
Approach 1 :
-> It is same as LeetCode 130, Take all the lands that are on boundaries, do dfs mark cells are visited.
-> Now traverse through each cell in grid, Check if it is land then check is it visited, If yes then that
   land not surrounded by water so don't count, else count.
 */