package Greedy.Medium;

public class JumpGame_LC55 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump1(nums));
        System.out.println(canJump2(nums));
    }
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        int last = n - 1;
        for(int i = n - 2; i >= 0; i--)  {
            int canReach = i + nums[i];
            if(canReach >= last) last = i;
        }
        return last == 0;
    }
    public static boolean canJump2(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];

        dp[0] = true;
        for(int i = 0; i < n; i++)  {
            if(!dp[i]) return false; // It means no has reached to this place.
            int min = Math.min(i+nums[i], n-1);
            for(int j = i+1; j <= min; j++){
                dp[j] = true;
            }
        }
        return dp[n-1];
    }
    public boolean canJump3(int[] nums) {
        int n = nums.length;
        int last = n - 1;
        for(int i = n - 2; i >= 0; i--)  {
            if(i + nums[i] >= last) last = i;
        }
        return last == 0;
    }
}

/*
Approach 3 :
-> We have to check weather can reach last index.
-> So take to pointers(i and last), one(last) of it points to last index and other one(i) traverse from n-2 to 0.
-> Now take jumps at index i and check can reach index at last. If we can reach then change last point to i, means
   can reach from i to last so check remaining jumps to reach i, if we reach we can reach last also.
 */