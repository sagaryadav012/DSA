package QueueAndStacks.Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMax_LC239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) { // TC - O(N) SC - O(K)
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            if(!deque.isEmpty() && nums[deque.peekFirst()] <= i-k){
                deque.pollFirst();
            }
            deque.addLast(i);
            if(i >= k-1){
                ans[index++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
    public static int[] maxSlidingWindow1(int[] nums, int k) { // TC - O(NlogN) SC - O(K)
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] ans = new int[n-k+1];
        int index = 0;

        for(int i = 0; i < n; i++){
            pq.add(new int[]{nums[i], i});
            if(i >= k-1){
                if(pq.peek()[1] <= i-k) pq.poll();
                ans[index++] =  pq.peek()[0];
            }
        }
        return ans;
    }
}
