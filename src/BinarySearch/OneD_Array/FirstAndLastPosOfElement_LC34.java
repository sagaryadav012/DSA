package BinarySearch.OneD_Array;

import java.util.Arrays;

public class FirstAndLastPosOfElement_LC34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange1(nums, target)));
    }
    public static int[] searchRange1(int[] nums, int target) { // TC - O(logN) approx, SC - O(1)
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int start = -1, end = -1;

        while(left <= right) {
            int mid  = left + (right-left)/2;
            if(nums[mid] == target && (mid ==0 || nums[mid-1] != target)) {
                start = mid;
                while(mid<n && nums[mid] == target) {
                    end = mid;
                    mid++;
                }
                return new int[] {start, end};
            }
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return new int[] {start, end};
    }
}
/*
-> Find first occurrence first, and start iterate from there to find last occurrence.
 */