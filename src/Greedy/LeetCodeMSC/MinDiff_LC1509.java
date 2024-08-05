package Greedy.LeetCodeMSC;

import java.util.Arrays;

public class MinDiff_LC1509 {
    public static void main(String[] args) {

    }
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n < 4) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i++){
            minDiff = Math.min(minDiff, nums[n-4+i] - nums[i]);
        }

        return minDiff;
    }
}
/*
Test Cases :
[0,1,1,4,6,6,6] -> Change 3 numbers : 4,4,4,4,6,6,6
[3,5,6,6,9,9] -> 5,5,6,6,6,6
[3,3,5,6,9] -> 5,5,5,6,6
[3,3,3,5,6] -> 5,5,5,5,6

There are only four cases
-> Change 3 smaller
-> Change 3 bigger
-> Change one smaller and 2 bigger
-> change 2 bigger and one smaller
 */