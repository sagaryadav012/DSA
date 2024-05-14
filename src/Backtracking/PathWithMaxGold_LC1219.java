package Backtracking;

public class PathWithMaxGold_LC1219 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        System.out.println(getMaximumGold(grid));
    }
    public static int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, -1, 0, 1};
        int maxGold = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) continue;
                int score = dfs(grid, n, m, i, j, row, col);
                maxGold = Math.max(maxGold, score);
            }
        }
        return maxGold;
    }
    public static int dfs(int[][] grid, int n, int m, int r, int c, int[] row, int[] col){
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) return 0;

        int gold = grid[r][c];
        grid[r][c] = 0;

        int maxGold = 0;

        for(int i = 0; i < 4; i++){
           int newRow = r + row[i];
           int newCol = c + col[i];

           int collectedGold = dfs(grid, n, m, newRow, newCol, row, col);
           maxGold = Math.max(maxGold, collectedGold);
        }
        grid[r][c] = gold;
        return gold + maxGold;
    }

}
