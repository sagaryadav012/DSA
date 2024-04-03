package Backtracking;

public class WordSearch_LC79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(checkForWord(i, j, m, n, 0, word, board)) return true;
            }
        }
        return false;
    }
    private static boolean checkForWord(int i, int j, int m, int n, int index, String word, char[][] board){
        if(i < 0 || i == n || j < 0 || j == m) return false;
        if(board[i][j] != word.charAt(index) || board[i][j] == '*') return false;
        if(index == word.length() - 1) return true;

        final char cache = board[i][j];
        board[i][j] = '*';
        boolean isExist = checkForWord(i + 1, j, m, n, index + 1, word, board) ||
                checkForWord(i - 1, j, m, n, index + 1, word, board) ||
                checkForWord(i, j + 1, m, n, index + 1, word, board) ||
                checkForWord(i, j - 1, m, n, index + 1, word, board);
        board[i][j] = cache;
        return isExist;
    }
}
