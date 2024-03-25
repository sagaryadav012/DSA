package DP.DpOnSubsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSum_LC416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,9};
        System.out.println(canPartition(nums));
        System.out.println(equalSum2(nums));
        System.out.println(equalSum3(nums));
    }

    // Recursive Code : TC - O(2^N) SC - O(N)
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;


        int[][] dp = new int[n+1][sum+1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }

        sum = sum/2;

//        return equalSum(sum, n-1, nums);
        return equalSum1(sum, n-1, nums, dp);
    }
    public static boolean equalSum(int sum, int index, int[] nums){ // TC - O(2^n) SC - O(n)
        if(sum == 0) return true;
        if(index < 0) return false;

        boolean dontTake = equalSum(sum, index - 1, nums);
        if(nums[index] <= sum){
            boolean take = equalSum(sum - nums[index], index - 1, nums);
            dontTake |= take;
        }
        return dontTake;
    }
    public static boolean equalSum1(int sum, int index, int[] nums, int[][] dp){ // TC - O(N*sum) SC - O(N*sum + recursive stack space)
        if(sum == 0) return true;
        if(index < 0) return false;

        if(dp[index][sum] != -1) return dp[index][sum] == 1;

        boolean dontTake = equalSum1(sum, index - 1, nums, dp);
        if(nums[index] <= sum){
            boolean take = equalSum1(sum - nums[index], index - 1, nums, dp);
            dontTake |= take;
        }
        dp[index][sum] = dontTake ? 1 : 0;
        return dontTake;
    }
    public static boolean equalSum2(int[] nums){ // TC - O(N*sum) SC - O(N*sum)
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;
        int[][] dp = new int[n+1][sum+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                int dontTake = dp[i-1][j];
                if(nums[i-1] <= j){
                    int take = dp[i-1][j - nums[i-1]];
                    dontTake |= take;
                }
                dp[i][j] = dontTake;
            }
        }
        return dp[n][sum] == 1;
    }
    public static boolean equalSum3(int[] nums){ // TC - O(N*sum) SC - O(SUM)
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;

        int[] prevDp = new int[sum+1];
        prevDp[0] = 1;

        for(int i = 1; i <= n; i++){
            int[] currDp = new int[sum+1];
            currDp[0] = 1;
            for(int j = 1; j <= sum; j++){
                int dontTake = prevDp[j];
                if(nums[i-1] <= j){
                    int take = prevDp[j - nums[i-1]];
                    dontTake |= take;
                }
                currDp[j] = dontTake;
            }
            prevDp = currDp;
        }
        return prevDp[sum] == 1;
    }
}
/*
Approach 1 : Recursion
-> Explore all_ways. TC - O(2^n) SC - O(n)
-> Each index has two options take and don't take, so TC - 2^n
-> SC - O(N) for call stack space.

Approach 2 : Memoization
-> store recursive calls inorder to fetch data, when encounter same call again.
-> TC - O(n*sum) for n*sum dp states
-> SC - O(n*sum) to store recursive call result

Approach 3 : Tabulation
-> When sum == 0 means we can form sum with nums, it means true.
-> index goes from n-1 to -1 and sum goes from sum to 0. so take dp states as n+1 and sum+1
-> TC - O(N*Sum) SC - O(N*Sum) : space can be optimised to O(sum) since we are working with index - 1.

 */