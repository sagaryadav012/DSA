package Arrays;

public class CountSubArrays_LC2962 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3};
        int k = 2;
        System.out.println(countSubarrays(nums, k));
        System.out.println(countSubarrays1(nums, k));
        System.out.println(countSubarrays3(nums, k));
    }
    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxNum = 0;

        for(int num : nums){
            maxNum = Math.max(num, maxNum);
        }
        long subArrays = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int freq = 0;
                for(int p = i; p <= j; p++) {
                    if (nums[p] == maxNum) freq += 1;
                }
                if(freq >= k) subArrays += 1;
            }
        }
        return subArrays;
    }
    public static long countSubarrays1(int[] nums, int k) {
        int n = nums.length;
        int maxNum = 0;

        for(int num : nums){
            maxNum = Math.max(num, maxNum);
        }
        long subArrays = 0;

        for(int i = 0; i < n; i++){
            int freq = 0;
            for(int j = i; j < n; j++){
                if (nums[j] == maxNum) freq += 1;
                if(freq >= k) subArrays += 1;
            }
        }
        return subArrays;
    }
    public static long countSubarrays2(int[] nums, int k) {
        int n = nums.length;
        int maxNum = 0;

        for(int num : nums){
            maxNum = Math.max(num, maxNum);
        }
        long subArrays = 0;

        for(int i = 0; i < n; i++){
            int freq = 0;
            for(int j = i; j < n; j++){
                if (nums[j] == maxNum) freq += 1;
                if(freq >= k) subArrays += 1;
            }
        }
        return subArrays;
    }
    public static long countSubarrays3(int[] nums, int k) {
        int n = nums.length;
        int maxNum = 0;

        for(int num : nums){
            maxNum = Math.max(num, maxNum);
        }
        long subArrays = 0;

        int i = 0, j = 0, freq = 0;
        while(j < n){
            if(nums[j] != maxNum){
                j++;
                continue;
            }

            freq += 1;
            while(freq == k){
                subArrays += n - j;
                if(nums[i] == maxNum) freq -= 1;
                i++;
            }
            j++;
        }
        return subArrays;
    }

}
/*
Approach 1 : TC - O(N^3) SC - O(1)

Approach 2 : TC - O(N^2) SC - O(1)

Approach 3 : TC - O(N) SC - O(1)
-> count freq of maxNum, when we encounter freq >= k then count subArrays.
-> for example array {3,3} max is 3 and k = 2.
    when we at index 1, freq will be 2, freq == k, no.of sub arrays with maxNum freq = k is 1.
    if add some more nums to array, then sub array count with maxNum freq is current count + no.of nums added.
    like arr {3,3} count = 1, add 3 more nums to arr {3,3,2,4,5} now count += 3 -> 4.
-> Similarly take two pointers i and j. move j and count freq. if freq == k then it is one subarray + no.of nums left.
   means already sub array has maxNum freq = k, if add anything to it, freq won't change right?
   if add one more num, means there is one more sub array.
 */

