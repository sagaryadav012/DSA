package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_LC15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    List<Integer> pair = Arrays.asList(nums[i], nums[j], nums[k]);
                    res.add(pair);

                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }
                else if(sum < 0) j++;
                else k--;
            }
        }

        return res;
    }
}
