package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetGen {
    public static void main(String[] args) {
        int[] nums = {5,1,6};
        System.out.println(subSet(nums));
    }
    public static List<List<Integer>> subSet(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subSetGen(res, subset, 0, nums, 0);
        System.out.println(getTotal);
        return res;
    }
    static int total = 0;
    static int getTotal = 0;
    public static void subSetGen(List<List<Integer>> res, List<Integer> subset, int index, int[] nums, int xor){
        res.add(new ArrayList<>(subset));
        for(int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            subSetGen(res, subset, i+1, nums, xor);
            subset.remove(subset.size() - 1);
        }
    }

}
