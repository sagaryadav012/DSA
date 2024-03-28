package DP.DpOnSubsequences;

import java.util.Arrays;

public class CoinChange2_LC518 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        int n = coins.length;
        System.out.println(change(amount, coins));
        System.out.println(change1(n-1, amount, coins));

        int[][] dp = new int[n][amount+1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(change2(n-1, amount, coins, dp));

    }

    // TC - O(2^n) SC - O(N)
    public static int change1(int index, int amount, int[] coins){
        if(index < 0) return 0;
        if(amount == 0) return 1;

        int dontTake = change1(index - 1, amount, coins);
        int take = 0;
        if(amount >= coins[index]){
            take = change1(index, amount - coins[index], coins);
        }
        return dontTake + take;
    }

    // TC - O(N * amount) SC - O(N * amount)
    public static int change2(int index, int amount, int[] coins, int[][] dp){
        if(index < 0) return 0;
        if(amount == 0) return 1;

        if(dp[index][amount] != -1) return dp[index][amount];

        int dontTake = change1(index - 1, amount, coins);
        int take = 0;
        if(amount >= coins[index]){
            take = change1(index, amount - coins[index], coins);
        }
        return dp[index][amount] = dontTake + take;
    }

    // TC - O(N * amount) SC - O(amount)
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin : coins){
            for(int sum = coin; sum <= amount; sum++){
                dp[sum] = dp[sum] + dp[sum - coin];
            }
        }
        return dp[amount];
    }
}
