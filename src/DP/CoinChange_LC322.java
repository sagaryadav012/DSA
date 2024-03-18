package DP;

public class CoinChange_LC322 {
    public static void main(String[] args) {
        int[] coins = {1,5,6,9};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for(int i = 1; i <= amount; i++){
            int minCoins = amount+1;
            for(int coin : coins){
                if(coin <= i && dp[i - coin] != amount+1){
                    minCoins = Math.min(minCoins, dp[i - coin] + 1);
                }
            }
            dp[i] = minCoins;
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
/*
Ex : 1 2 5 and amount 11

Approach 1 : Generate all combinations and check their sum, if it equals to amount check which combination takes
min no.of coins.

Approach 2 : Greedy
I want min no.of coins. So I will do greedy and choose max denomination coin first

Example 1 :
    coins = {1,2,5} and amount 11

    coin    remaining
    5       11-5 = 6
    5       6-5 = 1
    1       1-1 = 0

    so total coins are 3

Example 2 :
    coins = {1,5,6,9} and amount 11

    coin    remaining
    9       11-9 = 2
    1       2-1 = 1
    1       1-1 = 0

    so total coins are 3 but amount 11 can be formed by 5 & 6 coins

   Greedy fails

Approach 3 :

Example 1 :
    coins = {1,5,6,9} and amount 11

    Find min no.of coins needed to form each coin from 1 to amount

    dp:
    coin      :     0       1       2       3       4       5       6       7       8       9       10      11
    min coins :     0       1       2       3       4       1       1       2       3       1       2       2

        check for 9 ?
        Amount to make : 9
        choose coin : coin can choose -         1           5           6           9
        Remainder : amount - coin               8           4           3           0
        coins : minCoins(remainder) + 1: 3+1 =  4,    4+1 = 5,    3+1 = 4     0+1 = 1
        dp[9] = min of all possible(coins)


 */
