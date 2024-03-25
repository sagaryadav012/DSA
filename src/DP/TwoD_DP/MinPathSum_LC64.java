package DP.TwoD_DP;

import java.util.Arrays;

public class MinPathSum_LC64 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int R = grid.length;
        int C = grid[0].length;
        System.out.println(minPathSum1(grid, R, C, 0, 0));

        int[][] dp = new int[R][C];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(minPathSum2(grid, R, C, 0, 0, dp));
        System.out.println(minPathSum(grid));
    }
    // Recursive Code : TC - O(2^R+C) SC - O(R+C)
    public static int minPathSum1(int[][] grid, int R, int C, int r, int c) {
        if(r == R || c == C) return 300;
        if(r == R-1 && c == C-1) return grid[r][c];

        int down = minPathSum1(grid, R, C, r+1, c);
        int right = minPathSum1(grid, R, C, r, c+1);

        return grid[r][c] + Math.min(down, right);
    }
    // Recursive Code DP(Top - Down Approach -> Memoization) : TC - O(R*C) SC - O(R*C + stackSpace(R+C))
    public static int minPathSum2(int[][] grid, int R, int C, int r, int c, int[][] dp) {
        if(r == R || c == C) return 300;
        if(r == R-1 && c == C-1) return grid[r][c];

        if(dp[r][c] != -1) return dp[r][c];

        int down = minPathSum2(grid, R, C, r+1, c, dp);
        int right = minPathSum2(grid, R, C, r, c+1, dp);

        return dp[r][c] = grid[r][c] + Math.min(down, right);
    }
    // Iterative Code(Bottom - Up Approach - Tabulation) : TC - O(R*C) SC - O(C);
    public static int minPathSum(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int[] dp = new int[C];
        dp[0] = grid[0][0];

        for(int c = 1; c < C; c++){
            dp[c] = dp[c-1] + grid[0][c];
        }

        for(int r = 1; r < R; r++){
            dp[0] = dp[0] + grid[r][0];
            for (int c = 1; c < C; c++){
                dp[c] = Math.min(dp[c], dp[c-1]) + grid[r][c];
            }
        }
        return dp[C-1];
    }
}
