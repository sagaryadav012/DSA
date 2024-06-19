package Arrays.Medium;

import java.util.Arrays;

public class MaxSubArray_LC53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(Arrays.toString(printSubArray(nums)));
    }
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int sum = nums[0];
        for(int i = 1; i < n; i++){
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
    public static int[] printSubArray(int[] nums){
        int n = nums.length;
        int maxSum = nums[0];
        int sum = nums[0];
        int start = 0, s = 0, end = 0;
        for(int i = 1; i < n; i++){
            if(sum < 0){
                sum = 0;
                s = i;
            }
            sum += nums[i];
            if(maxSum < sum){
                maxSum = sum;
                end = i;
                start = s;
            }
        }

        int[] subArray = new int[end - start + 1];
        System.out.println(start+" "+ end);
        int index = 0;
        while(start <= end){
            subArray[index++] = nums[start++];
        }

        return subArray;
    }
}
