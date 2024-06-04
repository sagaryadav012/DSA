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
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
/*
-> We have to Return the number of combinations that make up that amount.
-> For Example :
   Amount = 5, coins = {3,1,4}

   Possible combinations are :
   4+1, 1+4, 1+1+3, 1+3+1, 3+1+1, 1+1+1+1+1 --> Total no.of combinations are 5
-> One way to do that, generate all combinations, and check sum equal to amount -> TC - O(2^n * n)
-> Second way is by doing recursive call -> f(amount) = sum of ( f(amount - coin1) + f(amount - coin2) + f(amount - coin3) + ...)
-> But the problem is here, we have to find unique combination, for example 1+3+1, 1+1+3 and 3+1+1 gives
   sum 5, but all values are same, so we treated it as one combination.
-> When our requirement is to find all possible combination, the above approach is better. but when we have
   to unique combinations, then use take and don't take technique, By doing this we can ignore duplicate combinations.

 */