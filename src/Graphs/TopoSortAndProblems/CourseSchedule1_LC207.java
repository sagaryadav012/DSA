package Graphs.TopoSortAndProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1_LC207 {
    public static void main(String[] args) {
        int[][] prerequisites = {
                {0,1},
                {0,3},
                {1,3},
                {1,4},
                {2,0},
                {2,3},
                {3,4}
        };
        int numCourses = 5;
        System.out.println(canFinish(numCourses, prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) { // TC - O(V+E) SC - O(V+E)
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        int[] count = new int[numCourses];
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adjList.get(v).add(u);
            count[u]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(count[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int dependCourse : adjList.get(course)){
                count[dependCourse]--;
                if(count[dependCourse] == 0) queue.add(dependCourse);
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(count[i] != 0) return false;
        }
        return true;
    }
}
/*
-> Edge [0,1] , To complete 0 first completed 1 course. So take edge in reverse that means 1 to 0, 0 have one dependent
   course means to complete 0, first complete 1.
-> Remaining process is same as topo sort. first completed course which have 0 dependency. while completing it
   decrement count of dependentCount of course. If count is 0 that means there is no prerequisite to complete
   this course so add it to queue.
 */