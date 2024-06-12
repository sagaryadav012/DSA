package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_LC40 {
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        System.out.println(combinationSum(candidates, target));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) { // TC - O(2^n) SC - O(res list)
        Arrays.sort(candidates);
        combos(0, target, candidates, new ArrayList<>());
        return res;
    }

    public static void combos(int index, int target, int[] candidates, List<Integer> combo){
        if(target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target) return;
            combo.add(candidates[i]);
            combos(i+1, target - candidates[i], candidates, combo);
            combo.remove(combo.size() - 1);
        }
    }
}
