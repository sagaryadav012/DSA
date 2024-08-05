package Arrays.LeetCodeMSC;

public class MinSwapsToGroupAll_LC2134 {
    public static void main(String[] args) {

    }
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int oneCount = 0;
        for(int num : nums){
            oneCount += num;
        }

        int window = oneCount;
        oneCount = 0;
        int minSwaps = Integer.MAX_VALUE;
        for(int i = 0; i < window; i++){
            oneCount += nums[i];
        }
        minSwaps = Math.min(minSwaps, window - oneCount);
        int s = 0, e = window;
        while(s < n){
            oneCount = oneCount - nums[s] + nums[e%n];
            minSwaps = Math.min(minSwaps, window - oneCount);
            s++; e++;
        }
        return minSwaps;
    }
}
/*
-> When e reaches end of array, then that pointer should move to start index, Since it is circular.
-> Here window size is no.of ones in array. so that easily find group.
 */