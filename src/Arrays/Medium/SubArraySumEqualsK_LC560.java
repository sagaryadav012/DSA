package Arrays.Medium;

import java.util.HashMap;

public class SubArraySumEqualsK_LC560 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,-3,1,1,1};
        int k = 3;
        System.out.println(ap1(nums, k));
        System.out.println(ap2(nums, k));
        System.out.println(ap3(nums, k));
    }
    // TC - O(N^3) SC - O(1)
    public static int ap1(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                for(int p = i; p <= j; p++){
                    sum += nums[p];
                }
                if(sum == k) count += 1;
            }
        }
        return count;
    }

    // Carry forward :  TC - O(N^2) SC - O(1)
    public static int ap2(int[] nums, int k){
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == k) count += 1;
            }
        }
        return count;
    }

    // Carry forward :  TC - O(N) SC - O(N)
    public static int ap3(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int prefixSum = 0;
        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            int diff = prefixSum - k;
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

/*
Approach 1 :
-> Generate all sub array and check their sum. if sum equals to k then increment count.

Approach 2 :
-> Use carry forward technique to avoid one loop.

Approach 3 :
-> Take help of prefixSum. for example, we are at 4th index and sum till upto that index is 8.
-> But we have to find k sum, if there is a sum array sum equals to 8-k and if remove that sub array from current
   sub array we get sub array sum equals to k.
-> So at each step, cal prefixSum(sub array sum) and store in hashmap so that we can track freq also.
-> For example we got prefixSum 6, k is 3. check if we got 6-3 = 3 earlier if there are two sub array of sum = 3
   then we can form 2 sub arrays.

   dry run this example : 1 2 3 -3 1 1 1  k = 3
 */