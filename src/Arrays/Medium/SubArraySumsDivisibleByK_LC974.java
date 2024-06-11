package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumsDivisibleByK_LC974 {
    public static void main(String[] args) {

    }
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int prefixSum = 0;
        for(int num : nums){
            prefixSum += num;
            int remainder = prefixSum % k;

            if(remainder < 0){
                remainder += k;
            }
            if(map.containsKey(remainder)){
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
/*

Approach 1 :
-> Generate all sub arrays, do sum, if sum%k == 0 then count += 1;
-> TC - O(N^3) SC - 0(1)

Approach 2 :
-> Use carry forward technique to do sum and check if sum % k == 0 then count += 1;
-> TC - O(N^2) SC - O(1)

Approach 3 :
step1 : do prefix sum.
step2 : mod each sum with k. Here num can be negative, so prefixSum can be -ve. -ve%k gives incorrect value.
        So once we do mod -ve value with k -> remainder ranges from 0 to -(k-1) -> Now add k to remainder then we get correct remainder.
        For example -8%5 give -3 but correct ans is 2. so -3+5 = 2.
step3 : Once we find mod, store mod value and count(freq) in hashMap to get count of sub arrays which sum equal to k.

    Example -> nums = [4,5,0,-2,-3,1], k = 5

    indexes     0       1       2       3       4       5
    nums        4       5       0       -2      -3      1
    pSum        4       9       9       7       4       5
    Mod(sum%k)  4       4       4       2       4       0

    Store all mods in map and their count to count subArrays.
    First store 0 and it's freq 1, since when we encounter 0, there is one sub array initially.

    Index       value       exist in map        countSubArrays          updatedMap
                                                0                       0 -> 1
    0           4           no                  0                       4 -> 1
    1           4           yes                 freq(4)+0 = 1           4 -> 2
    2           4           yes                 freq(4)+1 = 3           4 -> 3
    3           2           no                  3                       2 -> 1
    4           4           yes                 freq(4)+3 = 6           4 -> 4
    5           0           yes                 freq(0)+6 = 7           0 -> 2

    How we count subArrays ?
    For example when we reach index 4, Here value is 4 and its freq before this is 3.
    We know when we encounter same mod again then there is sub array with sum = k, But how many sub arrays?
    Freq till now is 3, that means there are 3 sub arrays those are :
    First occurrence of 4 is at index 0 -> then sub array 0+1 to current index 4 -> sub array[1,4] % k = 0
    Second occurrence of 4 is at index 1 -> then sub array 1+1 to current index 4 -> sub array[2,4] % k = 0
    Third occurrence of 4 is at index 2 -> then sub array 2+1 to current index 4 -> sub array[3,4] % k = 0
    Those are 3 sub arrays.

 */