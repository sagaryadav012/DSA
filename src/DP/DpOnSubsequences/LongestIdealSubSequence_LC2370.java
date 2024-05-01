package DP.DpOnSubsequences;

import java.util.Arrays;

public class LongestIdealSubSequence_LC2370 {
    public static void main(String[] args) {
        String s = "pvjcci";
        int k = 4;
        System.out.println(longestIdealString(s, k));
        System.out.println(lis3(s, k));
    }
    public static int longestIdealString(String s, int k) {
        int n = s.length();
        int prev = s.charAt(0)-'a';
//        return lis1(0, k, prev, s, n);
        int[][] dp = new int[n][27];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return lis2(0, k, '{', s, n, dp);
    }
    public static int lis1(int index, int k, int prev, String s, int n){
        if(index == n) return 0;

        int donTake = lis1(index + 1, k, prev, s, n);
        int take = 0;
        int ascii = s.charAt(index) - 'a';
        int absDif = Math.abs(ascii - prev);
        if(absDif <= k){
            take = lis1(index+1, k, ascii, s, n) + 1;
        }
        return Math.max(take, donTake);
    }
    public static int lis2(int index, int k, char prev, String s, int n, int[][] dp){
        if(index == n) return 0;

        if(dp[index][prev-'a'] != -1) return dp[index][prev-'a'];

        int donTake = lis2(index + 1, k, prev, s, n, dp);
        int take = 0;
        char curChar = s.charAt(index);
        int absDif = Math.abs(curChar - prev);
        if(prev == '{' || absDif <= k){
            take = lis2(index+1, k, curChar, s, n, dp) + 1;
        }
        return dp[index][prev-'a'] = Math.max(take, donTake);
    }
    public static int lis3(String s, int k){
        int n = s.length();
        int[][] dp = new int[n+1][26];

        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < 26; j++){
                int donTake = dp[i+1][j];
                int ascii = s.charAt(i) - 'a';
                int absDif = Math.abs(ascii - j);
                int take = 0;
                if(absDif <= k){
                    take = dp[i+1][ascii] + 1;
                }
                dp[i][j] = Math.max(take, donTake);
            }
        }
        return dp[0][0];
    }
}
