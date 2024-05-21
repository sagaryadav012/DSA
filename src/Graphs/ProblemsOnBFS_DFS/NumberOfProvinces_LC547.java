package Graphs.ProblemsOnBFS_DFS;

public class NumberOfProvinces_LC547 {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1,1,1,0,0,0},
                {1,1,0,0,0,0},
                {1,0,1,0,0,0},
                {0,0,0,1,1,0},
                {0,0,0,1,1,0},
                {0,0,0,0,0,1}
        };
        System.out.println(findCircleNum(isConnected));
    }
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(vis[i]) continue;
            dfs(i, isConnected, vis);
            count += 1;
        }
        return count;
    }
    public static void dfs(int node, int[][] isConnected, boolean[] vis){
        vis[node] = true;
        for(int j = 0; j < isConnected[node].length; j++){
            if(isConnected[node][j] == 0 || vis[j]) continue;
            dfs(j, isConnected, vis);
        }
    }
}
