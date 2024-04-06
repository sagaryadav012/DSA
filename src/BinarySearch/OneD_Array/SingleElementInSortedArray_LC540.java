package BinarySearch.OneD_Array;

public class SingleElementInSortedArray_LC540 {
    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }

            if(nums[mid] == nums[mid-1]) mid = mid-1;
            if(mid % 2 != 0) right = mid - 1;
            else left = mid + 2;
        }
        return -1;
    }
}
/*
-> Observe indexes so that we know where to move
        0 1 2 3 4
-> Ex : 1 1 2 3 3 check here before single occurs first occurrence of an element at index even, after
        single element occurs first occurrence of an element at index at odd index.
-> So do binary search on nums since those are sorted, find first occurrence, and check at which index it
    occurs and move appropriately.
 */