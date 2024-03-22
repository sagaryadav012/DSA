package DP.OneD_DP;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) { // TC - O(n) SC - O(1)
        if(n <= 2) return n;
        int a = 1;
        int b = 2;
        int c = -1;
        for(int i = 3; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
