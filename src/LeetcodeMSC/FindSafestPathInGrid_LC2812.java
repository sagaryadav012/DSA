package LeetcodeMSC;

import javafx.util.Pair;

import java.util.*;

public class FindSafestPathInGrid_LC2812 {
    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, 1, 0, -1};
    static int maxDist = 0;
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 0 , 0, 1));
        grid.add(Arrays.asList(0, 0 , 0, 0));
        grid.add(Arrays.asList(0, 0 , 0, 0));
        grid.add(Arrays.asList(1, 0 , 0, 0));
        System.out.println(maximumSafenessFactor(grid));
    }
    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] distToThief = findDistToThief(grid);

        int low = 0, high = maxDist;
        int ans = 0;
        while(low <= high){
           int mid = low + (high - low)/2;
           if(isPathExist(distToThief, mid)){
               ans = mid;
               low = mid + 1;
           }
           else high = mid - 1;
        }
        return ans;
    }
    public static boolean isPathExist(int[][] distToThief, int safeness){
        if(distToThief[0][0] < safeness) return false;
        int n = distToThief.length;
        boolean[][] vis = new boolean[n][n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Pair<Integer, Integer> pair = queue.poll();
                int r = pair.getKey();
                int c = pair.getValue();
                for(int i = 0; i < 4; i++){
                    int newR = r + row[i];
                    int newC = c + col[i];

                    if(!isValid(n, newR, newC) || vis[newR][newC]) continue;
                    if(distToThief[newR][newC] < safeness) continue;
                    if(newR == n-1 && newC == n-1) return true;

                    vis[newR][newC] = true;
                    queue.add(new Pair<>(newR, newC));
                }
                size--;
            }
        }
        return false;
    }

    public static int[][] findDistToThief(List<List<Integer>> grid){
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid.get(i).get(j) == 1) queue.add(new Pair<>(i, j));
            }
        }

        int[][] distToThief = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Pair<Integer, Integer> pair = queue.poll();
                int r = pair.getKey();
                int c = pair.getValue();
                vis[r][c] = true;
//                distToThief[r][c] = 0;
                for(int i = 0; i < 4; i++){
                    int newR = r + row[i];
                    int newC = c + col[i];
                    if(isValid(n, newR, newC) && !vis[newR][newC]){
                        distToThief[newR][newC] = distToThief[r][c] + 1;
                        maxDist = Math.max(distToThief[newR][newC], maxDist);
                        queue.add(new Pair<>(newR, newC));
                    }
                }
                size--;
            }
        }
        return distToThief;
    }
    public static boolean isValid(int n, int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= n) return false;
        return true;
    }
}
