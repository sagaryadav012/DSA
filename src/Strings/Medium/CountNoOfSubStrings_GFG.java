package Strings.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountNoOfSubStrings_GFG {
    public static void main(String[] args) {
        String s = "aba";
        int k = 2;
        System.out.println(substrCount(s, k));
        System.out.println(substrCount1(s, k));
    }
    public static long substrCount (String S, int K) { // TC - O(N^2) SC - O(26)
        long count = 0;
        Set<Character> set;
        int n = S.length();
        for(int i = 0; i < n; i++){
            set = new HashSet<>();
            for(int j = i; j < n; j++){
                set.add(S.charAt(j));
                if(set.size() == K) count += 1;
                if(set.size() > K) break;
            }
        }
        return count;
    }
    public static long substrCount1 (String S, int K) { // TC - O(2N + 2N) SC - O(26)
        long countK = countSubStrings(S, K);
        long countK1 = countSubStrings(S, K-1);
        return countK - countK1;
    }
    public static long countSubStrings(String s, int k){
        int i = 0, j = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        long count = 0;
        while(j < n) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(i);
                int freq = map.get(leftChar);
                if (freq == 1) map.remove(leftChar);
                else map.put(leftChar, freq - 1);
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}
/*
Test Case "abac" k = 2 // dry run this, so you will know why can't find substring with k distinct chars with two pointers

 */