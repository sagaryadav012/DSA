package BinarySearch.OneD_Array;

public class MinInRotatedSortedArray_LC153 {
    public static void main(String[] args) {
        int[] nums = {3,1,2};
        System.out.println(findMin1(nums));
    }
    public static int findMin1(int[] nums) { // TC - O(LogN) SC - O(1)
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]){
                right = mid; // it means array is not rotated, mid-1 works here
            }
            else if(nums[left] <= nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return nums[left];
    }
    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) left = mid+1;
            else right = mid;
        }

        return nums[left];
    }
}
/*
Approach 1 :
-> If array is sorted and not rotated we can easily find min.
-> If array is sorted, one half is sorted and another half would not be sorted.
-> Min value lies in unsorted array or it could be mid of array.
   Ex : 4,5,6,7,0,1,2 in this min lies in unsorted array, 4,5,1,2,3 here min is mid.
-> One thing sure that we can eliminate sorted array, if array is not rotated, eliminate right search space.
-> How can we know array is rotated or not, when two halfs are sorted it's not rotated.
-> So, first check array is rotated or not, if yes eliminate second half -> right = mid;
-> else first half is sorted, eliminate first half -> left = mid+1
-> else if we reach here it means second half is sorted so min lies in left half, so eliminate right half -> right = mid
-> Why right = mid - 1 ? min could be mid of nums so need to check it. Dry run 3,1,2
-> Since right = mid, check while left < right not <=


Approach 2 :
-> It is same as approach1 but optimised steps to check which one half is sorted, which half is not sorted.
-> Compare mid with last right, if mid > right it means right half is not sorted so min lies here.
-> else if we reach here that means right half is sorted. if left half is not sorted min lies here,
   even left half sorted, that means left and right half sorted means array not rotated, so check
   in first half also.

 Test cases :
 4,5,6,7,0,1,2
 7,8,1,2,3,4,5,6
 3,1,2
 4,5,1,2,3
 */
