package QueueAndStacks.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubArray_LC1438 {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int limit = 3;
        System.out.println(longestSubarray(nums, limit));
    }
    public static int longestSubarray(int[] nums, int limit) { // TC - O(N+N) SC - O(N)
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();

        int n = nums.length;
        int left = 0, maxLen = 0;
        for(int right = 0; right < n; right++){
            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[right]){
                maxQueue.pollLast();
            }
            maxQueue.add(right);

            while(!minQueue.isEmpty() && nums[minQueue.peekLast()] >= nums[right]){
                minQueue.pollLast();
            }
            minQueue.add(right);

            while(!maxQueue.isEmpty() && !minQueue.isEmpty() && nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit){
                left++;
                if(maxQueue.peekFirst() < left) maxQueue.pollFirst();
                if(minQueue.peekFirst() < left) minQueue.pollFirst();
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
