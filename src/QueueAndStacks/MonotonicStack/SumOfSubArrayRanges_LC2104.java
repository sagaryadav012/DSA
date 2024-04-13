package QueueAndStacks.MonotonicStack;

import java.util.Arrays;

public class SumOfSubArrayRanges_LC2104 {
    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};
        System.out.println(subArrayRanges1(nums));
        System.out.println(subArrayRanges2(nums));
    }
    public static long subArrayRanges1(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for(int i = 0; i < n; i++){
            int min = nums[i], max = nums[i];
            for(int j = i; j < n; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                totalSum += max - min;
            }
        }
        return totalSum;
    }
    public static long subArrayRanges2(int[] nums) {
        int n = nums.length;

        // Find LeftNearestSmaller
        int[] LS = new int[n];
        LS[0] = -1;

        for(int i = 1; i < n; i++){
            int idx = i-1;
            while(idx >= 0 && nums[idx] >= nums[i]){
                idx = LS[idx];
            }
            LS[i] = idx;
        }

        // Find RightNearestSmaller
        int[] RS = new int[n];
        RS[n-1] = n;

        for(int i = n-2; i >= 0; i--){
            int idx = i+1;
            while(idx < n && nums[idx] > nums[i]){
                idx = RS[idx];
            }
            RS[i] = idx;
        }

        // Find LeftNearestGreater
        int[] LG = new int[n];
        LG[0] = -1;

        for(int i = 1; i < n; i++){
            int idx = i-1;
            while(idx >= 0 && nums[idx] <= nums[i]){
                idx = LG[idx];
            }
            LG[i] = idx;
        }

        // Find RightNearestGreater
        int[] RG = new int[n];
        RG[n-1] = n;

        for(int i = n-2; i >= 0; i--){
            int idx = i+1;
            while(idx < n && nums[idx] < nums[i]){
                idx = RG[idx];
            }
            RG[i] = idx;
        }

        System.out.println(Arrays.toString(LS));
        System.out.println(Arrays.toString(RS));
        System.out.println(Arrays.toString(LG));
        System.out.println(Arrays.toString(RG));

        long totalSum = 0;
        for(int i = 0; i < n; i++){
            int minOccurrenceCount = (i - LS[i]) * (RS[i] - i);
            int maxOccurrenceCount = (i - LG[i]) * (RG[i] - i);
            long sum = ((long) maxOccurrenceCount * nums[i]) - ((long) minOccurrenceCount * nums[i]);
            totalSum += sum;
        }
        return totalSum;
    }
}
/*
-> Why we have taken <, <= or >, >= ? Take an example 4,1,4.
    4 at 0th index acts as max in [4] [4,1] [4,1,4]
    4 at 2nd index acts as max in [4] [1,4] [4,1,4]
    Here repeated twice, it gives incorrect answer. So take < in one case and <= in 2nd case.
    For example in LS we took >= and in RS we took > to avoid duplications. We can take in LS as > and RS as >= that also works.

 */