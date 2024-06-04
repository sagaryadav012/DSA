package DP.Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak1_LC139 {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");
        System.out.println(wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
         Set<String> set = new HashSet<>(wordDict);
         boolean[] dp = new boolean[s.length()];
//         Arrays.fill(dp, -1);
         System.out.println(dfs(0, s, set, dp));
         return dfs(0, s, set);
    }
    public static boolean dfs(int index, String s, Set<String> set){
        if(index == s.length()) return true;

        for(int i = index; i < s.length(); i++){
            String substring = s.substring(index, i + 1);
            if(set.contains(substring)){
                return dfs(i + 1, s, set);
            }
        }
        return false;
    }
    public static boolean dfs(int index, String s, Set<String> set, boolean[] dp){
        if(index == s.length()) return true;

        if(dp[index]) return dp[index];

        for(int i = index; i < s.length(); i++){
            String substring = s.substring(index, i + 1);
            if(set.contains(substring)){
                dp[index] = dfs(i + 1, s, set, dp);
            }
        }
        return dp[index] = false;
    }
}
