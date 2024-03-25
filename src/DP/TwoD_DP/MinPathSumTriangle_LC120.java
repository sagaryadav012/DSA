package DP.TwoD_DP;

import java.util.Arrays;
import java.util.List;

public class MinPathSumTriangle_LC120 {
    public static void main(String[] args) {
        int[][] triangle = {
                {8},
                {7, 7},
                {4, 4, 9},
                {1, 5, 5, 5},
                {8, 2, 9, 8, 2},
                {0, 7, 4, 8, 5, 8},
                {3, 0, 6, 2, 2, 5, 2},
                {2, 7, 1, 5, 2, 1, 1, 0}
        };
        int R = triangle.length;
        System.out.println(minimumTotal(triangle, R, 0, 0));

        int[][] dp = new int[R][triangle[R-1].length];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(minimumTotal1(triangle, R, 0, 0, dp));
        System.out.println(minimumTotal2(triangle));
    }
    // Recursive Code : TC - O(2^R+C) SC - O(R+C)
    public static int minimumTotal(int[][] triangle, int R, int r, int c) {
        if(r == R-1) return triangle[r][c];

        int down = minimumTotal(triangle, R, r+1, c);
        int right = minimumTotal(triangle, R, r+1, c+1);

        return Math.min(right, down) + triangle[r][c];
    }
    // Recursive Code DP(Top - Down Approach -> Memoization) : TC - O(R*C) SC - O(R*C + stackSpace(R+C))
    public static int minimumTotal1(int[][] triangle, int R, int r, int c, int[][] dp) {
        if(r == R-1) return triangle[r][c];

        if(dp[r][c] != -1) return dp[r][c];

        int down = minimumTotal1(triangle, R, r+1, c, dp);
        int right = minimumTotal1(triangle, R, r+1, c+1, dp);

        return dp[r][c] = Math.min(right, down) + triangle[r][c];
    }
    // Iterative Code(Bottom - Up Approach - Tabulation) : TC - O(R*C) SC - O(C);
    public static int minimumTotal2(int[][] triangle){
        int R = triangle.length;
        int C = triangle[R-1].length;

        int[] dp = Arrays.copyOf(triangle[R-1], C);
        // System.out.println(Arrays.toString(dp));
        for(int r = R-2; r >= 0; r--){
            for(int c = 0; c < triangle[r].length; c++){
                dp[c] = triangle[r][c] + Math.min(dp[c], dp[c+1]);
            }
        }
        return dp[0];
    }
}
