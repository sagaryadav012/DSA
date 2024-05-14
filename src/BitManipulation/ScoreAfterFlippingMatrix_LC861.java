package BitManipulation;

public class ScoreAfterFlippingMatrix_LC861 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        System.out.println(matrixScore(grid));
    }
    public static int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int[] row : grid) {
            if(row[0] != 0) continue;
            for(int i = 0; i < m; i++){
                row[i] = row[i]^1;
            }
        }
        int[] colZeros = new int[m];
        int[] colOnes = new int[m];
        for (int[] row : grid) {
            for(int i = 0; i < m; i++){
                if(row[i] == 1) colOnes[i] += 1;
                else colZeros[i] += 1;
            }
        }

        for(int c = 0; c < m; c++){
            if(colOnes[c] < colZeros[c]){
                for(int r = 0; r < n; r++){
                    grid[r][c] = grid[r][c] ^ 1;
                }
            }
        }

        int score = 0;
        for(int r = 0; r < n; r++){
            for(int c = m-1; c >= 0; c--){
                if(grid[r][c] == 0) continue;
                score += (int)Math.pow(2, m-1-c);
            }
        }
        return score;
    }
}
/*
-> MSB(Most significant bit) in bits has more weightage, for example 0111 < 1000.
-> So check each row of first column, If it is unset then flip the row then it turns to bigger num.
-> Now check each col of all rows, If no.of 0's > no.of 1's in that col then flip the col so that we can
   get bigger values.
-> TC -O(N*M) SC - O(M)

 */
