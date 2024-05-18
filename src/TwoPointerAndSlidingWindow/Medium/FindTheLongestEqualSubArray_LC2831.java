package TwoPointerAndSlidingWindow.Medium;

import java.util.List;

public class FindTheLongestEqualSubArray_LC2831 {
    public static void main(String[] args) {

    }
    public static int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        int left = 0;
        int right = 0;
        int[] freq = new int[100001];
        int maxFreq = 0;
        int maxLen = 0;
        while(right < n){
            maxFreq = Math.max(maxFreq, ++freq[nums.get(right)]);
            int len = right - left + 1;
            if(len - maxFreq <= k){
                maxLen = Math.max(maxLen, maxFreq);
                right++;
            }
            else{
                freq[nums.get(left)]--;
                left++;
            }
        }
        return maxLen;
    }
}
/*
Approach 1 :
-> Generate all sub arrays, take each sub array and count freq of each num.
-> If length of sub array - maxFreq <= k that mean we can delete len - maxFreq elements in that sub array,
   and length will be maxFreq.
-> TC - O(N^3) SC - O(1)

Approach 2 :
-> Use two pointer to find valid window, here valid window means can be able to delete at most k elements in
   that particular window.
-> Increase the window size, and check is it valid window or not, If valid take length.
-> To find the window is valid or not, len - maxFreq <= k.
 */
