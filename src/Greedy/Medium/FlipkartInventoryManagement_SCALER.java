package Greedy.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FlipkartInventoryManagement_SCALER {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1,7,6,2,8,4,4,6,8,2);
        List<Integer> B = Arrays.asList(8,11,7,7,10,8,7,5,4,9);
        System.out.println(solve1(A, B));
        System.out.println(solve2(A, B));
    }
    // Approach 2 :
    public static int solve1(List<Integer> A, List<Integer> B) { // TC - O(NlogN)
        int n = A.size();
        int[][] pairs = new int[n][2]; // stores expireTime, profit

        for(int i = 0; i < n; i++){
            pairs[i][0] = A.get(i);
            pairs[i][1] = B.get(i);
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long maxProfit = 0;
        for(int[] pair : pairs){
            int expireTime = pair[0];
            int profit = pair[1];
            maxProfit += profit;
            pq.add(profit);

            if(pq.size() > expireTime){
                int removeProfit = pq.poll();
                maxProfit -= removeProfit;
            }
            maxProfit %= 1000000007;
        }

        return (int)maxProfit;
    }

    // Approach 3
    public static int solve2(List<Integer> A, List<Integer> B) {
        int n = A.size();
        int[][] pairs = new int[n][2]; // stores expireTime, profit

        int maxTime = 0;
        for(int i = 0; i < n; i++){
            pairs[i][0] = A.get(i);
            pairs[i][1] = B.get(i);
            maxTime = Math.max(maxTime, A.get(i));
        }


        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        int[] res = new int[maxTime+1];
        Arrays.fill(res, -1);
        long maxProfit = 0;
        for(int[] pair : pairs){
            int expireTime = pair[0];
            int profit = pair[1];
            for(int i = expireTime; i > 0; i--){
                if(res[i] == -1){
                    res[i] = profit;
                    maxProfit += profit;
                    maxProfit %= 1000000007;
                    break;
                }
            }
        }

        return (int)maxProfit;
    }
}

/*
Question :
In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management.
Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays, A and B of size N.
A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit margin for the ith item.
To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.

The objective is to identify a method to strategically buy certain items, ensuring they are sold before
their expiration date, thereby maximizing overall profit. Can you assist Flipkart in developing an
innovative approach to optimize their grocery inventory and enhance profitability?

Your task is to find the maximum profit one can earn by buying groceries considering that you can only
buy one grocery item at a time.

1 <= N <= 105
1 <= A[i] <= 109
0 <= B[i] <= 109

Input :
A = [1, 3, 2, 3, 3]
B = [5, 6, 1, 3, 9]
Output : 20


Approach 1 :
-> Sort all pairs on profit in non-ascending order, So that we can buy max profit product first.
-> But this approach fails.
   Ex : (expireTime, profit) : {(2,9), (1,6), (2,4)} these pairs are already sorted on profit

   Time         ExpiryTime      Profit
   1            2               9
   2            1 -> We can't buy product at 1st index since it expires at 1 time, we are at 2 time, so move forward.
   2            2               4

   Total profit we get 9+4 = 13 but optimized profit -> 6+9 = 15
   So this sort on profit will be failed.

Approach 2 :
-> Sort all pairs on expire time. And to buy product it takes one unit of time.
-> Once sorting is done, I will iterate over pairs and buy one by one. If no.of bought products > currentExpireTime then
   I will remove product which give less profit from list of bought products. This process ensures we bought
   products which gives max profit.
-> For example we are at currentTime 4, it means we would have bought 3 product maximum. If bought products >
   currentTime means some expireTimes are overlapped, and we need to choose optimized product.

   Pair(ExpireTime, Profit) : {(1,6), (2, 5), (3, 8), (3, 6), (4, 3), (4, 9)} Pairs are sorted on expireTime

   Time         ExpireTime      Profit          PriorityQueue(sort in asc)
   1            1               6               6
   2            2               5               5,6
   3            3               8               5,6,8
   4            3               6               5,6,6,8 -> pq.size() > currentExpireTime so remove min profit -> 6,6,8
   5            4               3               3,6,6,8
   6            4               9               3,6,6,8,9 -> remove 3 -> 6,6,8,9

   Total profit we get 6+6+8+9 = 29
 */



