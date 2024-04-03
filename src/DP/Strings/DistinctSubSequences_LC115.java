package DP.Strings;

import java.util.Arrays;

public class DistinctSubSequences_LC115 {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        int n = s.length();
        int m = t.length();
        System.out.println(numDistinct1(n-1, m-1, s, t));

        int[][] dp = new int[n+1][m+1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(numDistinct2(n-1, m-1, s, t, dp));
        System.out.println(numDistinct3(s, t));
        System.out.println(numDistinct4(s, t));
    }

    // TC - O(2^n) SC - O(N + stackSpace)
    public static int numDistinct1(int i, int j, String s, String t) {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(s.charAt(i) == t.charAt(j)){
            return numDistinct1(i-1, j, s, t) + numDistinct1(i-1, j-1, s, t);
        }
        else{
            return numDistinct1(i-1, j, s, t);
        }
    }

    // TC - O(N*M) SC - O(N*M + stackSpace)
    public static int numDistinct2(int i, int j, String s, String t, int[][] dp) {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = numDistinct2(i-1, j, s, t,dp) + numDistinct2(i-1, j-1, s, t,dp);
        }
        else{
            return dp[i][j] = numDistinct2(i-1, j, s, t,dp);
        }
    }

    // TC - O(N*M) SC - O(N*M)
    public static int numDistinct3(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }
        return dp[n][m];
    }

    // TC - O(N*M) SC - O(M+M)
    public static int numDistinct4(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) return 0;
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        prev[0] = curr[0] = 1;

        for(int r = 1; r <= n; r++){
            for(int c = 1; c <= m; c++){
                if(s.charAt(r - 1) == t.charAt(c - 1))
                    curr[c] = prev[c - 1] + prev[c];
                else curr[c] = prev[c];
            }
            prev = curr;
            curr = new int[m+1];
            curr[0] = 1;
        }
        return prev[m];
    }
}
/*
-> Example s1 = babgbag and s2 = bag
-> We need to find how many times s2 occurs in s1.
-> Try all possible ways, all possible ways means recursion.
-> To write recursion, write parameters that need to pass, here parameters are i,j and i points to s1.length()-1
   j points to s2.length()-1
-> Now explore all possible ways, func(i,j) states that check no.of occurrences of s2(0 to j) in s1(0 to i)
-> Now check i and j are equal, if they equal check s2(0 to j-1) in s1(0 to i-1). it means we are checking one
   occurrence, but there could be possible that s1 can have another occurrence of s2 so take that one also,
   How can we take that call func(i-1, j) means keep j pointer to same index and reduce i pointer by one that states
   that check s2(0 to j) in s1(o to i-1).
-> So when chars are equal return f(i-1,j-1) + f(i-1,j)
-> Second case when chars are not equal?  when chars are not equal check s2 in s1(0 to i-1) portion.
-> Now base case, what could be the base case? s2 has exhausted but s1 is left that means s2 is existed in s1 so
   return 1, another case s1 has exhausted s2 is left, it means there is no occurrence of s2 in s1 so return 0;

 */
