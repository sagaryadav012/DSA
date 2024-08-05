package QueueAndStacks.MonotonicStack;

import java.util.Arrays;

public class MaxSubArrayMinProduct_LC1856 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(maxSumMinProduct(nums));
    }
    public static int maxSumMinProduct(int[] nums) { // TC - O(N) SC - O(N)
        int n = nums.length;
        int mod = 1000000007;
        int[] LM = leftMin(nums, n);
        int[] RM = rightMin(nums, n);

        System.out.println(Arrays.toString(LM));
        System.out.println(Arrays.toString(RM));

        long[] pSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pSum[i + 1] = pSum[i] + nums[i];
        }

        long maxMinProduct = 0;
        for (int i = 0; i < n; i++) {
            int leftMin = LM[i];
            int rightMin = RM[i];
            long sum = pSum[rightMin] - pSum[leftMin + 1];
            sum = sum * nums[i];
            maxMinProduct = Math.max(maxMinProduct, sum);
        }
        return (int) (maxMinProduct % mod);
    }
    public static int[] leftMin(int[] nums, int n){
        int[] LM = new int[n];
        LM[0] = -1;

        for(int i = 1; i < n; i++){
            int prevIndex = i-1;
            while(prevIndex >= 0 && nums[prevIndex] > nums[i]){
                prevIndex = LM[prevIndex];
            }
            LM[i] = prevIndex;
        }
        return LM;
    }
    public static int[] rightMin(int[] nums, int n){
        int[] RM = new int[n];
        RM[n-1] = n;

        for(int i = n-2; i >= 0; i--){
            int nextIndex = i+1;
            while(nextIndex < n && nums[nextIndex] >= nums[i]){
                nextIndex = RM[nextIndex];
            }
            RM[i] = nextIndex;
        }
        return RM;
    }
}
/*
Approach 1 : Carry forward technique -> find min and sum > min * sum -> take maxSum

Approach 2 :
-> Take sub array of an element act as min and sum of that sub array
 */