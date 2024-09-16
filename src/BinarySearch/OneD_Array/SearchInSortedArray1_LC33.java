package BinarySearch.OneD_Array;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class SearchInSortedArray1_LC33 {
    public static void main(String[] args) {
        int[] nums = {3,4,1,2};
        int target = 5;
        System.out.println(search(nums, target));
        System.out.println(search1(nums, target));
    }

    // TC - O(logN) SC - O(1)
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int targetRegion = getRegion(nums, target);

        while(left <= right){
            int mid = left + (right-left)/2;
            int midRegion = getRegion(nums, nums[mid]);
            if(midRegion < targetRegion){
                left = mid+1;
                continue;
            }
            if(midRegion > targetRegion){
                right = mid-1;
                continue;
            }

            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
    private static int getRegion(int[] nums, int val){
        if(val < nums[0]) return 2;
        return 1;
    }

    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]){ // It means left half sorted
                if(nums[left] <= target && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else { // It means right half sorted
                if(nums[mid + 1] <= target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

}

/*
Approach 1 :
-> We know that array can be rotated or not rotated.
-> If we want to do binary search we need to know search space, target and where to move.
-> If we know target and mid-value are in same search space, then simply we can do binary search.
-> If target and mid are not in same search space, bring them into same search space and do BS.
-> TC - O(logN)

Approach 2 :
-> If array is rotated, it would be difficult to know where to move.
-> If array is sorted we can easily find, observe that when we find mid, array either from 0 to mid or mid + 1 to n-1 would be sorted.
-> Once we find sorted array it would be easy to check whether target lies in between them, if it's there then
   we eliminate other half search space.

Dry run :
 -> array : 4,5,6,7,0,1,2 and target 0
 -> array : 6,0,1,2,3,4,5 and target 0
 -> array : 5,1,3 and target 5;

 Is this code is not enough ?
       while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid] && nums[left] <= target && target <= nums[mid]){
                right = mid - 1;
            }
            else left = mid + 1;
        }
The above code fails, where we are checking array is sorted if yes check target exists, if exist we eliminate other half.
Ok above point is correct, if array is not sorted then move other half but the target exist in current not sorted half.
So here we need sorted half to check only target exist.

 */