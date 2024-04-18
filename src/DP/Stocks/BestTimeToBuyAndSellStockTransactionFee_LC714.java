package DP.Stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockTransactionFee_LC714 {

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
        System.out.println(maxProfit1(prices, fee));
    }
    public static int maxProfit(int[] prices, int fee){
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }
    public static int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                if(j == 1){
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                }
                else{
                    // when make sell, subtract fee from profit
                    dp[i][j] = Math.max(prices[i] - fee + dp[i + 1][1], dp[i + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
