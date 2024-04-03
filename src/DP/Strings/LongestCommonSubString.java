package DP.Strings;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String A = "abcd";
        String B = "bcabc";
        System.out.println(lcs(A, B));
    }
    public static int lcs(String A, String B){
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1];
        int maxLen = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }
}
/*
Approach 1 :
-> Generate all sub arrays of A and store them in set.
-> Generate all sub arrays of B and check set contains it, if yes take max len.
-> TC - O(N^3) SC - (N^2)

Approach 2 :
-> It is same like subsequence but here we need continuous portion(substring).
-> When chars are equal check previous chars are also same if yes i-1,j-1 + 1
-> TC - O(N^2) SC - (N^2) Space can be optimised to N+M
 */