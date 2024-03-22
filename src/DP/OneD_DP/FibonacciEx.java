package DP.OneD_DP;

import java.util.Arrays;

public class FibonacciEx {
    public static void main(String[] args) {
        int N = 12;
        System.out.println(fib1(N));

        int[] cache = new int[N+1];
        Arrays.fill(cache, -1);

        System.out.println(fib2(N, cache));

        System.out.println(fib3(N));

        System.out.println(fib3(N));
    }
    // Recursive Code : TC - O(2^n) SC - O(N)
    public static int fib1(int N){
        if(N <= 1) return N;
        return fib1(N-1) + fib1(N-2);
    }

    // Recursive Code DP(Top - Down Approach -> Memoization) : TC - O(N) SC - O(N + stackSpace)
    public static int fib2(int N, int[] cache){
        if(N <= 1) return N;
        if(cache[N] != -1) return cache[N];
        int ans = fib2(N-1, cache) + fib2(N-2, cache);
        cache[N] = ans;
        return ans;
    }

    // Iterative Code(Bottom - Up Approach - Tabulation) : TC - O(N) SC - O(N);
    public static int fib3(int N){
        int[] cache = new int[N+1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;

        for(int i = 2; i <= N; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[N];
    }

    // Iterative Code Space Optimization(Bottom - Up Approach -> Tabulation) : TC - O(N) SC - O(1);
    public static int fib4(int N){
        int a = 0;
        int b = 1;
        int c = -1;
        for(int i = 2; i <= N; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
