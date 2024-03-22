package DP.OneD_DP;

import java.util.Arrays;

public class HouseRobber_LC198 {
    public static void main(String[] args) {
        HouseRobber_LC198 obj = new HouseRobber_LC198();
        int[] nums = {2,7,9,3,1};
        System.out.println(obj.rob(nums));
        System.out.println(obj.rob1(nums));
    }
    public int rob(int[] nums){ // TC - O(2^n) SC - O(N)
        int n = nums.length;
        int maxAmount = maxAmount(0, n-1, nums);

        return maxAmount;
    }
    public int maxAmount(int amount, int index, int[] nums){
        if(index < 0) return amount;
        int dontRob = maxAmount(amount, index - 1, nums);
        int rob = maxAmount(amount + nums[index], index - 2, nums);
        return Math.max(dontRob, rob);
    }
    public int rob1(int[] nums) { // TC - O(N) SC - O(1)
        int n = nums.length;
        if(n == 1) return nums[0];

        int lastHouse = nums[0];
        int prevHouse = Math.max(lastHouse, nums[1]);

        for(int i = 2; i < n; i++){
            int currHouse = Math.max(prevHouse, lastHouse + nums[i]);
            lastHouse = prevHouse;
            prevHouse = currHouse;
        }
        return prevHouse;
    }
}
/*
-> If we rob one house we can't rob next or adjacent house.
-> so the condition will be, if rob house then next rob house is index - 2, if don't rob next rob house will be index - 1.

Tabulation(Bottom Approach) : store max amount robbed from adjacent houses.
-> Check first two houses, rob max amount of house.
-> Rob current index house and add to the total amount robbed till index - 2
-> Now check which amount is max from current index, current index - 1. Take that amount only.

dp[0] = 0, dp[1] = max(dp[0], nums[1]);
dp[i] = max(nums[i] + dp[i-2], dp[i-1]);

Ex :    3       2       4       3       6       8       6       3
DP :    3       3       7       7       13      15      19      19
 */