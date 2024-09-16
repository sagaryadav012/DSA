package DP.Strings;

import java.util.Arrays;

public class LongestPalindromicSubsequence_LC516 {
    public static void main(String[] args) {
        String str = "abxybayx";
        System.out.println(longestPalindromeSubseq(str));
    }
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        String r = new StringBuilder(s).reverse().toString();

        char[] sC = s.toCharArray();
        char[] rC = r.toCharArray();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(sC[i-1] == rC[j-1]){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
            curr = new int[n+1];
        }
        return prev[n];
    }
}
