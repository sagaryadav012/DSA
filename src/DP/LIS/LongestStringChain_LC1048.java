package DP.LIS;

import java.util.Arrays;

public class LongestStringChain_LC1048 {
    public static void main(String[] args) {
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStrChain(words));
    }
    public static int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (wordA, wordB) -> wordA.length() - wordB.length());

        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        int maxLen = 1;
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
               if(isPredecessor(words[j], words[i]) && lis[i] < lis[j]+1){
                   lis[i] = lis[j] + 1;
               }
            }
            if(lis[i] > maxLen){
                maxLen = lis[i];
            }
        }
        return maxLen;
    }
    public static boolean isPredecessor(String wordA, String wordB){
        int n = wordA.length();
        int m = wordB.length();

        if(n + 1 != m) return false;
        int p1 = 0;
        int p2 = 0;

        while(p2 < m){
            if(p1 < n && wordA.charAt(p1) == wordB.charAt(p2)){ // why p1 < n ? dry run abc and abcd
                p1++;
                p2++;
            }
            else {
                p2++;
            }
        }

        return p1 == n;
    }
}

/*

Approach 1 :
-> Ex : "a","b","ba","bca","bda","bdca"
-> wordA is a predecessor of wordB if and only if we can insert exactly one letter
   anywhere in wordA without changing the order of the other characters to make it equal to wordB.
-> Observed that it is same as LIS, but here we need to check wordA is predecessor wordB.
-> When wordA is predecessor wordB ? WordB.size = wordA.size + 1 since we insert one and only one char in wordB
   And sequence should be same.
-> So sort array on strings length, so it is easy to compare and take count of LIS
-> Comparison of strings, wordB.size is +1 of wordA.size. So check take two pointers and check each char
   of wordA and wordB, if chars not equal that means that is the char inserted so move pointer of wordB to +1.
   If two pointer exhausted it means same strings else not same;
 */