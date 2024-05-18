package TwoPointerAndSlidingWindow.Hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString_LC76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        int n = s.length();
        if(n < t.length()) return "";

        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> mapS = new HashMap<>();
        int left = 0, right = 0, count = 0;
        int minLen = n + 1;
        int start = -1;
        while(right < n){
            char c = s.charAt(right);
            if(mapT.containsKey(c)){
                mapS.put(c, mapS.getOrDefault(c, 0) + 1);
                if(mapS.get(c) <= mapT.get(c)) count += 1;
            }
            while(count == t.length()){
                int len = right - left + 1;
                if (minLen > len) {
                    minLen = len;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if(mapS.containsKey(leftChar)){
                    if(mapS.get(leftChar) <= mapT.get(leftChar)) count -= 1;
                    mapS.put(leftChar, mapS.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }
        return start == -1 ? "" : s.substring(start, start+minLen);
    }
}
