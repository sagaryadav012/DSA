package TwoPointerAndSlidingWindow.Medium;

public class MaxConsecutiveOnes3_LC1004 {
    public static void main(String[] args) {

    }
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int maxLen = 0;
        while(right < n){
            // when num == 1, take len and move right pointer to forward
            if(nums[right] == 1){
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
                continue;
            }

            // when num == 0, check can we have chance to take this 0, if yes take len, decrement k, move right pointer to forward
            if(k > 0){
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
                k--;
                continue;
            }

            // If no chances to left to take 0, then move left pointer, if nums[left] == 0 then increment k
            if(nums[left] == 0){
                k++;
            }
            left++;
        }
        return maxLen;
    }
}
