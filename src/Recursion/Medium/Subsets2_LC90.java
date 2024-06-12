package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2_LC90 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) { // TC - O(2^n) SC - O(res list)
        Arrays.sort(nums);
        generateSubSets(nums, 0, new ArrayList<Integer>());
        return res;
    }
    public static void generateSubSets(int[] nums, int start, ArrayList<Integer> subSet){
        res.add(new ArrayList<>(subSet));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            subSet.add(nums[i]);
            generateSubSets(nums, i+1, subSet);
            subSet.remove(subSet.size()-1);
        }
    }
}
