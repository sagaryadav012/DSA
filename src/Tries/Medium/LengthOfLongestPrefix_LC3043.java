package Tries.Medium;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestPrefix_LC3043 {
    static Trie root;
    public static void main(String[] args) {
        int[] arr1 = {1248,364524,73264823,2937935};
        int[] arr2 = {73249,94895,656324,239583,1249};
        System.out.println(longestCommonPrefix1(arr1, arr2));
        System.out.println(longestCommonPrefix2(arr1, arr2));
    }
    public static int longestCommonPrefix1(int[] arr1, int[] arr2) {
        root = new Trie();
        for(int num : arr1){
            Trie curr = root;
            for(char c : String.valueOf(num).toCharArray()){
                if(curr.children[c - '0'] == null){
                    curr.children[c - '0'] = new Trie();
                }
                curr = curr.children[c - '0'];
            }
        }

        int curLen = 0;
        int ans = 0;

        for(int num : arr2){
            Trie curr = root;
            for (char c : String.valueOf(num).toCharArray()) {
                if(curr.children[c - '0'] == null) break;
                curr = curr.children[c - '0'];
                curLen += 1;
            }
            ans = Math.max(curLen, ans);
            curLen = 0;
        }

        return ans;
    }
    static class Trie{
        Trie[] children = new Trie[10];
        Trie(){}
    }


    public static int longestCommonPrefix2(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = storeAllPrefixes(arr1);

        int longestPrefixLen = 0;
        for(int num : arr2){
            while(num > 0){
                if(prefixes.contains(num)){
                    int len = findLen(num);
                    longestPrefixLen = Math.max(longestPrefixLen, len);
                    break;
                }
                num /= 10;
            }
        }

        return longestPrefixLen;
    }
    public static Set<Integer> storeAllPrefixes(int[] arr1){
        Set<Integer> prefixes = new HashSet<>();
        for(int num : arr1){
            while(num > 0){
                prefixes.add(num);
                num /= 10;
            }
        }
        return prefixes;
    }
    public static int findLen(int num){
        int len = 0;
        while(num > 0){
            len += 1;
            num /= 10;
        }
        return len;
    }
}

/*
Approach 1 :
-> Use Trie data structure to store all prefixes of each num in arr1.
-> Now find the longest common prefix of each num in arr2.

Approach 2 :
-> Use hashset to store all prefixes of each num in arr1.
-> Now check each prefix of num in arr2 in set, If prefix exists in set then take len of prefix.
 */