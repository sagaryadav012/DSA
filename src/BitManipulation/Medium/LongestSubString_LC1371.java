package BitManipulation.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString_LC1371 {
    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        System.out.println(approach1(s));
        System.out.println(approach2(s));
        System.out.println(findTheLongestSubstring(s));
    }
    public static int approach1(String s){ // TC - O(N*N(N+5)) SC - O(1)
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isGoodSubString(i, j, s)){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
    public static boolean isGoodSubString(int i, int j, String s){
        Map<Character, Integer> map = new HashMap<>(); // Constant space since it takes 5 chars only
        for(int k = i; k <= j; k++){
            char c = s.charAt(k);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for(int freq : map.values()){
            if(freq % 2 != 0) return false;
        }
        return true;
    }
    public static int approach2(String s){ // TC - O(N*N*5) SC - O(1)
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> map;
        for(int i = 0; i < n; i++){
            map = new HashMap<>();
            for(int j = i; j < n; j++){
                char c = s.charAt(j);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }

                boolean flag = true;
                for (int freq : map.values()) {
                    if(freq % 2 != 0) flag = false;
                }
                if(flag) maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
    public static int findTheLongestSubstring(String s) { // TC - O(N) SC - O(1)
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int bitmask = 0;
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c == 'a'){
                bitmask ^= (1<<0);
            }
            else if(c == 'e'){
                bitmask ^= (1<<1);
            }
            else if(c == 'i'){
                bitmask ^= (1<<2);
            }
            else if(c == 'o'){
                bitmask ^= (1<<3);
            }
            else if(c == 'u'){
                bitmask ^= (1<<4);
            }

            if(map.containsKey(bitmask)){
                maxLen = Math.max(maxLen, i - map.get(bitmask));
            }
            else{
                map.put(bitmask, i);
            }
        }

        return maxLen;
    }
}
