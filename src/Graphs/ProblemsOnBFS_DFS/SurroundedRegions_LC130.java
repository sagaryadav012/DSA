package Graphs.ProblemsOnBFS_DFS;

import java.util.Arrays;

public class SurroundedRegions_LC130 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] row = {0,0,-1,1};
        int[] col = {-1,1,0,0};
        for(int r = 0; r < n; r++){
            if(board[r][0] == 'O') dfs(r, 0, board, vis, row, col);
            if(board[r][m-1] == 'O') dfs(r, m-1, board, vis, row, col);
        }
        for(int c = 0; c < m; c++){
            if(board[0][c] == 'O') dfs(0, c, board, vis, row, col);
            if(board[n-1][c] == 'O') dfs(n-1, c, board, vis, row, col);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !vis[i][j]) board[i][j] = 'X';
            }
        }
    }
    public static void dfs(int i, int j, char[][] board, boolean[][] vis, int[] row, int[] col){
        vis[i][j] = true;
        for(int k = 0; k < 4; k++){
            int newRow = i + row[k];
            int newCol = j + col[k];
            if(!isValidCell(newRow, newCol, board.length, board[0].length, board) || vis[newRow][newCol]) continue;
            dfs(newRow, newCol, board, vis, row, col);
        }
    }
    public static boolean isValidCell(int i, int j, int n, int m, char[][] board){
        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] == 'X') return false;
        return true;
    }
}

/*
Approach 1 :
-> The problem statement is Flip the O's which are surrounded by X. Means The O's that are can't reach boundaries.
-> Iterate over each char, If it is O then do dfs to find whether it reaches boundary. Instead of doing this,
   Assume this O's are valid paths and X's are barriers.
-> Observe that the O's on boundaries are not surrounded by X in all 4 directions. So find O's on boundaries,
   Do dfs traversal and mark the cells are visited.
-> The O's which are present in visited cells are able to reach boundary, that means those O's are not surrounded
   by X.
-> TC - O(4^n+m) SC - O(n*m)

Approach 2 :
-> This can be solved by BFS traversal, Take cells of boundaries on which O's are present, add to queue.
-> Now do traversal and mark cells are visited. The O's except present on visited cells are surrounded by X.
 */
