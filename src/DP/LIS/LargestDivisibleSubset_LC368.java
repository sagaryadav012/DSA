package DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_LC368 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,8,9};
        System.out.println(largestDivisibleSubset(nums));
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] count = new int[n];
        int[] prevIndex = new int[n];

        int maxCount = 0;
        int index = -1;

        for(int i = 0; i < n; i++){
            count[i] = 1;
            prevIndex[i] = -1;
            for(int j = i-1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 && count[j]+1 > count[i]){
                    count[i] = count[j]+1;
                    prevIndex[i] = j;
                }
            }
            if(count[i] > maxCount){
                maxCount = count[i];
                index = i;
            }
        }

        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(prevIndex));
        System.out.println(maxCount + " : " +index);

        List<Integer> list = new ArrayList<>();
        while(index != -1){
            list.add(nums[index]);
            index = prevIndex[index];
        }

        return list;
    }
}
/*
Approach 1:
-> Generate all subsets and check nums[i] % nums[j] == 0 or nums[j] % nums[i] == 0.
-> TC - O(2^n + n) SC - O(2^n * n) store each subset.
-> If array length = 3, then no.of subsets = 2^3 = 8

Approach 2:
-> Take example nums = {8,7,2,16,1}
-> To check num satisfies condition, we have to iterate over array and check nums[i] % nums[j] == 0 or nums[j] % nums[i] == 0.
-> Sort array -> 1,2,7,8,16
-> Now it is similar to LIS, We don't need to check all nums to check condition, for example 8 is divisible 1,2.
   if we add 16, we don't need to check from starting just check 16 is divisible 8 or not. If 16%8 == 0 then
   16 divisible by 1,2 also. That's why sort array and one condition is enough to check nums[i] % nums[j] == 0.
-> TC - O(N^2) SC - O(N)

Dry run : 1,2,3,4,8,9
count[] tracks how many nums are satisfies condition.
prevIndex[] track previous number(index) of current num.
maxCount tracks max count of longest divisible subset.
index tracks index of last num of longest divisible subset.

    index:  0       1       2       3       4       5
    nums :  1       2       3       4       8       9

    We get this last :
    index   = 0     1       2       3       4       5
    count[] = 1     2       2       3       4       3
  prevIndex = -1    0       0       1       3       2

  start from index = 4, add nums[index] to list and index = prevIndex[index]
 */
