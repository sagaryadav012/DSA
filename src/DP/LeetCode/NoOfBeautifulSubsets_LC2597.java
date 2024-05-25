package DP.LeetCode;

public class NoOfBeautifulSubsets_LC2597 {
    public static void main(String[] args) {
        int[] nums = {10,4,5,7,2,1};
        int k = 3;
        System.out.println(beautifulSubsets(nums, k));
    }
    public static int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        for(int num : nums){
            max = Math.max(num, max);
        }
        int[][] dp = new int[max+2][n+1];
        System.out.println(subsetCount1(-1, nums.length - 1, nums, k, dp));
        return subsetCount(-1, nums.length - 1, nums, k);
    }
    public static int subsetCount(int prev, int index, int[] nums, int k){
        if(index == -1 && prev == -1) return 0;
        if(index == -1) return 1;
        int count = subsetCount(prev, index - 1, nums, k);
        if(prev == -1 || Math.abs(nums[index] - prev) != k){
            count += subsetCount(nums[index], index - 1, nums, k);
        }
        return count;
    }
    public static int subsetCount1(int prev, int index, int[] nums, int k, int[][] dp){
        if(index == -1 && prev == -1) return 0;
        if(index == -1) return 1;

        if(dp[prev+1][index+1] != 0) return dp[prev+1][index+1];

        int count = subsetCount1(prev, index - 1, nums, k, dp);
        if(prev == -1 || Math.abs(nums[index] - prev) != k){
            count += subsetCount1(nums[index], index - 1, nums, k,dp);
        }
        return dp[prev+1][index+1] = count;
    }
}
