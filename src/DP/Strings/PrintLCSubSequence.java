package DP.Strings;

public class PrintLCSubSequence {
    public static void main(String[] args) {
        String text1 = "abcab";
        String text2 = "cbab";
        System.out.println(printString(text1, text2));
    }
    public static String printString(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        String ans = "";
        int i = n, j = m;
        while(i > 0 && j > 0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ans += text1.charAt(i-1);
                i -= 1;
                j -= 1;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i = i-1;
            }
            else{
                j = j-1;
            }
        }
        return new StringBuilder(ans).reverse().toString();
    }
}
/*
Re work on it, solution is not working.
 */
