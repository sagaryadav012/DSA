package Recursion.Easy;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubsetXORTotals_LC1863 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7,8};
        System.out.println(subsetXORSum(nums));
    }
    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsets(subsets, subset, nums, 0);

        int totalSum = 0;
        for (List<Integer> subsett : subsets) {
            int xor = 0;
            for (int num : subsett) {
                xor ^= num;
            }
            totalSum += xor;
        }
        return totalSum;
    }
    public static void subsets(List<List<Integer>> res, List<Integer> subset, int[] nums, int index){
        res.add(new ArrayList<>(subset));
        for(int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            subsets(res, subset, nums, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
