package DP.OneD_DP;

public class HouseRobber2_LC213 {
    public static void main(String[] args) {
        HouseRobber2_LC213 obj = new HouseRobber2_LC213();
        int[] nums = {3,2,4,6,5,9,1,3};
        System.out.println(obj.rob(nums));
    }
    public int rob(int[] nums) { // TC - O(N) SC - O(1)
        int n = nums.length;
        if(n == 0) return nums[0];
        if(n == 1) return Math.max(nums[0], nums[1]);

        int money1 = robMoney(0, n-2, nums);
        int money2 = robMoney(1, n-1, nums);

        return Math.max(money1, money2);
    }
    public int robMoney(int start, int end, int[] nums){
        int lastHouse = nums[start];
        int prevHouse = Math.max(lastHouse, nums[start+1]);

        for(int i = start+2; i <= end; i++){
            int currentHouse = Math.max(nums[i]+lastHouse, prevHouse);
            lastHouse = prevHouse;
            prevHouse = currentHouse;
        }

        return prevHouse;
    }

}
/*
-> It is same like as House robber but here houses are connected in circle.
-> If thief rob first house then can't rob last house, if thief can't rob first house the can rob last house.
-> so do same as house robber but first find amount robbed from houses 0 to n-2 and 1 to n-1 and take max one as ans.

 */
