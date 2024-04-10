package QueueAndStacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement1_LC496 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(); // Store num and next num value index
        map.put(nums2[n-1], n); // For last num, there will be no greater num.

        for(int i = n-2; i >= 0; i--){
            int nextIdx = i+1; // Assume num at next index is greater
            // check curr num >= nextNum ask that who is your next greater and repeat process until it gets greater.
            while(nextIdx < n && nums2[i] >= nums2[nextIdx]){
                nextIdx = map.get(nums2[nextIdx]);
            }
            map.put(nums2[i], nextIdx);
        }

        // Once we know greater num indexes of nums2, find greater num of nums1
        int m = nums1.length;
        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            int index = map.get(nums1[i]);
            if(index == n) ans[i] = -1;
            else ans[i] = nums2[index];
        }

        return ans;
    }
}
