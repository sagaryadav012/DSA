package DP.Strings;

import java.util.Arrays;

public class LongestCommonSubsequence_LC1143 {
    public static void main(String[] args) {
        String text1 = "abcxyzaxybadgadu";
        String text2 = "abbaxysaduwza";
        int n = text1.length();
        int m = text2.length();
//        System.out.println(longestCommonSubsequence1(text1, text2, n-1, m-1));

        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }

//        System.out.println(longestCommonSubsequence2(text1, text2, n-1, m-1, dp));
        System.out.println(longestCommonSubsequence3(text1, text2));
//        System.out.println(longestCommonSubsequence4(text1, text2)); // Solution is not working
    }

    // TC - O(2^N) SC - O(N + stack space)
    public static int longestCommonSubsequence1(String text1, String text2, int i, int j) {
        if(i < 0 || j < 0) return 0;
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + longestCommonSubsequence1(text1, text2, i-1, j-1);
        }
        else{
            return Math.max(longestCommonSubsequence1(text1, text2, i-1, j), longestCommonSubsequence1(text1, text2, i, j-1));
        }
    }

    // TC - O(N * M) SC - O(N * M + stack space)
    public static int longestCommonSubsequence2(String text1, String text2, int n, int m, int[][] dp) {
        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(text1.charAt(n) == text2.charAt(m)){
            return dp[n][m] = 1 + longestCommonSubsequence1(text1, text2, n-1, m-1);
        }
        else{
            return dp[n][m] = Math.max(longestCommonSubsequence1(text1, text2, n-1, m), longestCommonSubsequence1(text1, text2, n, m-1));
        }
    }

    // TC - O(N * M) SC - O(M + M)
    public static int longestCommonSubsequence3(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(t1[i-1] == t2[j-1]){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
//            System.out.println(Arrays.toString(curr));
            prev = curr;
            curr = new int[m+1];
        }
         System.out.println(Arrays.toString(prev));
        return prev[m];
    }

    // TC - O(N * M) SC - O(M)
    public static int longestCommonSubsequence4(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[j] = 1 + dp[j-1];
                }
                else{
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(Arrays.toString(dp));
        return dp[m];
    }
}

/*
Approach 4 will not work at space optimisation, because if chars are equal we access i-1,j-1 state but it can be
changed, this approach will work when we access i-1,j or i,j-1.
 */