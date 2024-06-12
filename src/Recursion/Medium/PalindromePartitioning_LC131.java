package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_LC131 {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(partition(s));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> palindromes = new ArrayList<>();
        makePartition(res, palindromes, s, 0);
        return res;
    }
    public static void makePartition(List<List<String>> res, List<String> palindromes, String s, int index){
        if(index == s.length()){
            res.add(new ArrayList<>(palindromes));
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(!isPalindrome(s, index, i)) continue;
            palindromes.add(s.substring(index, i+1));
            makePartition(res, palindromes, s, i+1);
            palindromes.remove(palindromes.size() - 1);
        }
    }
    public static boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
