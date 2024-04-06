package DP.Strings;

import java.util.Arrays;

public class EditDistance_LC72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int n = word1.length();
        int m = word2.length();

        System.out.println(minDistance1(n-1, m-1, word1, word2));

        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(minDistance2(n-1, m-1, word1, word2, dp));
        System.out.println(minDistance3(word1, word2));
    }
    // Recursive Code : TC - O(3^N) SC - O(N + M)
    public static int minDistance1(int i, int j, String word1, String word2) {
        // when word1 exhausted and nothing is left to check. now we can insert all chars of word2. j+1 operations.
        if(i < 0 && j >= 0) return j+1;
        // when word2 exhausted and nothing is left to check. now we can delete all chars of word1. i+1 operations.
        if(i >= 0 && j < 0) return i+1;
        if(i < 0 && j < 0) return 0;

        if(word1.charAt(i) == word2.charAt(j)){
            // when chars are equal.
            return minDistance1(i-1, j-1, word1, word2);
        }
        else{
            // when chars are not equal, try all possibilities.
            int insert = minDistance1(i, j-1, word1, word2) + 1;
            int delete = minDistance1(i-1, j, word1, word2) + 1;
            int replace = minDistance1(i-1, j-1, word1, word2) + 1;
            return Math.min(insert, Math.min(delete, replace));
        }
    }
    // Recursive Code DP(Top - Down Approach -> Memoization) : TC - O(N * M) SC - O(N * M + stackSpace)
    public static int minDistance2(int i, int j, String word1, String word2, int[][] dp) {
        // when word1 exhausted and nothing is left to check. now we can insert all chars of word2. j+1 operations.
        if(i < 0 && j >= 0) return j+1;
        // when word2 exhausted and nothing is left to check. now we can delete all chars of word1. i+1 operations.
        if(i >= 0 && j < 0) return i+1;
        if(i < 0 && j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            // when chars are equal.
            return dp[i][j] = minDistance2(i-1, j-1, word1, word2, dp);
        }
        else{
            // when chars are not equal, try all possibilities.
            int insert = minDistance2(i, j-1, word1, word2, dp) + 1;
            int delete = minDistance2(i-1, j, word1, word2, dp) + 1;
            int replace = minDistance2(i-1, j-1, word1, word2, dp) + 1;
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
    // Iterative Code(Bottom - Up Approach - Tabulation) : TC - O(N * M) SC - O(M + M);
    public static int minDistance3(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m+1];
        for(int i = 0; i <= m; i++) prev[i] = i;

        int[] curr = new int[m+1];

        char[] word1C = word1.toCharArray();
        char[] word2C = word2.toCharArray();

        for(int i = 1; i <= n; i++){
            curr[0] = i;
            for(int j = 1; j <= m; j++){
                if(word1C[i-1] == word2C[j-1]){
                    curr[j] = prev[j-1];
                }
                else{
                    int insert = 1 + curr[j-1];
                    int del = 1 + prev[j];
                    int replace = 1 + prev[j-1];
                    curr[j] = Math.min(insert, Math.min(del, replace));
                }
            }
            prev = curr;
            curr = new int[m+1];
        }
        return prev[m];
    }
}

/*

To understand recursion tree -> Dry run A = "abc", B = "ac" and A = "ac", B ="abc"
 iterativeCode : Dry run below example
 A = "abcgx" B = "acdxy"
 since i and j goes from -1 to n-1 and -1 to n-1 respectively, Take cache size n+1, m+1

         ""  a   c   d   x   y
         0   1   2   3   4   5
   "" 0  0   1   2   3   4   5
   a  1  1   0   1   2   3   4
   b  2  2   1   1   2   3   4
   c  3  3   2   1   2   3   4
   g  4  4   3   2   2   3   4
   x  5  5   4   3   3   2   3

 */