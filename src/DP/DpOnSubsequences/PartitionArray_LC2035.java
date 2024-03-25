package DP.DpOnSubsequences;

public class PartitionArray_LC2035 {
    public static void main(String[] args) {
        int[] nums = {76,8,45,20,74,84,28,1};
        System.out.println(minimumDifference(nums));
    }
    public static int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        int[] dp = equalSum(sum/2, nums, n);
        int minDiff = sum;

        for(int i = 0; i < dp.length; i++){
            if(dp[i] == 0) continue;
            int s2 = sum - i;
            int diff = Math.abs(i - s2);
            minDiff = Math.min(diff, minDiff);
        }
        return minDiff;
    }
    public static int[] equalSum(int sum, int[] nums, int n){ // TC - O(N*sum) SC - O(SUM)
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
        return prevDp;
    }


}
/*
-> Our aim is to find min diff between two subsets.
-> So partition array into subsets so that diff between two subset is min(as min as possible)
-> |s1 - s2| = min. if we know sums of subset1 and subset2, it is easy to find diff and take min of those.
-> Any of subset sum can be range from 0 to (sum of all nums)/2.
-> So first find s1 sums, if know s1 sums we can find s2 sums(totalSum  - s1 sum)
-> Observe that subset equals to target problem, dp of last row of last index can tell that whether we can form target or not.
-> Same like find dp row of s1(sum/2).

Ex : nums {3,2,7}. TotalSum(TS) = 12
    s1 = 12/2 = 6.

                 0       1       2       3       4       5       6
can form :       T       F       T       T       F       T       F   : All true nums are possible sums of s1. so ignore false nums means that we can form su with given nums.
s2 = TS - s1 =   12              10      9               7
diff = |s1-s2| = 12              8       6               2
min of all diff is 2. so ans is 2.

TC : O(N * HALF_SUM(for find s1) + HALF_SUM(for find s2) + HALF_SUM(for diff)) SC - O(SUM)
The above approach will not work, if nums have -ve values.
And LC2035 asked to divide array in equal length and find min difference, not about equal sum partition.
 */