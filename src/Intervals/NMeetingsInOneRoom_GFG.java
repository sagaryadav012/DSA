package Intervals;

import java.util.PriorityQueue;

public class NMeetingsInOneRoom_GFG {
    public static void main(String[] args) {

    }
    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(int i = 0; i < n; i++){
            pq.add(new int[]{start[i], end[i]});
        }

        int meetingsCount = 0;
        int endTime = -1;
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int meetingStartTime = pair[0];
            int meetingEndTime = pair[1];

            if(endTime >= meetingStartTime) continue;

            endTime = meetingEndTime;
            meetingsCount += 1;
        }
        return meetingsCount;
    }
}
/*

There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output:
4

Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)

-> Sorting on start time will not work, why? See this (1,10) (2,4) (5,7) (8,9).
-> If we held meeting 1,10 then we can't hold all other meeting since 1,10 will be ended at 10.
-> Sort on start time and sort on short time period will not work, instead do sort on end time.
-> If we hold meeting which ends first then we can hold other also.

 */