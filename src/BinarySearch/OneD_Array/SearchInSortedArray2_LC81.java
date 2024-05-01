package BinarySearch.OneD_Array;

public class SearchInSortedArray2_LC81 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
    }
    public static boolean search(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target) return true;

            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left += 1;
                right -= 1;
                continue;
            }

            if(nums[left] <= nums[mid]){ // It means left half sorted
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else { // It means right half sorted
                if(nums[mid + 1] <= target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}

/*
-> It's almost same as Search in rotated sorted array without duplicates. but in this we have duplicates.
-> So, above approach will not work. If array doesn't have duplicates it's easy to find which half is sorted.
-> If array has duplicates it's not possible to find which half is sorted.
   Ex : 3   0   3   3   3   3   3
   Here left, mid and right of nums is same that is 3.
   Is it possible to find which half is sorted and find where target lies? it's not possible, when we get into
   this scenario just reduce search space left++ and right--. now again do BS.
-> If left == mid and mid != right or left != mid and mid == right, In this case it is possible which half is sorted but
   only when left == mid == right in this case it is not possible.
-> Why do we not use while loop while(nums[left] == nums[mid] && nums[mid] == nums[right]),
   Dry run this nums = {1} target = 0;

-> TC - O(logN) approx. In worst it could be n/2 -> (3   0   3   3   3   3   3)
 */