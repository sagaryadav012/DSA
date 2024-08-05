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
-> If array is sorted then it will be in increasing order.
-> If array is sorted and rotated then there is only one val that will be greater than it's next val.
-> If there are multiple values that will be greater than it's next val then it is not sorted and rotated.
-> we are checking next values so index could be out of bound, so mod it with n.
   we need to check entire array, so when we check last index value then next index would be 0 index.
   Try this test case 1,2,3,4,5.
 */
