package DP.Stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCoolDown_LC309 {
    public static void main(String[] args) {
        int[] prices = {4,9,0,5,10};
        int n = prices.length;

        System.out.println(maxProfit2(0, true, prices));

        int[][] dp = new int[n][2];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(maxProfit3(0, 1, prices, dp));
        System.out.println(maxProfit4(prices));
    }
    public static int maxProfit2(int index, boolean buy, int[] prices) { // TC - O(2^N) SC - O(N)
        if(index >= prices.length) return 0; // since when did sell move to i+2 index

        int profit = 0;
        if(buy){
            profit = Math.max(-prices[index] + maxProfit2(index + 1, false, prices),
                    maxProfit2(index + 1, true, prices));
        }
        else{
            profit = Math.max(prices[index] + maxProfit2(index + 2, true, prices),
                    maxProfit2(index + 1, false, prices));
        }
        return profit;
    }

    // Memoization : TC - O(N * 2) SC - O(N*2) + stackSpace(N)
    public static int maxProfit3(int index, int buy, int[] prices, int[][] dp) {
        if(index >= prices.length) return 0;

        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[index] + maxProfit3(index + 1, 0, prices, dp),
                    maxProfit3(index + 1, 1, prices, dp));
        }
        else{
            profit = Math.max(prices[index] + maxProfit3(index + 2, 1, prices, dp),
                    maxProfit3(index + 1, 0, prices, dp));
        }
        return dp[index][buy] = profit;
    }

    // Tabulation : TC - O(N * 2) SC - O(N*2); // can optimise space since we need next row to cal curRow
    public static int maxProfit4(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                if(j == 1){
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                }
                else{
                    dp[i][j] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
                }
            }
        }

        for(int[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }
        return dp[0][1];
    }
}

/*

This question is same Best time to buy and sell stock 2, but slight variation is when we sell, we can't buy
next day as leave one day for cool down period. when we sell stock move to i+2 index.

 */

