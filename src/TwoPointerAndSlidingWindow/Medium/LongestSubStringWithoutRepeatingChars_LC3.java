package TwoPointerAndSlidingWindow.Medium;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChars_LC3 {
    public static void main(String[] args) {

    }
    public static int lengthOfLongestSubstring1(String s) { // TC - O(N) SC - O(N)
        int n = s.length();
        if(n == 0) return 0;
        HashSet<Character> set = new HashSet<Character>();

        int left = 0, right = 0;
        int maxLen = 0;
        while(right < n){
            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
    public static int lengthOfLongestSubstring2(String s) { // TC - O(N) SC - O(N)
        int n = s.length();
        if(n == 0) return 0;
        HashSet<Character> set = new HashSet<Character>();

        int left = 0, right = 0;
        int maxLen = 0;
        while(right < n){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            right++;
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}
