package BinarySearch.OneD_Array;

public class MinInRotatedSortedArray2_LC154 {
    public static void main(String[] args) {
        int[] nums= {3,1,3};
        System.out.println(findMin1(nums));
    }
    public static int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left += 1;
                right -= 1;
                continue;
            }
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) left = mid+1;
            else if(nums[mid] < nums[right]) right = mid; // don't use mid -1 TestCase : 3 1 3
            else right -= 1;
        }

        return nums[left];
    }
}
/*
-> It is same as Leetcode 153, but here we need to handle duplicate values.
-> Ex 3,0,3,3,3,3 in this case it considered as no rotated array and right pointer moves to right = mid;
-> Ok, it's fine we get ans but take this example 3,3,3,3,3,0,3. Here also it considers no rotated array
   and move right = mid, but we lost our answer.
-> So when left == mid == right then move left += 1, right -= 1 to avoid duplicates. we have done same
   in LeetCode 81.
-> To understand this first read explanation of LeetCode 153 then 81
 */
