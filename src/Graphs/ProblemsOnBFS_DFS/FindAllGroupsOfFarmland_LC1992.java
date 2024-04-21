package Graphs.ProblemsOnBFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllGroupsOfFarmland_LC1992 {
    public static void main(String[] args) {
        int[][] land = {
                {1,0,0},
                {0,1,1},
                {0,1,1}
        };

        int[][] res = findFarmland(land);

        for(int[] ar : res){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 0 || j > 0  && land[i][j-1] == 1 || i > 0 && land[i-1][j] == 1){
                    continue;
                }
                int x = i;
                int y = j;
                for(; x+1 < n && land[x+1][j] == 1; x++) ;
                for(; y+1 < m && land[i][y+1] == 1; y++) ;

                list.add(new int[]{i,j,x,y});
            }
        }
        return list.toArray(new int[list.size()][4]);
    }
}
/*

-> Given that all farmlands are in rectangular shape And two groups are not adjacent to each other.
-> Iterate over matrix, when we encounter 0 then skip loop. And If we encounter 1, adjacent of it is 1 then skip loop,
   It means that 1 is part of another group, so don't count again.
-> If we encounter 1 and adjacent is not 1 means it is starting point group land and check x axis and y axis till we encounter 0,
   and take x,y as bottom right corner, we don't need to check diagonal area since all farm lands are in rectangular shape.

 */