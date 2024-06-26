package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_LC39 {
    public static void main(String[] args) {
        int[] candidates = {1,2};
        int target = 4;
        System.out.println(combinationSum(candidates, target));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) { // TC - O(2^n) SC - O(res list)
        combos(0, target, candidates, new ArrayList<>());
        return res;
    }

    public static void combos(int index, int target, int[] candidates, List<Integer> combination){
        if(target == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        if(index == candidates.length) return;

        combos(index + 1, target, candidates, combination);
        if(candidates[index] <= target){
            combination.add(candidates[index]);
            combos(index, target - candidates[index], candidates, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
