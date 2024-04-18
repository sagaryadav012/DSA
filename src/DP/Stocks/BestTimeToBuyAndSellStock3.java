package DP.Stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int n = prices.length;

        System.out.println(maxProfit(0, 1, 2, prices));

        int[][][] dp = new int[n][2][3];
        for(int[][] ar : dp){
            for(int[] iar : ar){
                Arrays.fill(iar, -1);
            }
        }
        System.out.println(maxProfit1(0, 1, 2, prices, dp));
        System.out.println(maxProfit3(prices));
    }

    // Recursion :
    public static int maxProfit(int index, int buy, int cap, int[] prices) {
        if(cap == 0) return 0;
        if(index == prices.length) return 0;

        if(buy == 1){
            // buy : if buy at this price then move to next price and make buy = 0 means we have to sell only now.
            // don't buy : if don't buy move to next price, keep buy = 1 since we didn't buy here.
            return Math.max(-prices[index] + maxProfit(index + 1, 0, cap, prices),
                    maxProfit(index + 1, 1, cap, prices));
        }

        // sell : if we sell, take price and move to next price, make buy = 1. we sold here so one transaction completed so cap - 1.
        // don't sell : if we don't sell here, keep buy = 0, move to next price, keep cap as same.
        return Math.max(prices[index] + maxProfit(index + 1, 1, cap - 1, prices),
                maxProfit(index + 1, 0, cap, prices));
    }

    public static int maxProfit1(int index, int buy, int cap, int[] prices, int[][][] dp) {
        if(cap == 0) return 0;
        if(index == prices.length) return 0;

        if(dp[index][buy][cap] != -1) return dp[index][buy][cap];

        if(buy == 1){
            return dp[index][buy][cap] = Math.max(-prices[index] + maxProfit1(index + 1, 0, cap, prices, dp),
                                            maxProfit1(index + 1, 1, cap, prices, dp));
        }
        return dp[index][buy][cap] = Math.max(prices[index] + maxProfit1(index + 1, 1, cap - 1, prices, dp),
                                        maxProfit1(index + 1, 0, cap, prices, dp));
    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n+1][2][3];

        // Base cases
        // If cap == 0 return 0
        // Since default is 0, no need to write base case
//        for(int index = 0; index <= n; index++){
//            for(int buy = 0; buy <= 1; buy++){
//                dp[index][buy][0] = 0;
//            }
//        }

        // if(index == n) return 0
//        for(int buy = 0; buy <= 1; buy++){
//            for(int cap = 0; cap < 3; cap++){
//                dp[n][buy][cap] = 0;
//            }
//        }

        // Write changing parameters
        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){ // cap = 0 is base case
                    if(buy == 1){
                        dp[index][buy][cap] = Math.max(-prices[index] + dp[index+1][0][cap],
                                                       dp[index+1][1][cap]);
                    }
                    else{
                        dp[index][buy][cap] = Math.max(prices[index] + dp[index+1][1][cap-1],
                                dp[index+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
