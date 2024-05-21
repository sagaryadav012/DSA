package LeetcodeMSC;

public class FindMaxSumOfNodeValues_LC3068 {
    public static void main(String[] args) {
        int[][] edges = {
                {0,2},
                {1,2},
                {4,2},
                {3,4}
        };
        int k = 6;
        int[] nums = {24,78,1,97,44};
        System.out.println(maximumValueSum(nums, k, edges));
//        System.out.println(24^6);
//        System.out.println(1^6);
//        System.out.println(78^6);
//        System.out.println(44^6);
//        System.out.println(7^6);
    }
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        int[] xorVal = new int[n];
        for(int i = 0; i < n; i++){
            xorVal[i] = nums[i] ^ k;
        }

        long maxSum = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            maxSum += Math.max(nums[i], xorVal[i]);
            if(nums[i] < xorVal[i]) count += 1;
        }
        if(count % 2 == 0) return maxSum;
        long minDiff = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long diff = Math.abs(nums[i] - xorVal[i]);
            minDiff = Math.min(diff, minDiff);
        }
        return maxSum - minDiff;
    }
}
