package Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms3_LC2402 {
    public static void main(String[] args) {
        int n = 3;
        int[][] meetings = {
                {1,20},
                {2,10},
                {3,5},
                {4,9},
                {6,8}
        };
        System.out.println(mostBooked(n, meetings));
    }
    public static int mostBooked(int n, int[][] meetings) {
        if(n == 1) return 0;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] bookings = new int[n];
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        // sort occupiedRooms on meeting end time, If end times are same then sort on room number.
        PriorityQueue<int[]> occupiedRooms = new PriorityQueue<>((a,b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);

        for(int i = 0; i < n; i++){
            freeRooms.add(i);
        }
        for(int[] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            while(!occupiedRooms.isEmpty() && occupiedRooms.peek()[1] <= start){
                freeRooms.add(occupiedRooms.poll()[0]);
            }

            if(!freeRooms.isEmpty()){
                int room = freeRooms.poll();
                bookings[room]++;
                occupiedRooms.add(new int[]{room, end});
            }
            else{
                int[] soonEndMeeting = occupiedRooms.poll();
                int room = soonEndMeeting[0];
                int endTime = soonEndMeeting[1];
                bookings[room]++;
                occupiedRooms.add(new int[]{room, endTime + end - start});
            }
        }
        int count = 0;
        int mostBookedRoom = -1;
        for(int i = 0; i < n; i++){
            if(count < bookings[i]){
                count = bookings[i];
                mostBookedRoom = i;
            }
        }
        return mostBookedRoom;
    }
}
/*
Meetings are allocated to rooms in the following manner:

-> Each meeting will take place in the unused room with the lowest number.
-> If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
-> When a room becomes unused, meetings that have an earlier original start time should be given the room.

Approach :
-> sort the meetings so that we can get to know which meetings can be scheduled first, it's easier to
   check whether we can use the room of first scheduled meeting using endTime of first meeting and startTime
   of second meeting endTime <= startTime means first meeting ended. so we can use the room. or it is easy to
   check whether they are overlapping.
-> Keep track of which rooms are free and which are occupied.
-> If all rooms are occupied, get the room number of meeting which is going to end soon.
-> Example rooms = 3, meetings 1-10, 3-8, 4-14 now we have to schedule a meeting 9-16. currently all rooms are
   occupied. In all meetings, 3-8 is going to end first. so we use that room to schedule 9-16.

Dry run an example : N = 4 and Meetings = [18,19],[3,12],[17,19],[2,13],[7,10]

step1 : Sort all based on start time -> [2,13], [3,12], [7,10], [17,19], [18,19]
step2 : Assign a available room to meeting, before assign check If any of meetings are ended, If yes free
        up those rooms and add to queue(freeRooms). So that we can assign the smallest number room to current meeting.
step3 : If there are no rooms available then take a room in which meeting is going to end soon.


Track freeRooms, bookings of rooms and occupied rooms
meeting     room    bookings
2,13        0       1
3,12        1       1
7,10        2       1
17,19 Now start time is 17, make sure all rooms are available which ends before 17
0, 1, 2 are ends 13,12,10 respectively means 13,12,10 <= 17
17,19       0       2 -> Here before schedule we have to check which are rooms available and choose lowest one.
18,19       1       2

1 and 2 have 2 bookings but lowest one is 1.

so before schedule a meeting free up rooms which ends before current meeting
if all nothing free up and all rooms are booked, then choose roomID of meeting which is going to end first.

 */
