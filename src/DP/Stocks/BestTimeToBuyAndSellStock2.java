package DP.Stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int n = prices.length;
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(0, true, prices));

        int[][] dp = new int[n][2];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(maxProfit3(0, 1, prices, dp));
        System.out.println(maxProfit4(prices));
    }
    public static int maxProfit1(int[] prices) { // TC - O(N) SC - O(1)
        int profit = 0;
        int buy_price = prices[0];
        for(int price : prices){
            if(price < buy_price){
                buy_price = price;
                continue;
            }
            profit += price - buy_price;
            buy_price = price;
        }
        return profit;
    }
    public static int maxProfit2(int index, boolean buy, int[] prices) { // TC - O(2^N) SC - O(N)
        if(index == prices.length) return 0;

        int profit = 0;
        if(buy){
            // for example, we have some investment amount when we buy we have to minus that amount from totalAmount
            // buy case : so totalAmount - prices[index], once buy it make it false it means we can't buy until it sells.
            // don't buy case : if don't buy move to next price, keep buy = true.
            // Take max of both

            profit = Math.max(-prices[index] + maxProfit2(index + 1, false, prices),
                    maxProfit2(index + 1, true, prices));
        }
        else{
            // Sell case : if we sell add price so +prices[index] and move to next price make buy = true so next we have to buy only.
            // Don't sell case : if don't sell, move to next price and keep buy = false since we haven't sold yet.
            // Take max of both
            profit = Math.max(prices[index] + maxProfit2(index + 1, true, prices),
                    maxProfit2(index + 1, false, prices));
        }
        return profit;
    }

    // Memoization : TC - O(N * 2) SC - O(N*2) + stackSpace(N)
    public static int maxProfit3(int index, int buy, int[] prices, int[][] dp) {
        if(index == prices.length) return 0;

        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[index] + maxProfit3(index + 1, 0, prices, dp),
                     maxProfit3(index + 1, 1, prices, dp));
        }
        else{
            profit = Math.max(prices[index] + maxProfit3(index + 1, 1, prices, dp),
                     maxProfit3(index + 1, 0, prices, dp));
        }
        return dp[index][buy] = profit;
    }
    // Tabulation : TC - O(N * 2) SC - O(N*2); // can optimise space since we need next row to cal curRow
    public static int maxProfit4(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                if(j == 1){
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                }
                else{
                    dp[i][j] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
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
Problem statement : On each day, you may decide to buy and/or sell the stock.
                    You can only hold at most one share of the stock at any time.
                    However, you can buy it then immediately sell it on the same day.
-> We can make multiple transactions but can hold at most one stock at any time means once buy stock, sell it before next buy.

Approach 1 :
-> Take two pointer(i,j). Here i is the buy price and j is sell price. in order to get profit we have to sell at higher price i.e. greater than buy price.
-> So keep i pointer at one price and iterate over prices using j pointer and check which one is greater than buy_price and take max profit.
-> But this approach will fail.
   Example 7,1,5,3,6,4
   We buy at 1 and sell at 6 and got profit 5
   Now i pointer at 3 and j pointer at 6. Can we make this transaction?
   No because we can hold at most one share of stock at any time.
   We buy at 1, again we buy at 3 before it sells. so this approach will not work.

Approach 2(Greedy) :
-> We buy at some price and will sell at price that is greater than buy price in order to get profit right?
-> We can make multiple transactions, but we can hold at most one share stock only.
-> For example we buy at price 5, price raised to 10 if we sell here we get 5 profit,
   if it raised to 15 and sell at 15 we would have get 10 profit. So when to sell?
-> We do like this buy at 5, price raised to 10, we sell at 10, got profit 5.
   And again buy at 10 if it raises to 15, we sell at 15 and got profit 5. total profit 10.
   Or if price falls to 5 then we move our buy_price pointer to here, so if it raises again we will buy there.

   5 ----> 10 ----> 15 = 5 + 5 = 10 profit
   5 ----> 10 -- 4 ----> 14 = 5 + 10 = 15 profit

-> TC - O(N) SC - O(1)

Approach 3(Recursion) :
-> We have to try all possibilities, when it's try out all possibilities we have only one option recursion.
-> At every price we can buy or sell. buy or sell depends on previous state like if buy before, now we have one option i.e. sell
   And we have two options here we can sell or not sell. It looks like same subsequence problem : take and don't take.
-> We need two things to track price and buy or sell state.
-> For example function(index, buy) this states that profit till index and we can buy here.
-> Explore recursion, we will see sub problems will be overlapped so use memoization technique later come up with tabulation.

->

 */
