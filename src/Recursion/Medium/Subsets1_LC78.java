package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets1_LC78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) { // TC - O(2^n) SC - O(res list)
        List<List<Integer>> res = new ArrayList<>();
        generate(res, new ArrayList<>(), 0, nums);
        return res;
    }
    public static void generate(List<List<Integer>> res, ArrayList<Integer> subSet, int start, int nums[]){
        res.add(new ArrayList<>(subSet));
        for(int i = start; i < nums.length; i++){
            subSet.add(nums[i]);
            generate(res, subSet, i+1, nums);
            subSet.remove(subSet.size()-1);
        }
    }
}
