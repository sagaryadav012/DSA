package Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2_LC253 {
    public static void main(String[] args) {
        int[][] meetings = {
                {7, 15},
                {2, 6},
                {9, 18},
                {11, 13},
                {6, 8},
                {3, 5},
                {4, 6}
        };
        System.out.println(maxRooms(meetings));
        System.out.println(maxRooms1(meetings));
        System.out.println(maxRooms2(meetings));
    }
    public static int maxRooms(int[][] meetings){
        // sort all meetings on their start time
        Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);

        // sort all meeting on their end time. so we can poll who ends, can use same room for future meetings
        PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> m1[1] - m2[1]);

        for(int[] meeting : meetings){
            if(pq.isEmpty()){
                pq.add(meeting);
                continue;
            }

            int[] peekMeeting = pq.peek();
            if(peekMeeting[1] <= meeting[0]){
                // poll meeting which ends before this current meeting. so we use same room for current meeting
                pq.poll();
            }
            pq.add(meeting);
        }

        return pq.size();
    }
    public static int maxRooms1(int[][] meetings){
        // sort all meetings on their start time
        Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);

        // sort all meeting on their end time. so we can poll who ends, can use same room for future meetings
        PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> m1[1] - m2[1]);

        int maxRooms = 0;
        for(int[] meeting : meetings){
            // poll all meetings which ends before currentMeeting start time
            while(!pq.isEmpty() && pq.peek()[1] <= meeting[0]){
                pq.poll();
            }
            pq.add(meeting);
            maxRooms = Math.max(maxRooms, pq.size());
        }

        return maxRooms;
    }
    public static int maxRooms2(int[][] meetings){
        int n = 1000002;
        int[] delta = new int[n]; // max size of start and end is 10^6

        for(int[] meeting : meetings){
            delta[meeting[0]]++;
            delta[meeting[1]]--;
        }

        int maxRooms = 0;
        for(int i = 1; i < n; i++){
            delta[i] += delta[i-1];
            maxRooms = Math.max(maxRooms, delta[i]);
        }

        return maxRooms;
    }
}
/*

Question : Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
           find the minimum number of conference rooms required.

Approach 1 :
-> First sort all meetings on start time, so it's easy to check which meeting overlapping in linear time complexity.
-> Pick meetings one by one and assign rooms for it. Before assign room check, Is there any meeting ended?
   If any meeting ended, then we can use that room to current meeting.
-> So we need a data structure to find this, I assume priority queue is better to check last ended meeting
   at constant time. add meetings to queue, sort meetings on end time. so peek value will be the soon ended meeting.
-> So add one by one to queue, check before adding Is there any meeting ended? IF yes poll it from queue,
   add current meeting.
-> Here no.of meeting rooms are size of queue.
-> TC - O(NlogN) SC - O(n)
 */