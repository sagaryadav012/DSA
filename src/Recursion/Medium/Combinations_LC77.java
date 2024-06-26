package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations_LC77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        System.out.println(combine(n, k));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        generate(res, combo, 1, n, k);
        return res;
    }
    public static void generate(List<List<Integer>> res, List<Integer> combo, int num, int n, int k){
        if(combo.size() == k){
            res.add(new ArrayList<>(combo));
            return;
        }

        for(int i = num; i <= n; i++){
            combo.add(i);
            generate(res, combo, i+1, n, k);
            combo.remove(combo.size() - 1);
        }
    }
}
