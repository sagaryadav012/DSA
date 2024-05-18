package TwoPointerAndSlidingWindow.Medium;

import java.util.HashMap;

public class BinarySubArraysWithSum_LC930 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 1, 0};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
        System.out.println(numSubarraysWithSum1(nums, goal));
//        System.out.println(numberOfSubArrays(nums, goal));
//        System.out.println(numberOfSubArrays(nums, goal-1));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) { // TC - O(N) SC -O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for(int num : nums){
            prefixSum += num;
            int diff = prefixSum - goal;
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
    public static int numSubarraysWithSum1(int[] nums, int goal) { // TC - O(N) SC -O(1)
        return numberOfSubArrays(nums, goal) - numberOfSubArrays(nums, goal - 1);
    }
    public static int numberOfSubArrays(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0, count = 0;
        while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
/*
Approach : 1
-> We have to find no.of sub arrays with sum = goal.
-> Generate all sub arrays, do sum of each sub array. If sum == goal count += 1.
-> TC - O(N^2) SC - O(1)

Approach 2 : sub array sum equal to k problem, TC - O(N) SC - O(N)

Approach 3 :
-> Sliding window or Two pointer technique, It's not possible to find sub array with sum equal to goal, we may
   miss some sub arrays.
   For example nums = {1,0,0,1,1,0} goal = 2; Take two pointers l = 0 and r = 0. Move r to forward and check
   sum == goal if yes count += 1.

   indexes      0       1       2       3       4       5
   nums         1       0       0       1       1       0

   Check here window from 0 to 4, sum is 3, if we move l++ them sum = 2 and will take count += 1, Again move r++
   but if we move r++ the window will be 1 to 5, here we miss window 2 to 4 it also gives sum 2.
   Okay lets keep r at same place and move l++ until window is valid.
   window 1 to 4 valid, then move l++, now window is 2 to 4 it is also valid but we miss window 1 to 5 it also gives
   sum 2. So we are not sure which pointer to move.

-> So Instead of finding sub arrays sum = goal, find sub arrays sum <= goal.
   no.of sub arrays sum equal to goal =  (no.of sub arrays sum <= goal) - (no.of sub arrays sum <= goal - 1).
-> Use two pointers technique to find no.of sub arrays sum <= goal.
   If window size = 3 and sum <= goal, then no.of sub arrays with sum <= goal = r - l + 1
-> TC - O(2 * 2n) SC - O(1)

 */