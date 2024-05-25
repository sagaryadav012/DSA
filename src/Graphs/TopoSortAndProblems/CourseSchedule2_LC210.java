package Graphs.TopoSortAndProblems;

import java.util.*;

public class CourseSchedule2_LC210 {
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
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) { // TC - O(V+E) SC - O(V+E)
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

        int[] ans = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            ans[index++] = course;
            for(int dependCourse : adjList.get(course)){
                count[dependCourse]--;
                if(count[dependCourse] == 0) queue.add(dependCourse);
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(count[i] != 0) return new int[]{};
        }
        return ans;
    }
}

