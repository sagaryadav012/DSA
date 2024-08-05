package DP.DpOnSubsequences;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    public static void main(String[] args) {
        int[] nums = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        int tar = 31;
        System.out.println(findWays(nums, tar));
        System.out.println(ways3(nums, tar));
    }
    public static int findWays(int[] nums, int tar) {
        int n = nums.length;

        int[][] dp = new int[n][tar+1];
        for(int[] ar : dp){
            Arrays.fill(ar , -1);
        }
        return  ways2(n-1, tar, nums, dp);
    }

    // TC - O(2^n) SC - O(N)
    public static int ways1(int index, int tar, int[] nums){
        if(tar == 0) return 1;
        if(index < 0) return 0;

        int dontTake = ways1(index - 1, tar, nums);
        if(nums[index] <= tar){
            int take = ways1(index - 1, tar - nums[index], nums);
            dontTake += take;
        }
        return dontTake;
    }
    // TC - O(N * Tar) SC - O(N * Tar) + stack space
    public static int ways2(int index, int tar, int[] nums, int[][] dp){
        if(tar == 0) return 1;
        if(index < 0) return 0;

        if(dp[index][tar] != -1) return dp[index][tar];

        int dontTake = ways2(index - 1, tar, nums, dp);
        if(nums[index] <= tar){
            int take = ways2(index - 1, tar - nums[index], nums, dp);
            dontTake += take;
        }
        return dp[index][tar] = dontTake;
    }

    // TC - O(N * Tar) SC - O(N * Tar). SC can be optimised since we need only prev row to cal cur row values
    public static int ways3(int[] nums, int tar){
        int n = nums.length;
        // when we try this with recursion, index goes upto -1 and tar goes upto 0, to handle these base case, take dp[n+1][tar+1]
        int[][] dp = new int[n+1][tar+1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1; // base case when sum == 0, that means sum exists so return 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= tar; j++){
                int dontTake = dp[i-1][j];
                if(nums[i-1] <= j){
                    int take = dp[i-1][j - nums[i-1]];
                    dontTake += take;
                }
                dp[i][j] = dontTake;
            }
        }
        return dp[n][tar];
    }
}
/*
-> This question from coding ninja platform, equivalent question in LC is 698 but bit hard than this.
-> This is same as subset sum equals to target. but there we return true if sum exists, here we have to count
   no.of subsets that sum equals to target.
-> So write base case as if target == 0 return 1 else 0 when indexes are exhausted.
 */
