package DP.LeetCode;

public class TwoKeysKeyboard_LC650 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(minSteps(n));
    }
    public static int minSteps(int n) {
        if(n == 1) return 0;

        int[] dp = new int[n+1];

        for(int i = 2; i <= n; i++){
            dp[i] = i;
            for(int j = 1; j <= i; j++){
                if(i%j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + dp[i/j]);
                }
            }
        }

        return dp[n];
    }
    public static int minSteps1(int n) {
        int ans=0;
        for(int i=2;i*i<=n;){
            if(n%i==0){
                ans+=i;
                n=n/i;
            }else{
                i++;
            }
        }
        if(n!=1) ans=ans+n;
        return ans;
    }
}
