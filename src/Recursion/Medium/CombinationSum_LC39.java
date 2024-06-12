package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_LC39 {
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum(candidates, target));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) { // TC - O(2^n) SC - O(res list)
        combos(0, target, candidates, new ArrayList<>());
        return res;
    }

    public static void combos(int index, int target, int[] candidates, List<Integer> combo){
        if(target == 0){
            res.add(new ArrayList<>(combo));
            return;
        }
        if(index == candidates.length) return;

        combos(index + 1, target, candidates, combo);
        if(candidates[index] <= target){
            combo.add(candidates[index]);
            combos(index, target - candidates[index], candidates, combo);
            combo.remove(combo.size() - 1);
        }
    }
}
