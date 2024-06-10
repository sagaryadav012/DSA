package Greedy.Hard;

import java.util.Arrays;

public class JumpGame2_LC45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums){
        int n = nums.length;
        if(n == 1) return 0;

        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int maxReach = nums[i] + i;
            int steps = dp[i];
            int j = i+1;
            while(j < n && j <= maxReach){
                if(dp[j] != 0){
                    j++;
                    continue;
                }

                dp[j] = steps + 1;
                j++;
            }
        }
        return dp[n-1];
    }
}
