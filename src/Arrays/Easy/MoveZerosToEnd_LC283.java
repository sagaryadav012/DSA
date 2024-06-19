package Arrays.Easy;

import java.util.Arrays;

public class MoveZerosToEnd_LC283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int pos = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                nums[pos++] = nums[i];
            }
        }

        while(pos < n){
            nums[pos++] = 0;
        }
    }
}
