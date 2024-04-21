package DP.LIS;

import java.util.Arrays;

public class NumberOfLIS_LC673 {
    public static void main(String[] args) {
        int[] nums = {1,3,6,5,4,8,11,7,13,12};
        System.out.println(findNumberOfLIS(nums));
    }
    public static int findNumberOfLIS(int[] nums) { // TC - O(N^2) SC - O(N)
       int n = nums.length;
       int[] dp = new int[n];
       int[] count = new int[n];

       int maxLen = 0;

       for(int i = 0; i < n; i++){
           // initially each num is LIS len 1 and count of LIS len of 1 is 1.
           dp[i] = 1;
           count[i] = 1;
           for(int j = 0; j < n; j++){
               if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
                   // if prev num smaller than curr num then take LIS len and since we added num to it take count of prev num
                   dp[i] = dp[j] + 1;
                   count[i] = count[j];
               }
               else if(nums[i] > nums[j] && dp[j]+1 == dp[i]){
                   count[i] += count[j];
               }
           }
           if(maxLen < dp[i]){
               maxLen = dp[i];
           }
       }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(count));
       // Once we know LIS len, then count how many no.of LIS are there with len = maxLen
       int countLIS = 0;
       for(int i = 0; i < n; i++){
           if(dp[i] == maxLen){
               countLIS += count[i];
           }
       }
       return countLIS;
    }
}
/*
-> We have to count no.of LIS. For example nums = {1,3,5,4,7}
-> Here longest increasing subsequence length is 4. And there are 2 subsequences with length 4. {1,3,5,7} and {1,3,4,7}
-> It is similar to LIS, but we need count of LISs. so count same length of LISs at each step.
-> Use Count[] to track no.of LIS's of same length.
-> If LIS length is 3 and count of same length LISs are 4. We added one more number to LIS then it's length will be 4,
   No.of LISs are what? It's count of prev length of LIS.
   For example nums = {1,3,5,4}
   LISs are 1,3,5 and 1,3,4 both are same length(count of LISs = 2). If we add 7 to nums like 1,3,5,4,7 then
   LISs are 1,3,5,7 and 1,3,4,7 and count is same as prev count of prev length LIS.
-> So whenever we add num to LIS take count of no.of LISs as current count. means If LISs length is 4 and no.of
   LISs are 5, now we added one more num to LIS, now length will be 5 and no.of LISs are length will be also same
   as previous count.

-> dp = {3,  3,  3}
   count = {1,  1,  1} Here LIS len is 3 and If add greater number len will be 4 and count should 3.
   We Iterate over dp and will check nums[i] > nums[j] && dp[j]+1 > dp[i] if it is true will take count.
   It will not increase count to 3 so check this case : nums[i] > nums[j] && dp[j]+1 == dp[i] take count[i] += count[j]


-> Dry run nums = {1,3,6,5,4,8,11,7,13,12}

    nums    :   1       3       6       5       4       8       11      7       13      12
    dp      :   1       2       3       3       3       4       5       4       6       6
    count   :   1       1       1       1       1       3       3       3       3       3

    LISs are :
    1,3,6,8,11,13
    1,3,5,8,11,13
    1,3,4,8,11,13
    1,3,6,8,11,12
    1,3,5,8,11,12
    1,3,4,8,11,12

 */
