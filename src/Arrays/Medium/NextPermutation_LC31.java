package Arrays.Medium;

import java.util.Arrays;

public class NextPermutation_LC31 {
    public static void main(String[] args) {
        int[] nums = {5,3,6,4,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
/*
-> Check increasing subArray from last, that means we covered big value, so there is no next permutation for it.
-> Now find greater value than current value from last. Swap those and sort.

 Ex : 5,3,6,4,2,1
    Here increasing sub array from right to left is 6,4,2,1 there is no next permutation for it.
    We covered all permutations starts with 3, last permutation is 3,6,4,2,1. so after 3, next available
    greater value is 4, so now permutations starts with 4. So swap those values.

    5,4,6,3,2,1 -> now reverse sub array from 6 to 1 -> 5,4,1,2,3,6
    Next permutation of 5,3,6,4,2,1 is 5,4,1,2,3,6.
 */