package DP.TwoD_DP;

public class MinFallingPathSum_LC931 {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,1,3},
                {6,5,4},
                {7,8,9}
        };
        System.out.println(minFallingPathSum(matrix));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int r = 1; r < m; r++){
            for(int c = 0; c < n; c++){
                int i = matrix[r-1][c];
                int j = c > 0 ? matrix[r-1][c-1] : Integer.MAX_VALUE;
                int k = c < n-1 ? matrix[r-1][c+1] : Integer.MAX_VALUE;

                matrix[r][c] += Math.min(i, Math.min(j,k));
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int c = 0; c < n; c++){
            minSum = Math.min(matrix[m-1][c], minSum);
        }

        return minSum;
    }
}
