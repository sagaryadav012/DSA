package BitManipulation.Medium;

public class SingleNumber2_LC137 {
    public static void main(String[] args) {
        int[] nums = {8,9,7,5,7,7,9,8,9,8};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int bit = 0; bit < 32; bit++){
            int count = 0;
            for(int i = 0; i < n; i++){
                if(((nums[i]>>bit)&1) == 1) count++;
            }
            if(count % 3 == 1) ans += 1<<bit;
        }
        return ans;
    }
}
/*
-> Each integer has 32 bits.
-> Given nums have every integer is repeated 3 times except one.
-> If count set bits of all number at each position(bit), do mod of count with 3, if it gives 0 that means
   there is no set bit at this position of unique. if mod gives 1, then do << with bit position and add to result.
-> TC - O(32 * N)
 */