package DP.Strings;

import java.util.Arrays;

public class DeleteOperations_LC583 {
    public static void main(String[] args) {
        String word1 = "people";
        String word2 = "apple";
        System.out.println(minDistance(word1, word2));
    }
    public static int minDistance(String word1, String word2) {
        int commonLen = longestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - 2 * commonLen;
    }
    public static int longestCommonSubsequence(String text1, String text2) {
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
//        System.out.println(Arrays.toString(prev));
        return prev[m];
    }
}
/*
-> First find the longest common subsequence of two strings.
-> We find the longest common character from both strings, so we need to delete remaining character from both strings
   to make both strings are equal.
-> len(word1) + len(word2) - 2*the longest common subsequence;
 */
