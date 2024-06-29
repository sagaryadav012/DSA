package DP.Strings;

import java.util.Arrays;

public class PalindromePartitioning2_LC132 {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(minCut(s) - 1);
        System.out.println(approach3(s)); // approach 3 output
    }
    public static int minCut(String s){
        int n = s.length();
        int cuts1 = approach1(0, n, s);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(approach2(0, n, s, dp) - 1); // approach 2 output
        
        return cuts1; // approach 1 output
    }
    public static int approach1(int i, int n, String s){
        if(i == n) return 0;

        int minCuts = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
            if(isPalindrome(i, j, s)){
                int cuts = 1 + approach1(j+1, n, s);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        return minCuts;
    }

    // Memoization(Bottom-Up Approach) : TC - O(n^2) SC - O(n) + O(n) stack space
    public static int approach2(int i, int n, String s, int[] dp){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];

        int minCuts = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
            if(isPalindrome(i, j, s)){
                int cuts = 1 + approach1(j+1, n, s);
                minCuts = Math.min(minCuts, cuts);
            }
        }

        return dp[i] = minCuts;
    }

    // Tabulation(Top-Down Approach) : TC - O(n^2) SC - O(n)
    public static int approach3(String s){
        int n = s.length();
        int[] dp = new int[n+1]; // since i goes from 0 to n
        dp[n] = 0; // base case

        for(int i = n-1; i >= 0; i--){
            int minCuts = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                if(isPalindrome(i, j, s)) {
                    int cuts = 1 + dp[j + 1];
                    minCuts = Math.min(cuts, minCuts);
                }
            }
            dp[i] = minCuts;
        }
        return dp[0] - 1; // Here 1 is to remove extra cut.
    }
    public static boolean isPalindrome(int start, int end, String s){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
