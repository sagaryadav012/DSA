package Arrays.LeetCodeMSC;

import java.util.Arrays;

public class FirstMissingPositive_LC41 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
        System.out.println(Arrays.toString(nums));
        System.out.println(firstMissingPositive1(nums));
    }
    public static int firstMissingPositive(int[] nums) { // TC - O(N) SC - O(1)
        int n = nums.length;
        int i = 0;
        while(i < n){
            if(nums[i] != i+1 && nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]){
                int val = nums[i];
                nums[i] = nums[val-1];
                nums[val-1] = val;
            }
            else i++;
        }
        for(int j = 0; j < n; j++){
            if(nums[j] != j+1) return j+1;
        }
        return n+1;
    }
    public static int firstMissingPositive1(int[] nums) { // TC - O(N) SC - O(1)
        int n = nums.length;
        boolean[] present = new boolean[n+1];

        for(int val : nums){
            if(val <= n && val >= 0) present[val] = true;
        }

        for(int i = 1; i <= n; i++){
            if(!present[i]) return i;
        }

        return n+1;
    }
}
/*
Approach 1 :
-> Place all values, according to their indexes, like if index i = 0, place here 1. So that it's easy to track
   which first positive integer is missing.
-> nums[i] can be Integer.MIN_VALUE <= nums[i] <= INTEGER.MAX_VALUE so nums[i] should be in the range of 0 < nums[i] <= n
-> Why not 0? because we swap nums[i] with nums[nums[i]-1], if nums[i] = 0 it gives IOO Exception.
-> Swap until if condition fails, then only it moves to next index.
-> Once swapping done, check if(nums[i] != i+1) means we sorted all nums and checking which one is missing here.
-> If anything miss we return it else means all are present so return n+1;
 */