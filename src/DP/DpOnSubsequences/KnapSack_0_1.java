package DP.DpOnSubsequences;

import java.util.Arrays;

public class KnapSack_0_1 {
    public static void main(String[] args) {
        int n = 4;
        int w = 7;
        int[] happiness = {4,1,5,7};
        int[] weights = {3,2,4,5};

        System.out.println(maxHappiness(n - 1, w, happiness, weights));
        int[][] dp = new int[n][w+1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(maxHappiness1(n-1, w, happiness, weights, dp));
        System.out.println(maxHappiness2(n, w, happiness, weights));
    }

    // TC - O(2^N) SC - O(N)
    public static int maxHappiness(int index, int weight, int[] happiness, int[] weights){
        if(index < 0) return 0;

        int dontTake = maxHappiness(index - 1, weight, happiness, weights);
        int take = 0;
        if(weight >= weights[index]){
            take = happiness[index] + maxHappiness(index - 1, weight - weights[index], happiness, weights);
        }
        return Math.max(dontTake, take);
    }
    // TC - O(N * weight) SC - O(N * weight) + stack space(N)
    public static int maxHappiness1(int index, int weight, int[] happiness, int[] weights, int[][] dp){
        if(index < 0) return 0;

        if(dp[index][weight] != -1) return dp[index][weight];

        int dontTake = maxHappiness1(index - 1, weight, happiness, weights, dp);
        int take = 0;
        if(weight >= weights[index]){
            take = happiness[index] + maxHappiness1(index - 1, weight - weights[index], happiness, weights, dp);
        }
        return dp[index][weight] = Math.max(dontTake, take);
    }

    // TC - O(N * weight) SC - O(N * weight)
    public static int maxHappiness2(int n, int weight, int[] happiness, int[] weights){
        int[][] dp = new int[n+1][weight+1];

        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= weight; j++){
//                int dontTake = dp[i - 1][j];
//                int take = 0;
//                if(j >= weights[i-1]){
//                    take += happiness[i-1] + dp[i-1][j - weights[i-1]];
//                }
//                dp[i][j] = Math.max(dontTake, take);
//            }
            for(int j = weights[i-1]; j <= weight; j++){
                int dontTake = dp[i - 1][j];
                int take = happiness[i-1] + dp[i-1][j - weights[i-1]];
                dp[i][j] = Math.max(dontTake, take);
            }
        }
        for(int[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }
        return dp[n][weight];
    }
}
/*
Question : Given N toys with their happiness and weight. Find max total happiness that can be kept in a bag with
           capacity = W
           N = 4, W = 7

           Happiness :  4   1   5   7
           weight    :  3   2   4   5

           Can choose weight only once.


Approach 1 : Greedy : Choose max happiness
-> if I choose max happiness first
        Happiness       weight
        7               7-5 = 2
        1               2-2 = 0
        total happiness 8

       But I can choose index 0 and 2 of weights so that can get max happiness 9.

       So Greedy fails here.

Approach 2 : Try out all possibilities.
-> When try out all possibilities, we get recursion in our mind.
-> so do recursion, if sub problems get repeats again and again, use dp to store.

unbounded knapsack is also same we can choose same weight again and again
dontTake = func(index-1, weight)
take = func(index, weight - weights[index])

 */