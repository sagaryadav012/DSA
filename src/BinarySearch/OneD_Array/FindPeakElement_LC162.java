package BinarySearch.OneD_Array;

public class FindPeakElement_LC162 {
    public static void main(String[] args) {
        int[] nums = {3,4,3,2,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-2] < nums[n-1]) return n-1;

        int left = 0;
        int right = n - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            int prev = safeGet(mid-1, n, nums);
            int next = safeGet(mid + 1, n, nums);

            if(prev < nums[mid] && nums[mid] > next) return mid;

            if(prev < nums[mid] && nums[mid] < next)
                left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static int safeGet(int index, int n, int[] nums){
        if(index < 0 || index >= n) return Integer.MIN_VALUE;
        return nums[index];
    }
}
/*
-> We need to find peak element, it means nums[i-1] < nums[i] > nums[i+1], neighbours should be smaller.
-> In question given that nums[-1] and nums[n] = -infinity and nums[i] != nums[i-1] at any i.
-> We can do linear search here. TC - O(N)
-> If we want to apply Binary Search we need 3 things Search Space, Target, Where to move.
-> Search Space we know, Target in element neighbours is smaller than it, where to move? this we need to find.
-> There could be 4 scenarios :
    1. nums[i] can be nums[i-1] < nums[i] > nums[i+1] in this case return answer directly.

    2. nums[i] can be nums[i-1] < nums[i] < nums[i+1] in this case check pattern, it is increasing order,
       So which side can move, so that we can find answer, if move right side we get max only since it is
       increasing and nums[n] is -infinity, nums[i] < nums[i+1] .. -infinity, so definitely we get answer.

    3. nums[i] can be nums[i-1] > nums[i] > nums[i+1] in this case check pattern, it is decreasing order,
       So which side can move?, so that we can find answer, if move left side we get max only since it is
       increasing to left and nums[-1] is -infinity, -infinity < nums[i-1] < nums[i], so definitely we get answer.

    4. nums[i] can be nums[i-1] > nums[i] < nums[i+1] in this case we can move any side, we get max if move
       to any side.
 */
