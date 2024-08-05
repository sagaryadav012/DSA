package Arrays.LeetCodeMSC;

import java.util.Arrays;

public class RotateArray_LC189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate1(nums, k);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) { // TC - O(N) SC - O(N)
        int n = nums.length;
        int[] temp = new int[n];
        k = k%n;

        if(k == 0) return;

        for(int i = 0; i < n; i++){
            int j = (i+k)%n;
            temp[j] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }
    public static void rotate1(int[] nums, int k) { // TC - O(N) SC - O(1)
        int n = nums.length;
        k = k%n;

        if(k == 0) return;

        reverseArray(0, n-1, nums);
        reverseArray(0, k-1, nums);
        reverseArray(k, n-1, nums);
    }
    public static void reverseArray(int s, int e, int[] nums){
        while(s < e){
            nums[s] = (nums[s] + nums[e]) - (nums[e] = nums[s]);
            s++; e--;
        }
    }
}
