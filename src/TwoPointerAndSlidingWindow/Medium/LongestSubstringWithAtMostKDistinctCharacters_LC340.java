package TwoPointerAndSlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters_LC340 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        System.out.println(longestSubString(s, k));
    }
    public static int longestSubString(String s, int k){ // TC - O(N) SC - O(K)
        int n = s.length();
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        while(r < n){
            char rightChar = s.charAt(r);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() > k){
               char leftChar = s.charAt(l);
               int freq = map.get(leftChar);
               if(freq == 1) map.remove(leftChar);
               else map.put(leftChar, freq - 1);
               l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
