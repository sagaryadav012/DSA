package Intervals;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar1_LC729 {

}
// Approach 1
class MyCalendar1 {
    List<int[]> events;
    public MyCalendar1() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int n = events.size();
        if(n == 0){
            events.add(new int[]{start, end});
            return true;
        }

        int s1 = start;
        int e1 = end;

        for(int[] event : events){
            int s2 = event[0];
            int e2 = event[1];

            if(e1 <= s2 || e2 <= s1) continue;
            return false;
        }
        events.add(new int[]{s1, e1});
        return true;
    }
}

// Approach 2
class MyCalendar2{
    private class Node{
        int start;
        int end;
        Node left;
        Node right;

        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    Node root;
    public MyCalendar2() {

    }
    public boolean book(int start, int end) {
        if(root == null){
            root = new Node(start, end);
            return true;
        }

        Node curr = root;
        while(curr != null){
            if(end <= curr.start){
                if(curr.left == null){
                    curr.left = new Node(start, end);
                    return true;
                }
                curr = curr.left;
            }
            else if(start >= curr.end){
                if(curr.right == null){
                    curr.right = new Node(start, end);
                    return true;
                }
                curr = curr.right;
            }
            else return false;
        }
        return false;
    }
}

/*
Approach 1 : TC - O(N^2) SC - O(N)
-> When we book event check with all events that are scheduled, If current event overlaps with anyone return false.
-> I have used list to store events. And used two conditions to check whether the events are overlapping or not.
-> If events are in sorted format then one condition is enough to check overlapping. But here events are not
   in sorted format so check two conditions.

Approach 2 : TC - O(2N) SC - O(N)
-> Here I have used nodes to check events are overlapping or not.
-> Initially root is null, add events by checking, are they overlapping?
-> Example 1 : start = 3, end = 6. currNode point to some node currStart = 8, currEnd = 12.
   Here end <= currStart means they are not overlapping so move curr pointer to left and compare end with currStart again.
   If currNode == null  then put event there else compare again.
-> Example 2 : start = 5, end = 8. currNode point to some node currStart = 2, currEnd = 4.
   Here start >= currEnd means they are not overlapping so move curr pointer to right and compare start with currEnd again.
   If currNode == null  then put event there else compare again.

 */