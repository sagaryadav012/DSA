package DP.TwoD_DP;

import java.util.Arrays;

public class UniqPaths2_LC63 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0 ,0, 0}
        };
        int m = grid.length;
        int n = grid[0].length;

        System.out.println(paths1(grid, 0, 0, m, n));

        int[][] dp = new int[m][n];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(paths2(grid, 0, 0, m, n, dp));
        System.out.println(uniquePathsWithObstacles(grid));
    }
    // Recursive Code : TC - O(2^n) SC - O(R+C)
    public static int paths1(int[][] grid, int row, int col, int m, int n){
        if(row == m || col == n || grid[row][col] == 1) return 0;
        if(row == m-1 && col == n-1) return 1;

        int right = paths1(grid, row, col + 1, m, n);
        int down = paths1(grid, row + 1, col, m, n);
        return right + down;
    }

    // Recursive Code DP(Top - Down Approach -> Memoization) : TC - O(R*C) SC - O(R*C + stackSpace(R+C))
    public static int paths2(int[][] grid, int row, int col, int m, int n, int[][] dp){
        if(row == m || col == n || grid[row][col] == 1) return 0;
        if(row == m-1 && col == n-1) return 1;

        if(dp[row][col] != -1) return dp[row][col];

        int right = paths1(grid, row, col + 1, m, n);
        int down = paths1(grid, row + 1, col, m, n);

        return dp[row][col] = right + down;
    }
    // Iterative Code(Bottom - Up Approach - Tabulation) : TC - O(R*C) SC - O(C);
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        dp[0] = 1;
        for(int c = 1; c < n; c++){
            dp[c] = obstacleGrid[0][c] == 1 ? 0 : dp[c-1]; // To understand this : dry run this {0, 0, 1, 0, 0}
        }

        for(int r = 1; r < m; r++){
            dp[0] = obstacleGrid[r][0] == 1 ? 0 : dp[0]; // To understand this : dry run this {0, 0}, {1, 0}, {0, 0}
            for(int c = 1; c < n; c++){
                if(obstacleGrid[r][c] == 1) dp[c] = 0;
                else dp[c] += dp[c-1];
            }
        }

        return dp[n-1];
    }
}
