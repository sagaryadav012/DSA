package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_LC18 {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,2,-2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) { // TC - O(N^3) SC - O(1)
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n < 4) return res;

        Arrays.sort(nums);

        for(int i = 0; i < n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int j = i+1; j < n-2; j++){
                if(j != i+1 && nums[j-1] == nums[j]) continue;

                int k = j+1, l = n-1;
                while(k < l){
                    long sum = 1L - 1 + nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++; l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }

        return res;
    }
}
