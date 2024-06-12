package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetSums_GFG {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,3));
        int n = 2;
        System.out.println(subsetSums(arr, n));
    }
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) { // TC - O(2^n) SC - O(2^n)
        subsets(0, 0, arr);
        return res;
    }
    static ArrayList<Integer> res = new ArrayList<>();
    public static void subsets(int index, int sum, ArrayList<Integer> arr){
        res.add(sum);
        for(int i= index; i < arr.size(); i++){
            sum += arr.get(i);
            subsets(i+1, sum, arr);
            sum -= arr.get(i);
        }
    }
}
