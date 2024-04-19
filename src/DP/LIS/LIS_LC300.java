package DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LIS_LC300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int n = nums.length;

        System.out.println(recursiveCode(0, -1, nums));

        int[][] cache = new int[n+1][n+1];
        for(int[] ar : cache){
            Arrays.fill(ar, -1);
        }
        System.out.println(recursiveDP(0, -1, nums, cache, n));
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS1(nums));
    }

    // Recursive Code : TC - O(2^N) SC - O(N)
    public static int recursiveCode(int index, int prev_Index, int[] nums){
        if(index == nums.length) return 0;
        int count = recursiveCode(index + 1, prev_Index, nums); // Dont Take
        if(prev_Index == -1 || nums[prev_Index] < nums[index]){ // Take
            count = Math.max(count, 1 + recursiveCode(index + 1, index, nums));
        }
        return count;
    }
    // Recursive Code DP(Top - Down Approach -> Memoization) : TC - O(N*N) SC - O(N*N + stackSpace N)
    public static int recursiveDP(int index, int prev_Index, int[] nums, int[][] cache, int n){
        if(index == n) return 0;
        // Since prev_index goes from -1 to n-1 -> we took n+1 -> [0 - n] -> to avoid -1, we added + 1 -> index[-1] will be index[-1+1]
        if(cache[index][prev_Index + 1] != -1) return cache[index][prev_Index + 1];
        int count = recursiveDP(index + 1, prev_Index, nums, cache, n);
        if(prev_Index == -1 || nums[prev_Index] < nums[index]){
            count = Math.max(count, 1 + recursiveDP(index + 1, index, nums, cache, n));
        }
        cache[index][prev_Index + 1] = count;
        return count;
    }
    public static int lengthOfLIS(int[] nums) { // TC - O(N^2) SC - O(N)
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[j]+1, lis[i]);
                }
            }
        }
        System.out.println(Arrays.toString(lis));
        int maxLen = 0;
        for(int num : lis){
            maxLen = Math.max(maxLen, num);
        }

        return maxLen;
    }
    public static int lengthOfLIS1(int[] nums){ // TC - O(NlogN) SC - O(N)
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int num : nums){
            if(num > list.get(list.size() - 1)){
                list.add(num);
                continue;
            }

            int insertPos = Collections.binarySearch(list, num); // if num present will return index, else returns -(insertPos) - 1;
            if(insertPos < 0){
                insertPos = -(insertPos + 1);
            }
            list.set(insertPos, num);
        }
        System.out.println(list);
        return list.size();
    }
}
