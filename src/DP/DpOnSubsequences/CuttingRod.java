package DP.DpOnSubsequences;

import java.util.Arrays;

public class CuttingRod {
    public static void main(String[] args) {
        int[] prices = {3, 5, 8, 9, 10, 17, 17, 20};
        int len = 8;
        System.out.println(maxPrice(prices, len));

        int[] dp = new int[len+1];
        Arrays.fill(dp, -1);
        System.out.println(maxPrice1(prices, len, dp));
        System.out.println(maxPrice2(prices, len));
    }
    public static int maxPrice(int[] prices, int len){ // TC - exponential
        if(len == 0) return 0;

        int max = 0;
        for(int i = 1; i <= len; i++){
            max = Math.max(max, maxPrice(prices, len - i) + prices[i-1]);
        }
        return max;
    }
    public static int maxPrice1(int[] prices, int len, int[] dp){ // TC - O(len *len) SC - O(len) + recursive stack
        if(len == 0) return 0;

        if(dp[len] != -1) return dp[len];

        int max = 0;
        for(int i = 1; i <= len; i++){
            max = Math.max(max, maxPrice(prices, len - i) + prices[i-1]);
        }
        return dp[len] = max;
    }
    public static int maxPrice2(int[] prices, int len){ // TC - O(len *len) SC - O(len)
        int[] dp = new int[len+1];

        for(int i = 1; i <= len; i++){
            int max = 0;
            for(int j = 1; j <= i; j++){
                max = Math.max(max, dp[i- j] + prices[j-1]);
            }
            dp[i] = max;
        }
        System.out.println(Arrays.toString(dp));
        return dp[len];
    }
}
/*
Question :
Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it.
Determine the maximum cost obtained by cutting the rod and selling its pieces.

-> Here we need to try out all possible combinations and check which one gives max profit.
   For example rod len N = 5 and Amount for cuts = {0, 1, 4, 2, 5, 6}

   Rod Cuts             Value Obtained
   5                    6
   1+4                  1+5 = 6
   2+3                  4+2 = 6
   2+2+1                4+4+1 = 6 -> Max Profit
   1+1+3                1+1+2 = 4
   1+1+1+1+1            1+1+1+1+1 = 5

   Here we get max profit 6 by cutting rod len 2,2,1

-> A rod can be cut at size min is 1 and max is rod len. So, cut a rod at some len and find maxProfit of remaining len.
   For example a rod length is 5 ->
   then maxProfit is max of (cost[1] + f(5-1), cost[2] + f(5-2), cost[3] + f(5-3), cost[4] + f(5-4), cost[5] + f(5-5))
   Use dp to store repetitive cals, so find maxProfit for each length of rod.






 */