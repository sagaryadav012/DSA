package Intervals;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar2_LC731 {
    public static void main(String[] args) {

    }
}
class MyCalendarTwo { // TC - O(N * N) SC - O(N)
    List<int[]> events;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int[] overlap : overlaps){
            if(Math.max(overlap[0], start) < Math.min(overlap[1], end)){
                return false;
            }
        }
        for(int[] event : events){
            // Here overlapStart and overlapEnd gives overlap time period. Examples (3,10) (6,15) or (8,20) (5,10)
            int overlapStart = Math.max(start, event[0]);
            int overlapEnd = Math.min(end, event[1]);

            if(overlapStart < overlapEnd){
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }
        events.add(new int[]{start, end});
        return true;
    }
}
/*
-> Given event start and end time, book event. If booking event causes triple booking then don't book that event.
-> For example events 10,20  12,40  5,15. First we book 10,20 then 12,40 and when we book 5,15 it causes
   to triple booking. From 10,20 and 12,40 overlapping time is 12,20 so if any upcoming events overlaps
   with this overlap time then that causes to triple booking.
-> To avoid triple booking, Take two lists each list stores event. list1(events) stores events which not
   causes to triple booking. list2(overlaps) if any two events overlaps then find overlap time and add it to
   overlaps.
-> When we book event first check in overlap times is overlaps list. If event overlaps that means this
   event causes to triple booking so return false.
-> Else check start and end time with events list, If it overlaps with any other event then take overlap time
   and add it to overlaps list.
 */
