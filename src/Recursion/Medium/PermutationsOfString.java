package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(permute(str));
    }
    public static List<String> permute(String str) {
        int n = str.length();
        List<String> permutations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] isTaken = new boolean[n];
        permutationsList(permutations, sb,  isTaken, str, n);

        return permutations;
    }
    public static void permutationsList(List<String> permutations, StringBuilder sb, boolean[] isTaken, String str, int n){
        if(sb.length() == n){
            permutations.add(sb.toString());
            return;
        }
        for(int i = 0; i < n; i++){
            if(isTaken[i]) continue;

            isTaken[i] = true;
            sb.append(str.charAt(i));
            permutationsList(permutations, sb, isTaken, str, n);
            isTaken[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
