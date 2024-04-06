package DP.Strings;

import java.util.Arrays;

public class WildCardMatching_LC44 {
    public static void main(String[] args) {
        String s = "bcaccbabaa";
        String p = "bb*c?c*?";
        int n = s.length();
        int m = p.length();

        System.out.println(isMatch1(n-1, m-1, s, p));
        int[][] dp = new int[n+1][m+1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(isMatch2(n-1, m-1, s, p, dp));
        System.out.println(isMatch3(s, p));
    }
    public static boolean isMatch1(int i, int j, String s, String p) {
        // when p exhausted and chars in s still left means they are not matching.
        if(i >= 0 && j < 0) return false;
        // when s exhausted and chars in p still left, check all are start if all are stars they can match with empty so return true;
        if(i < 0 && j >= 0) return checkAllAreStars(p, j);
        // when p and s are exhausted means both are matching.
        if(i < 0 && j < 0) return true;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return isMatch1(i-1, j-1, s, p);
        }
        if(p.charAt(j) == '*'){
            return isMatch1(i, j-1, s, p) | isMatch1(i-1, j, s, p);
        }
        return false; // when both chars are not equal and char at p != * and ?
    }
    public static boolean isMatch2(int i, int j, String s, String p, int[][] dp) {
        // when p exhausted and chars in s still left means they are not matching.
        if(i >= 0 && j < 0) return false;
        // when s exhausted and chars in p still left, check all are start if all are stars they can match with empty so return true;
        if(i < 0 && j >= 0) return checkAllAreStars(p, j);
        // when p and s are exhausted means both are matching.
        if(i < 0 && j < 0) return true;

        if(dp[i][j] != -1) return dp[i][j] == 1;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            dp[i][j] = isMatch2(i-1, j-1, s, p, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }
        if(p.charAt(j) == '*'){
            dp[i][j] = (isMatch2(i, j-1, s, p, dp) | isMatch2(i-1, j, s, p, dp)) ? 1 : 0;
            return dp[i][j] == 1;
        }
        dp[i][j] = 0;
        return false; // when both chars are not equal and char at p != * and ?
    }
    public static boolean checkAllAreStars(String p, int j){
        while(j >= 0){
            if(p.charAt(j) != '*') return false;
            j--;
        }
        return true;
    }
    public static boolean isMatch3(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] prev = new boolean[m+1];
        prev[0] = true;
        for(int c = 1; c <= m; c++){
            if(p.charAt(c-1) == '*') prev[c] = true;
            else break; // if previous char are not stars let them as it is false.
        }
        boolean[] curr = new boolean[m+1];
        char[] sC = s.toCharArray();
        char[] pC = p.toCharArray();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(sC[i-1] == pC[j-1] || pC[j-1] == '?'){
                    curr[j] = prev[j-1];
                }
                else if(pC[j-1] == '*'){
                    curr[j] = curr[j-1] | prev[j];
                }
            }
            prev = curr;
            curr = new boolean[m+1];
        }
        return prev[m];
    }
}
/*

-> There could 3 cases :
-> Case 1 : both chars are equal, so check remaining portion of s and p. f(i-1, j-1).
-> Case 2 : char of p can be ?, so it matches with one character. so check remaining portion of s and p. f(i-1, j-1).
-> Case 3 : char of p can be *, * can be match with empty or 1 or more characters. so here two possibilities,
            assume * match with empty f(i, j-1) or * match with one char f(i-1, j) if any one is return true, then
            return true;

 */
