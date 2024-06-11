package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK_GFG {
    public static void main(String[] args) {

    }
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        for(int i = 0; i < N; i++){
            int num = A[i];
            prefixSum += num;

            if(prefixSum == K){
                maxLen = Math.max(maxLen, i + 1);
            }

            int x = prefixSum - K;
            if(map.containsKey(x)){
                maxLen = Math.max(maxLen, i - map.get(x));
            }

            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }

        }

        return maxLen;
    }
}
/*
Given an array containing N integers and an integer K.,
Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

Example 1:
Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.


Approach 1 :
-> Generate all subarray, do sum, if sum == k take length.
-> TC - O(N^3) SC - O(1)

Approach 2 :
-> Use carry forward technique to do sum, and take len every time we get new sum == k.
-> TC - O(N^2) SC - O(1)

Approach 3 :
-> Use prefixSum and HashMap to find sum == k.
-> Iterate over array, take prefixSum at each step. We need sum = k, How can we calculate ?
-> For example currently pointer at index 9, and prefixSum till now is x, If there is a sum(x-k) exists before or
   assume x-k occurs at index 3, then the sum from index 4 to 9 is equal to k.
-> So while iterating store prefixSum and it's index, because it may equal to x-k.
-> If we get prefixSum directly == k then take length as current index + 1;
-> We need longest subArray, so store index of prefixSum if it map doesn't contains only.
   do not update index every time when prefixSum occurs again.
-> And one more edge case, store prefixSum when it even equals to k. Dry the test case given below.
-> TC - O(N) SC - O(N)


Approach 4 :
-> Two pointers approach work only when nums are positive.


Test case :
k = 3
2 -2 3 -3 3 3 4 -4 5 -5

 */
