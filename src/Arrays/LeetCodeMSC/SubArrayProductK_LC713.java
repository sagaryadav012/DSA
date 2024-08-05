package Arrays.LeetCodeMSC;

public class SubArrayProductK_LC713 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
        int k = 1000;
        System.out.println(numSubarrayProductLessThanK1(nums, k));
        System.out.println(numSubarrayProductLessThanK2(nums, k));
        System.out.println(numSubarrayProductLessThanK3(nums, k));
    }

    // TC - O(N^3) SC - O(1)
    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length;
        int totalSubArrays = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 1;
                for(int p = i; p <= j; p++){
                    sum *= nums[p];
                }
                if(sum < k) totalSubArrays += 1;
            }
        }
        return totalSubArrays;
    }

    // TC - O(N^2) SC - O(1)
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int n = nums.length;
        int totalSubArrays = 0;
        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = i; j < n; j++){
                product *= nums[j];
                if(product < k){
                    totalSubArrays += 1;
                }
                else break;
            }
        }
        return totalSubArrays;
    }

    // TC - O(N) SC - O(1)
    public static int numSubarrayProductLessThanK3(int[] nums, int k) {
        int totalSubArrays = 0;
        int n = nums.length;

        int product = 1;

        for(int i = 0, j = 0; j < n; j++){
            product *= nums[j];
            while(product >= k){
                product = product/nums[i];
                i++;
            }
            totalSubArrays += j - i + 1;
        }
        return totalSubArrays;
    }
}

/*
Approach 1 :
-> Generate all sub array, find sum and check sum < k if yes add to count;
-> TC - O(N^3) SC - O(1).

Approach 2 :
-> do product of sub array with help carry forward technique.
-> if product > k then add it ans.
-> TC - O(N^2) SC - O(1)

Approach 3 : TC - O(N) SC - O(1)
-> Suppose we have sub array len 3 and it's product < k, then no.of sub arrays whose product < k is n * (n+1)/2
-> no.of sub array is n * (n+1)/2, if we add 1 more number to array what could be no.of sub arrays?
   Again need to calculate using formula? Let's see
   n = 3 -> {1,2,3} - sub arrays = n * (n+1)/2 = 6
   if added 1 more number, now n = 4 -> {1,2,3,4} -> total sub arrays = n * (n+1)/2 = 10
   instead calculate again, we know sub arrays of len 3, now added 1 so n = 4, just add n+1 to previous count
   Like n = 3, ans = 6 now 6+(n+1) = 6 + 4 = 10.

   Similarly do product of each num in nums, if prod < k then add that to previous sub arrays size.

 -> Ex : {10, 5, 2, 6} k = 100
    initially i = 0, j= 0, p(product) = 1

    i       j       p       p < k   count(count += j - i + 1
    0       0       10      true    0-0+1 = 1
    0       1       50      true    1-0+1 = 2 -> 3
    0       2       100     false -> divide
                    100/10 = 10
    1       2       10      true    2-1+1 = 2 -> 5
    1       3       60      true    3-1+1 = 3 -> 8

    return 8



 */