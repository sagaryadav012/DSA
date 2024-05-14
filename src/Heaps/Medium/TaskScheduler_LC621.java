package Heaps.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TaskScheduler_LC621 {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'C', 'C', 'C', 'C'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int chunk = freq[25] - 1;
        int idleSpots = chunk * n;

        for(int i = 24; i >= 0; i--){
            idleSpots -= Math.min(chunk, freq[i]);
        }

        return idleSpots < 0 ? tasks.length : idleSpots + tasks.length;
    }
}
/*
Approach 1:
-> It has given that identical tasks are separated by n intervals due to cooling period.
-> For example there 2 B tasks, n = 1. and we can't complete B consecutively, 2 B's are separated by n.
   Like -> B   idle    B
-> So take count of each task, so It would be easy to separate them by n intervals.
-> First complete max count(freq) of task, so that there would be a lot of cooling periods in between,
   meanWhile we complete other tasks which are not identical.

   For example -> B = 2, A = 4 and n = 1. Cooling Period = CP

   -> Intervals  :      1       2       3       4       5       6       7       8
   -> Complete B :      B       CP      B
   -> Complete A :              A               A       CP      A       CP      A
   It takes 8 intervals to complete all tasks.

   Now complete with max count of task and check, how many intervals it takes ?
   -> Intervals  :      1       2       3       4       5       6       7
   -> Complete A :      A       CP      A       CP      A       CP      A
   -> Complete B :              B               B
   It took only 7 intervals, so complete max count of tasks so that we can have max cooling periods,
   In those periods we can complete other tasks.

-> Now we know the idea, How can implement ?
-> Take freq of each task, And take max freq so that we can get max chunks.
    For example A = 3, B = 2, C = 4 And n = 2.
    First complete C tasks.
            Chunk1                          chunk2                          chunk3
    C       IDLE      IDLE      |   C       IDLE      IDLE      |   C       IDLE      IDLE       |  C
    Total Idle spots are 6. now can we complete other tasks in these idle spots ?
    So take next max freq, i.e A = 3, Total chunks are 3. so take 3 A's and complete them in these idle spots.
    Idle  spots = idle spots - taken tasks(3) = left idle spots are 3.

           Chunk1                          chunk2                          chunk3
    C       A      IDLE      |   C       A      IDLE      |   C       A      IDLE       |  C

    take next max freq, i.e. B = 2;
          Chunk1                    chunk2                    chunk3
    C       A      B      |   C       A      B      |   C       A      IDLE       |  C
    Completed all task so total taken intervals = Total tasks completed + left ideal spots.

    Dry run this A = 2, B = 2, C = 1, D = 1 and n = 1 to know when idle spots goes < 0
 */