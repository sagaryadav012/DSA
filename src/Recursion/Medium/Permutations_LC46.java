package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations_LC46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] isTaken = new boolean[n];
//        permutationsList1(permutations, isTaken, nums, permutation, n);
        permutationList2(permutations, 0, nums, n);

        return permutations;
    }
    public static void permutationsList1(List<List<Integer>> permutations, boolean[] isTaken, int[] nums, List<Integer> permutation, int n){
        if(permutation.size() == n){
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for(int i = 0; i < n; i++){
            if(isTaken[i]) continue;

            isTaken[i] = true;
            permutation.add(nums[i]);
            permutationsList1(permutations, isTaken, nums, permutation, n);
            isTaken[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void permutationList2(List<List<Integer>> permutations, int index, int[] nums, int n){
        if(index == n){
            List<Integer> permutation = new ArrayList<>();
            for(int i = 0; i < n; i++){
                permutation.add(nums[i]);
            }
            permutations.add(new ArrayList<>(permutation));
        }
        for(int i = index; i < n; i++){
            swap(i, index, nums);
            permutationList2(permutations, index + 1, nums, n);
            swap(i, index, nums);
        }
    }
    public static void swap(int i, int j, int[] nums){
        nums[j] = (nums[i] + nums[j]) - (nums[i] = nums[j]);
    }
}
