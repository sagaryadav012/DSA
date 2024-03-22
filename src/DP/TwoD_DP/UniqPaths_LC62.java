package DP.TwoD_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqPaths_LC62 {
    public static void main(String[] args) {
        UniqPaths_LC62 obj = new UniqPaths_LC62();
        int m = 3;
        int n = 7;
        System.out.println(obj.paths1(m-1, n-1));

        int[][] cache = new int[m][n];
        for(int[] ar : cache){
            Arrays.fill(ar, -1);
        }
        System.out.println(obj.paths2(cache, m-1, n-1));

        System.out.println(obj.paths3(m, n, cache));
        System.out.println(obj.paths4(m, n));
        System.out.println(obj.uniquePaths(m, n));
    }

    // Recursive Code : TC - O(2^n) SC - O(R+C)
    public int paths1(int row, int col){
        if(row < 0 || col < 0) return 0;
        if(row == 0 && col == 0) return 1;
        int left = paths1(row, col - 1);
        int up = paths1(row - 1, col);
        return up + left;
    }
    // Recursive Code DP(Top - Down Approach -> Memoization) : TC - O(R*C) SC - O(R*C + stackSpace(R+C))
    public int paths2(int[][] cache, int row, int col){
        if(row < 0 || col < 0) return 0;
        if(row == 0 && col == 0) return 1;
        if(cache[row][col] != -1) return cache[row][col];
        int left = paths2(cache, row, col - 1);
        int up = paths2(cache, row - 1, col);
        cache[row][col] = left + up;
        return left + up;
    }

    // Iterative Code(Bottom - Up Approach : Tabulation) : TC - O(R*C) SC - O(R*C);
    public int paths3(int m, int n, int[][] cache){
        int R = m;
        int C = n;

        for(int r = 0; r < R; r++) cache[r][0] = 1;
        for(int c = 0; c < C; c++) cache[0][c] = 1;

        for(int r = 1; r < R; r++){
            for(int c = 1; c < C; c++){
                int left = cache[r][c-1];
                int up = cache[r-1][c];
                cache[r][c] = left + up;
            }
        }
        return cache[R-1][C-1];
    }
    // Iterative Code(Bottom - Up Approach - Tabulation) : TC - O(R*C) SC - O(C + C);
    public int paths4(int m, int n){
        int R = m;
        int C = n;
        int[] preRow = new int[C];
        Arrays.fill(preRow, 1);
        int[] curRow;
        for(int r = 1; r < R; r++){
            curRow = new int[C];
            curRow[0] = 1;
            for(int c = 1; c < C; c++){
                curRow[c] = curRow[c-1] + preRow[c];
            }
            preRow = curRow;
        }
        return preRow[C-1];
    }
    public int uniquePaths(int m, int n) { // Very Optimised TC - (R*C) SC -O(C)
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                dp[c] += dp[c-1];
            }
        }
        return dp[n-1];
    }
}
