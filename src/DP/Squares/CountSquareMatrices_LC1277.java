package DP.Squares;

import java.util.Arrays;

public class CountSquareMatrices_LC1277 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println(countSquares(matrix));
    }
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        int totalSquareMatrices = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || matrix[i][j] == 0){
                    dp[i][j] = matrix[i][j];
                    totalSquareMatrices += dp[i][j];
                    continue;
                }
                // Why we have to +1 to it? matrix[i][j] itself forms 1 sized matrix.
                dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                totalSquareMatrices += dp[i][j];
            }
        }

        for(int[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }

        return totalSquareMatrices;
    }
}
/*
-> We have to count no.of square matrices.
-> EX : 1   0   1
        1   1   0
        1   1   0
-> Here min is 1 sized matrix, max is n size matrix. We have to find all.
-> Assume each cell is bottom right corner of n sized matrix(n could be 1,2,3..n).
-> If cell(r,c) is bottom right corner then check above cells[(r-1,c-1) (r-1,c) (r,c-1)] are contributed to form square.
-> The cells at r == 0 || c == 0 are don't have up cells so keep them as it is.
-> Iterate from r=1,c=1 till r=n-1,c=m-1 check are they form 2 or 3 or so on, sized matrices.

 */
