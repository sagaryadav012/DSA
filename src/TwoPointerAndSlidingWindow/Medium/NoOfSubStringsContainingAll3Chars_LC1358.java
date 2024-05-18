package TwoPointerAndSlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubStringsContainingAll3Chars_LC1358 {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
        System.out.println(numberOfSubstrings1(s));
    }

    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0, right = 0, count = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < n) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() == 3){
                count += n - right;
                char leftChar = s.charAt(left);
                int freq = map.get(leftChar);
                if(freq == 1) map.remove(leftChar);
                else map.put(leftChar, freq - 1);
                left++;
            }

            right++;
        }
        return count;
    }
    public static int numberOfSubstrings1(String s) {
        int n = s.length();
        int[] ar = {-1, -1, -1};
        int count = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            ar[c - 'a'] = i;
            if(ar[0] != -1 && ar[1] != -1 && ar[2] != -1){
                count += 1 + Math.min(ar[0], Math.min(ar[1], ar[2]));
            }
        }
        return count;
    }
}
/*
 Approach 1 :
 -> Generate all sub strings, check each sub string contains all three characters, if yes count += 1.
 -> TC - O(N^2) SC - O(1)

Approach 2 :
-> Two pointers technique, Take two pointer left = 0, right = 0. Move right pointer to right and store chars
    in map.
-> Check map.size() == 3 if yes take count, and move left pointer.
-> TC - O(N) SC - O(1)

Approach 3 :
-> Iterate over string, and store chars index. If all three chars are present then take min index.
-> Count = minIndex + 1;
-> TC - O(N) SC - O(1)

 */
