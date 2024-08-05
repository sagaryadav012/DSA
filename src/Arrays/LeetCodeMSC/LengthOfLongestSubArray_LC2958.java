package Arrays.LeetCodeMSC;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubArray_LC2958 {
    public static void main(String[] args) {
        int[] nums = {5,5,5,5,5,5,5};
        int k = 4;
        System.out.println(maxSubarrayLength(nums, k));
    }
    public static int maxSubarrayLength(int[] nums, int k) { // TC - O(N) SC - O(N)
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int len = 0;
        while(j < n){
            int num = nums[j];
            map.put(num, map.getOrDefault(num,0) + 1);
            while(map.get(num) > k){
                if(map.get(nums[i]) != null) map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            len = Math.max(len, j-i+1);
            j++;
        }
        return len;
    }
}
/*
Approach 1 :
-> Take two pointer, store freq of current element and move j pointer.
-> Before take len, check current element freq <= k else move i pointer until current element freq <= k.
-> Once it has done, take len.
-> TC - O(N) SC - O(N)
 */