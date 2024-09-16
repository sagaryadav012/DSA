package Graphs.LeetCodeMSC;

public class CountSubIslands_LC1905 {
    public static void main(String[] args) {
        int[][] grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };
        int[][] grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

        System.out.println(countSubIslands(grid1, grid2));
    }
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;

        int count = 0;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid2[row][col] == 1){
                    if(dfs(grid1, grid2, row, col)) count += 1;
                }
            }
        }
        return count;
    }
    private static boolean dfs(int[][] grid1, int[][] grid2, int row, int col){
        // Check if we are out of bounds or at water
        if(row < 0 || row == grid2.length || col < 0 || col == grid2[0].length || grid2[row][col] == 0){
            return true;
        }

        // If grid1 has water where grid2 has land, this is not a sub-island
        if(grid1[row][col] == 0) return false;

        // Mark this part of grid2 as visited by setting it to 0
        grid2[row][col] = 0;

        // Explore in all 4 directions
        boolean top = dfs(grid1, grid2, row - 1, col);
        boolean bottom = dfs(grid1, grid2, row + 1, col);
        boolean left = dfs(grid1, grid2, row, col - 1);
        boolean right = dfs(grid1, grid2, row, col + 1);

        // This is a valid sub-island if all directions return true
        return top && bottom && left && right;
    }
}
