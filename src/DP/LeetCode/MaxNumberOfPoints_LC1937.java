package DP.LeetCode;

import java.util.Arrays;

public class MaxNumberOfPoints_LC1937 {
    public static void main(String[] args) {
        int[][] points = {
                {2,2},
                {2,2},
                {2,2}
        };
        System.out.println(maxPoints(points));
    }
    public static long maxPoints(int[][] points) { // TC - O(M * N^2)
        int n = points.length;
        int m = points[0].length;
        long[][] res = new long[n][m];

        for(int c = 0; c < m; c++){
            res[0][c] = points[0][c];
        }

        for(int r = 1; r < n; r++){
            for(int c1 = 0; c1 < m; c1++){
                for(int c2 = 0; c2 < m; c2++){
                    res[r][c1] = Math.max(res[r][c1], points[r][c1] + res[r-1][c2] - (Math.abs(c2-c1)));
                }
            }
        }

        long ans = 0;
        for(int c = 0; c < m; c++){
            ans = Math.max(ans, res[n-1][c]);
        }

        for(long[] ar : res){
            System.out.println(Arrays.toString(ar));
        }
        return ans;
    }
    public static long maxPoints1(int[][] points) { // TC - O(M * N)
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];

        for(int c = 0; c < n; c++){
            dp[c] = points[0][c];
        }

        for(int r = 1; r < m; r++){
            long[] left = new long[n];
            long[] right = new long[n];
            long[] newDp = new long[n];

            left[0] = dp[0];
            for(int c = 1; c < n; c++){
                left[c] = Math.max(left[c-1] - 1, dp[c]);
            }

            right[n-1] = dp[n-1];
            for(int c = n-2; c >= 0; c--){
                right[c] = Math.max(right[c+1] - 1, dp[c]);
            }

            for(int c = 0; c < n; c++){
                newDp[c] = points[r][c] + Math.max(left[c], right[c]);
            }

            dp = newDp;
        }

        long ans = 0;
        for(int c = 0; c < n; c++){
            ans = Math.max(ans, dp[c]);
        }

        return ans;
    }
}
