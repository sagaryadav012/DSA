package BitManipulation.Medium;

import java.util.Arrays;

public class SingleNumber3_LC260 {
    public static void main(String[] args) {
        int[] nums = {5,4,6,3,5,3,4,7};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) xor ^= num;
        int index = -1;
        for(int bit = 0; bit <= 31; bit++){
            if(((xor>>bit)&1) == 1) index = bit;
        }

        int num1 = 0;
        int num2 = 0;

        for(int num : nums){
            if(((num>>index)&1) == 1) num1 ^= num;
            else num2 ^= num;
        }

        return new int[]{num1, num2};
    }
}
