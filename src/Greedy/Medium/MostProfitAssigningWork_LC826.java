package Greedy.Medium;

import java.util.Arrays;

public class MostProfitAssigningWork_LC826 {
    public static void main(String[] args) {
        int[] difficulty = {68,35,52,47,86};
        int[] profit = {67,17,1,81,3};
        int[] worker = {92,10,85,84,82};
        System.out.println(maxProfitAssignment1(difficulty, profit, worker));
        System.out.println(maxProfitAssignment2(difficulty, profit, worker));
        System.out.println(maxProfitAssignment3(difficulty, profit, worker));
    }
    public static int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) { // TC - O(N^2) SC - O(1)
        int maxProfitGain = 0;
        int n = difficulty.length;
        for(int capability : worker){
            int maxProfit = 0;
            for(int i = 0; i < n; i++){
                if(capability >= difficulty[i]){
                    maxProfit = Math.max(maxProfit, profit[i]);
                }
            }
            maxProfitGain += maxProfit;
        }
        return maxProfitGain;
    }
    public static int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) { // TC - O(NlogN) SC - O(N+N)
        int n = difficulty.length;
        int m = worker.length;
        int[][] jobs = new int[n][2];

        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }

        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        Arrays.sort(worker);

        int jobPointer = 0, maxProfit = 0, totalProfit = 0;
        for(int ability : worker){
            while(jobPointer < n && jobs[jobPointer][0] <= ability){
                maxProfit = Math.max(maxProfit, jobs[jobPointer][1]);
                jobPointer++;
            }
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
    public static int maxProfitAssignment3(int[] difficulty, int[] profit, int[] worker) { // TC -O(N) SC - O(maxDifficulty)
        if (difficulty.length != profit.length) {return 0;}

        int maxDifficulty = 0;
        for (int diff: difficulty) {
            maxDifficulty = Math.max(maxDifficulty, diff);
        }

        int[] bestProfit = new int[maxDifficulty + 1];
        for (int i = 0; i < profit.length; i++) {
            bestProfit[difficulty[i]] = Math.max(bestProfit[difficulty[i]], profit[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < bestProfit.length; i++) {
            if (bestProfit[i] > maxProfit) {
                maxProfit = bestProfit[i];
            }
            bestProfit[i] = maxProfit;
        }

        int result = 0;
        for (int w: worker) {
            if (w > maxDifficulty) {
                result += bestProfit[maxDifficulty];
            } else {
                result += bestProfit[w];
            }
        }
        return result;
    }

}
/*
Approach 1 : TC - O(N^2) SC - O(1)
-> At the end we have to get max profit. So choose max profit works.
-> If a worker capability 50 then he can do work difficulty up to 50.
-> Iterate over workers, take each worker's capability and check if there are works with difficulty level <= capability
   If yes take max profit in those.

Approach 3 : TC - O(N) SC - O(maxDifficulty)
-> Track profit at each difficulty level.
-> Take an array which stores profit at each difficulty level and length of array is max difficulty + 1.
-> Now take each profit and put at their difficulty level in array.
-> Now keep track of maxProfit and place at each difficulty level.
-> Finally just iterate over workers, take profit of work which they can do.
 */