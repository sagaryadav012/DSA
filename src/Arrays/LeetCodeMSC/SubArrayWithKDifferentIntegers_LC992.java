package Arrays.LeetCodeMSC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArrayWithKDifferentIntegers_LC992 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct1(nums, k));
        System.out.println(subarraysWithKDistinct2(nums, k));
    }
    public static int subarraysWithKDistinct1(int[] nums, int k) { // TC - O(N^2) SC - O(N)
        int n = nums.length;
        Set<Integer> set;

        int totalSubArrays = 0;
        for(int i = 0; i < n; i++){
            set = new HashSet<>();
            for(int j = i; j < n; j++){
                set.add(nums[j]);
                if(set.size() == k) totalSubArrays += 1;
            }
        }
        return totalSubArrays;
    }
    public static int subarraysWithKDistinct2(int[] nums, int k) { // TC - O(N) SC - O(N)
        int subArraysWithAtMostKDifferentIntegers = findAtMostKDifferent(nums, k);
        int subArraysWithAtMostK_1DifferentIntegers = findAtMostKDifferent(nums, k-1);
        return subArraysWithAtMostKDifferentIntegers - subArraysWithAtMostK_1DifferentIntegers;
    }
    public static int findAtMostKDifferent(int[] nums, int k){
        int n = nums.length;
        int i = 0, j = 0;
        int subArrays_count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(map.size() > k){
                int freq = map.get(nums[i]);
                if(freq == 1) map.remove(nums[i]);
                else map.put(nums[i], freq - 1);
                i++;
            }

            subArrays_count += j - i + 1;
            j++;
        }
        return subArrays_count;
    }
}
/*
Approach 1 : Carry Forward Technique
-> Iterate over on each sub array and store distinct values, if size == k then count subArray.
-> TC - O(N^2)  SC - O(N)

Approach 2 :
-> First find sub arrays with at most K different integers.
-> Next find sub arrays with at most k-1 different integers.
-> if k = 3, Sub arrays with at most 3 different integers contains sub arrays with 1, 2, 3 different integers.
-> if k = 2, Sub arrays with at most 2 different integers contains sub arrays with 1, 2 different integers.
-> sub arrays with at most 3 different integers - sub arrays with at most 2 different integers gives sub arrays
   with exactly 3 different integers.

-> So our target is to find first sub arrays with at most k different integers.
-> To find it use Two Pointers and Sliding Window Approach.
-> Take two pointers i, j and they point to 0 index initially. Here i denotes start of sub array, j denotes end
   of sub array. So sub array starts from i and ends with j has at most k different integers.

-> Example nums {1, 2, 1, 3, 4} k = 3

            i           j           map             map.size()<=k            sub arrays count
            0           0           1 -> 1          true                     0 += j-i+1 = 1
            0           1           2 -> 1          true                     1 += j-i+1 = 3
            0           2           1 -> 2          true                     3 += j-i+1 = 6
            0           3           3 -> 1          true                     6 += j-i+1 = 10
            0           4           4 -> 1          false i++
            1           4           1 -> 2-1=1      false i++
            2           4           2 -> 1-1=0      true                    10 += j-i+1 = 13

      why j-i+1 ? array 1,2,1 till here we have count 6, if add 3 to it, still different integers are 3 i.e. <= k
      When we add 3 count will be 6 += j - i + 1 = 3 - 0 + 1 = 4 ==> 4 + 6 = 10.
      We added here 4 means 4 what are 4 sub arrays that have at most 3 different integers ?
      Let's see when we add 3 to array means sub array ends with 3, those are {3}, {1,3}, {2,1,3}, {1,2,1,3}
      Check all sub array those will not exceed k different integers.

 Explanation : https://www.youtube.com/watch?v=akwRFY2eyXs
 */