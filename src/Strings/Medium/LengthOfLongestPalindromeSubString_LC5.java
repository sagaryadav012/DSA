package Strings.Medium;

public class LengthOfLongestPalindromeSubString_LC5 {
    public static void main(String[] args) {
        String s = "xbdyzzydbdyz";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;

        char[] chars = s.toCharArray();

        int start = -1, end = -1;

        int p1 = 0, p2 = 0;
        int maxLen = 0;
        // Odd len palindrome substring
        for(int i = 0; i < n; i++){
            p1 = i; p2 = i;
            int[] indexes = palindromeString(p1, p2, n, chars);
            int len = indexes[1] - indexes[0] + 1;
            if(len > maxLen){
                maxLen = len;
                start = indexes[0];
                end = indexes[1];
            }
        }

        for(int i = 0; i < n-1; i++){
            p1 = i; p2 = i+1;
            int[] indexes = palindromeString(p1, p2, n, chars);
            int len = indexes[1] - indexes[0] + 1;
            if(len > maxLen){
                maxLen = len;
                start = indexes[0];
                end = indexes[1];
            }
        }

        return s.substring(start, end+1);
    }
    public static int[] palindromeString(int p1, int p2, int n, char[] s){
        while(p1 >= 0 && p2 < n  && s[p1] == s[p2]){
            p1--; p2++;
        }
        return new int[]{p1+1, p2-1};
    }
}
