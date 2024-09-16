package DP.DpOnSubsequences;

import java.util.Arrays;

public class TargetSum_LC494 {
    public static void main(String[] args) {
        int[] nums = {1,0};
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        totalSum -= target;
        if(totalSum < 0 || totalSum % 2 != 0) return 0;

        int s2 = totalSum/2;

        return countWays(nums, s2);
    }
    public static int countWays(int[] nums, int subset){
        int n = nums.length;
        // when we try this with recursion, index goes upto -1 and tar goes upto 0, to handle these base case, take dp[n+1][tar+1]
        int[] prevRowDp = new int[subset+1];
        prevRowDp[0] = 1;

        for(int i = 1; i <= n; i++){
            int[] currRowDp = new int[subset + 1];
            currRowDp[0] = 1;
            for(int j = 0; j <= subset; j++){ // Make sure j starts from 0, we need to calculate how many ways to form 0, dry run [1,0], target = 1
                int dontTake = prevRowDp[j];
                if(nums[i-1] <= j){
                    int take = prevRowDp[j - nums[i-1]];
                    dontTake += take;
                }
                currRowDp[j] = dontTake;
            }
            prevRowDp = currRowDp;
        }
        System.out.println(Arrays.toString(prevRowDp));
        return prevRowDp[subset];
    }
}
/*
-> This problem is same as Striver DP - 18. No.of ways to form |s1 - s2| = D
-> Here we need to add + and - to nums so that total = diff.
-> Divide array into two subsets s1(+ve nums), s2(-ve nums) so that |s1 - s2| = target.

step 1 -> count sum of all nums.
step 2 -> remove target from totalSum and totalSum/2 means we can form two subsets, now if add target to any subset
          so that |s1 - s2| = target.
step 3 -> Now find how many ways to form s2 or s1 that gives ans.


Test Cases :
 nums = {7,7,7} target = 7
 nums = {1,0,0} target = 0
 nums = {7,9,3,8,0,2,4,8,3,9} target = 0


 for example nums = 1,2,3,1 target = 3
   ways -> 2+3  - 1+1  = 3
        -> 3+1+1 - 2 = 3
     total 2 ways.
   totalSum = 1+2+3+1 = 7
   s2 = (7-3)/2 = 4/2 = 2
   find occurrence of 2 means how many can we form sum 2 using given values in nums

          0   1   2
      0   1   0   0
  1   1   1   1   0
  2   2   1   1   1
  3   3   1   1   1
  1   4   1   2   2

  dp[r-1][c-1 ] gives occurrence of sum 2(subSet2)

 -> if we observe we have to find s1 - s2 = target here s2 = 2 that means s1 = 5 then only we get target as 3
 -> if you check occurrence of s1 is same as the occurrence of s2.
 -> 5 - 2 = 3 -> ways = occurrence of (5 or 2) using given nums of values

 edge cases s2 = (totalSum - target)/2
 -> totalSum can be 0 and target can be > 0 in that case ans would be 0;
 -> s2 can be odd suppose totalSum = 55 and target is 0 in that case we can't find ans, ans would be 1;
 -> Sum will be 0 to 1000 so we have to count 0 occurrence also
 -> ex : 1,0,0 and target is 1
 ways
     1   0   0
     +   -   -
     +   +   -
     +   -   +
     +   +   +
 total 4 ways
 but if we take sum 0 as 1 always it gives ans 1, so count occurrence of 0 also


 */
