package Greedy.Medium;

import java.util.Arrays;

public class MostProfitAssigningWork_LC826 {
    public static void main(String[] args) {

    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) { // TC - O(NlogN) SC - O(N+N)
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
    public static int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker) { // TC -O(N) SC - O(maxDifficulty)
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
