package TwoPointerAndSlidingWindow.Medium;

public class CountNiceSubArrays_LC1248 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,2};
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
        System.out.println(numberOfSubarrays1(nums, k));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        return findSubArrays(nums, k) - findSubArrays(nums, k-1);
    }
    public static int findSubArrays(int[] nums, int k){
        int n = nums.length;
        int left = 0, right = 0, subArraysCount = 0, oddCount = 0;

        while(right < n){
            if(nums[right] % 2 != 0) oddCount += 1;

            while(oddCount > k){
                if(nums[left] % 2 != 0) oddCount -= 1;
                left++;
            }

            subArraysCount += right - left + 1;
            right++;
        }
        return subArraysCount;
    }
    public static int numberOfSubarrays1(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, odds = 0, result = 0, subArrays = 0;

        while(right < n){
            if(nums[right] % 2 != 0){
                odds += 1;
                subArrays = 0;
            }

            while(odds == k){
                subArrays += 1;
                if(nums[left] % 2 != 0){
                    odds -= 1;
                }
                left++;
            }
            result += subArrays;
            right++;
        }
        return result;
    }
}
/*
-> This is same as Binary sub arrays with sum LeetCode 930.

Approach 1 :
-> Generate all sub arrays, take each sub array and count odds, if odds == k then count += 1.
-> TC - O(N^2) SC - O(1)

Approach 2 : Two pointers
-> It is not possible to calculate sub arrays with exactly k odd numbers we may miss some sub arrays.
-> So First calculate sub arrays with odds <= k, then find sub arrays with odds <= k - 1.
-> sub arrays with odds == k  -> (sub arrays with odds <= k) - (sub arrays with odds <= k - 1).
-> TC - O(2 * 2n) SC - O(1)

Approach 3 :
-> Take two pointers, move right pointer to right till get k odds.
-> Once we got the window where odds = k, move left pointer to right and take sub arrays count while moving, and add to result.
-> For example 2,2,1,1,2 and k = 2
   Here window 2,2,1,1 has odds = k. now count sub arrays while moving left pointer to right.
        subArray        isValid         count
        2,2,1,1         yes             +1
        2,1,1           yes             +1
        1,1             yes             +1
        1               No
        Here total sub arrays count = 3.
    next value is 2, which is not odd, so it also contribute to previous count.
    For example, we got 3 valid sub arrays last, now 2 is not odd so still odd count = k. so add this 2 previous sub arrays.

    2,2,1,1,2
    2,1,1,2
    1,1,2

    Again  count += 3
    Until we get odd, add last sub arrays count to result. for example 2,2,1,1 for this we get 3 sub arrays, If
    next element is 1 then odd count will increase, so make sub arrays count = 0.

    Dry run this example nums {1,2,2,1,1,2} k = 2

Approach 4 :
-> Take prefix odd array of given array, Now the problem boils down to sub array sum equal to k.
   For example  nums {4,1,3,8,7,6,3,7} k = 2
   nums                 4       1       3       8       7       6       3       7
   Prefix odd array ->  0       1       2       2       3       3       4       5

   First store key-0, value 1 in map since when we encounter 2 means sub array has odd numbers the count will be 1.
   Iterate over array, check x - k exists in map, if yes result += freq of(x-k). store new val freq.
-> TC - O(N) SC - O(N)
 */
