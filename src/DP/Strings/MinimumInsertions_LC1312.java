package DP.Strings;

public class MinimumInsertions_LC1312 {
    public static void main(String[] args) {
        String s = "abcaa";
        System.out.println(minInsertions(s));
    }
    public static int minInsertions(String s) {
        int n = s.length();
        return n - longestPalindromeSubseq(s);
    }
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        String r = new StringBuilder(s).reverse().toString();

        char[] sC = s.toCharArray();
        char[] rC = r.toCharArray();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(sC[i-1] == rC[j-1]){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
            curr = new int[n+1];
        }
        return prev[n];
    }
}
/*
-> We need to find minimum insertions to make string palindrome.
-> One of the way is, attach reverse of string to string so that it will be palindrome.
    Ex : abcaa
    reverse of abcaa is aacba, now attach it to string and check it is palindrome or not.
    abcaa + aacba = abcaaaacba -> It is palindrome, so no.of insertions are len of string.

-> Other way is, Find the longest palindrome subsequence, keep them as it is, and insert chars which are required
   to make string palindrome.
   EX : abcaa
   Longest palindrome subsequence = aaa
   Now aaa is the longest palindrome, bc left so insert bc to make palindrome.
   -> abcabca, is it palindrome now? answer is no.
   -> insert reverse of bc at suitable place to make palindrome.
   -> abcacba, now it is palindrome.
-> Why do we need to find the longest palindrome subsequence, because we need min insertions, so find the longest
   palindrome subsequence and insert remaining chars to make palindrome.

-> so answer = n - longest palindrome subsequence.


 */
