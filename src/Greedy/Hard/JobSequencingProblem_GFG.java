package Greedy.Hard;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JobSequencingProblem_GFG {
    public static void main(String[] args) {
        Job[] jobs = {
                new Job(5,2,100),
                new Job(1,4,20),
                new Job(3,1,40),
                new Job(4,1,30),
                new Job(2,1,10)
        };
        int n = 4;
        System.out.println(Arrays.toString(JobScheduling(jobs, n)));
//        System.out.println(-5%5);
    }
    public static int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);
        int maxTime = 0;
        for (Job job : arr) {
            maxTime = Math.max(job.deadline, maxTime);
        }

        int[] slots = new int[maxTime + 1];
        Arrays.fill(slots, -1);

        int jobCount = 0;
        int maxProfit = 0;
        for (Job job : arr) {
            int deadline = job.deadline;
            for(int i = deadline; i > 0; i--){
                if(slots[i] == -1){
                    slots[i] = job.id;
                    maxProfit += job.profit;
                    jobCount += 1;
                    break;
                }
            }
        }

        return new int[]{jobCount, maxProfit};
    }
}
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
/*
Approach 1 :
-> Sort jobs on profit, so that we can choose maxProfit. We know each job takes one unit of time to complete.
-> Ex : id,deadline,profit -> { [1,2,100], [2,2,30], [3,1,50]} sort all on profit -> { [1,2,100], [3,1,50], [2,2,30] }
           job          time        maxProfit
                        0           0
           1,2,100      1           100
           3,1,50       currently we are at time slot2, but this job time is 1 so expired.
           2,2,30       2           100+30 = 130
           It gives maxProfit 130, but we can do jod id 3 at time 1 and job id 1 at 2, so we get 150.
-> so the above approach fails.

Approach 2 :
-> Every job has deadline, Do job on the last deadline, for example if deadline is 6, perform job on 6th day or 6th unit of time.
-> If we do like that in the remaining days, we can do other jobs which has max profit and ends soon.
   for examples job = { [1,4,100] [2,1,50]} If we perform job id1 has deadline 4, it takes one unit of time.
   And we completed one unit, and we can't do job id 2 since it expires at 1 deadline. so perform job on last day.
-> So sort all jobs on profit, and find max time available. Take an array of length max time + 1 to keep
   track of which slots are available.
-> We can take boolean array to check slot available or not. But If take an int array we can keep track of
   jobs which perform in sequence. First fill array with -1 which indicates slot available, once done job
   store job id at slot.
-> TC - O(N*M)

 */
