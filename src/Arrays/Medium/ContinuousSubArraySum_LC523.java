package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum_LC523 {
    public static void main(String[] args) {

    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            sum %= k;

            if(map.containsKey(sum)){
                if(i - map.get(sum) > 1) return true;
            }
            else{
                map.put(sum, i);
            }
        }
        return false;
    }
}
/*

Approach 1 :
-> Generate all sub arrays, do sum, if sum%k == 0 then return true;
-> TC - O(N^3) SC - 0(1)

Approach 2 :
-> Use carry forward technique to do sum and check if sum % k == 0 then return true;
-> When sum%k == 0,check size of sub array also. It should have at least 2 in size.
-> TC - O(N^2) SC - O(1)

Approach 3 :
-> We have to return true, If we find sub array with sum%k == 0 and size >= 2.
-> Iterate over array, do sum, and do mod of sum with k so that we reduce sum to 0 to k-1, greater than k
   sum helps to sum which is multiple of k.
-> Once we find mod values at every index, store mod and index of that mod.
-> If same mod value find in future then the sum between that index + 1 to current index is equal to multiple of k.
-> Mod value ranges from 0 to k-1 so if we find 0 that means their exist a multiple of k. so store 0
   in map initially.
-> When we encounter same mod then check size of sub array also.
-> TC - O(N) SC - O(N)

Test Cases :
[23,2,4,6,7], k = 6
[23,2,4,6,6], k = 7
[0], k = 1
[1,1,1,0], k = 5
[1,0], k = 2
[5,0,0,0], k = 3
 */