package DP.Stocks;

public class BestTimeToBuyAndSellStock4 {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(k, prices));
    }
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int index = n-1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
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
        return dp[0][1][k];
    }
}
