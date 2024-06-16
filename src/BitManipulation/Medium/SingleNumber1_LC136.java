package BitManipulation.Medium;

public class SingleNumber1_LC136 {
    public static void main(String[] args) {
       int[] nums = {2,3,4,1,4,3,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
/*
-> XOR of same bits give 0, So when we do xor same numbers it gives result 0.
-> So do xor of all, xor of same numbers give 0, 0^unique number = unique number.
 */
