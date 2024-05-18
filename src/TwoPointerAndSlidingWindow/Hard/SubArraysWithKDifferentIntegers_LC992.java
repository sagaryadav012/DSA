package TwoPointerAndSlidingWindow.Hard;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentIntegers_LC992 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
       return findSubArraysCount(nums, k) - findSubArraysCount(nums, k-1);
    }
    public static int findSubArraysCount(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int subArraysCount = 0;
        while(right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k){
                int freq = map.get(nums[left]);
                if(freq == 1)map.remove(nums[left]);
                else map.put(nums[left], freq - 1);
                left++;
            }
            subArraysCount += right - left + 1;
            right++;
        }
        return subArraysCount;
    }
}
/*
Approach 1 :
-> Generate all sub strings, check each sub string has k different integer, if yes  count += 1.
-> TC - O(N^2) SC - O(1)

Approach 2 : Two pointers technique
-> We can't sub array with exactly k different integers directly. so first find subArrays with at most <= k
   different integers and subArrays with at most <= k-1 different integers.
-> Take two pointers, it represents window size. Initially l = 0, r = 0.
-> Move right point to forward, it increases window size, while it increases check sub array of window size is
   valid or not. If yes take sub arrays count.
-> TC - O(N) SC - O(k)
 */