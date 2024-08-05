package Arrays.LeetCodeMSC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates_LC442 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < n){
            while(nums[i] != i+1 && nums[nums[i] - 1] != nums[i]){
                nums[i] = (nums[i] + nums[nums[i]-1]) - (nums[nums[i] - 1] = nums[i]);
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
        List<Integer> res = new ArrayList<>();

        int j = 0;
        for (int num : nums) {
            if (num != j + 1) {
                res.add(num);
            }
            j++;
        }
        return res;
    }
}
