package Arrays.Medium;

import java.util.HashMap;

public class TwoSum_LC1 {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[]{i, map.get(num)};
            }
            else{
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
