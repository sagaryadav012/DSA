package Arrays.Medium;

import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated_LC1752 {
    public static void main(String[] args) {
        int[] nums = {3,4,1,2};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        return count <= 1;
    }
}

/*
-> If array is sorted then there is no peak.
-> If array is sorted and rotated then there is only one peak.
-> If we find more than one peak that means array is not sorted and rotated.
 */
