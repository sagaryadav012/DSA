package Graphs.ProblemsOnBFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_LC542 {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,1},
                {0,1,0},
                {1,1,1}
        };
        for (int[] row : updateMatrix(mat)) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0) queue.add(new int[]{i, j, 0});
            }
        }

        int[] row = {0,0,-1,1};
        int[] col = {-1,1,0,0};

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int i = pair[0];
            int j = pair[1];
            int dist = pair[2];

            for(int k = 0; k < 4; k++){
                int newRow = i + row[k];
                int newCol = j + col[k];
                if(!isValidCell(newRow, newCol, mat, n, m)) continue;
                queue.add(new int[]{newRow, newCol, dist+1});
                res[newRow][newCol] = dist+1;
                mat[newRow][newCol] = 0;
            }
        }
        return res;
    }
    public static boolean isValidCell(int i, int j, int[][] mat, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m || mat[i][j] == 0) return false;
        return true;
    }
}
/*
Approach 1 :
-> Go through each element in mat, if it is 1, run dfs to find distance.
-> TC - O(4^n*m) SC -O(n*m)
-> Can optimize by dp memoization.

Approach 2:
-> BFS traversal technique, choose cells which are 0, and traverse from there to all cells which are 1
   while traverse calculate dist and store it result array.
-> Make the cells visited are 0 to do not visit again.
-> TC -O(N*M)
 */
