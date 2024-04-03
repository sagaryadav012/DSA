package DP.Strings;

import java.util.Arrays;

public class ShortestCommonSuperSequence_LC1092 {
    public static void main(String[] args) {
        String str1 = "bbabacaa";
        String str2 = "cccababab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i -= 1; j -= 1;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i -= 1;
            }
            else{
                sb.append(str2.charAt(j-1));
                j -= 1;
            }
        }
        while(i > 0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j > 0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}
/*
-> We need to find the shortest string, so that two strings are subsequence of shortest string.
-> One of the possible way is combined both strings.
-> Take out the longest common subsequence of both strings. Now we need to add other characters from both strings
   to the shortest one and add common characters only once.

   Ex : s1 = bleed and s2 = blue -> LCS = ble
   chars of s1 except common chars are "ed" and from s2 is u.
   Now the shortest common string length would be = len(s1) + len(s2) - len(LCS)

   But we need to find string not length.

-> We can generate string with help of dp table of LCS

                0       b       l       e       e       d
        0       0       0       0       0       0       0
        b       0       1       1       1       1       1
        l       0       1       2       2       2       2
        u       0       1       2       2       2       2
        e       0       1       2       3       3       3

-> Generate string :
    -> first put pointer to n-1,m-1
    -> if(s1[i-1] == s2[j-1]) then add char to ans string.
    -> else move to max((i-1),j), i,(j-1)) and add char to which one is min of both.
    -> that means when chars are not equal we move to max LCS, and left min LCS so add min LCS to string.

TestCases :
apple
people

bleed
blue

brute
groot

 */
