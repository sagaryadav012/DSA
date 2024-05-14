package BinarySearch.TwoD_Array;

import java.util.Arrays;

public class FindAPeakElement2_LC1901 {
    public static void main(String[] args) {
        int[][] mat = {
                {1,4},
                {3,2}
        };
        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0;
        int right = m-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            int[] pair = max(mat, n, mid);
            int row = pair[0];
            int max = pair[1];
            int prev = safeGet(mid-1, m, mat[row]);
            int next = safeGet(mid+1, m, mat[row]);
            if(prev < max && max > next) return new int[]{row, mid};

            if(prev > max) right = mid-1;
            else left = mid + 1;
        }
        return new int[]{};
    }
    public static int safeGet(int index, int m, int[] row){
        if(index < 0 || index >= m) return -1;
        return row[index];
    }
    public static int[] max(int[][] mat, int n, int c){
        int maxVal = -1;
        int row = -1;
        for(int i = 0; i < n; i++){
            int val = mat[i][c];
            if(val > maxVal){
                maxVal = val;
                row = i;
            }
        }
        return new int[]{row, maxVal};
    }
}
/*
Approach 1 :
-> Go through each cell and check 4 sides of cell, if it is greater return row anda col.
-> TC - O(N*M*4) SC - O(1)

Approach 2 :
-> Go through each cell, find max val in matrix.
-> Tc - O(N*M) SC - O(1)

Approach 3 :
-> TC less than N*M means we have to apply binary search on matrix, means we should not go through each cell,
   can skip some portion in matrix.
-> Need to check each cell to figure it out the cell is peak or not.
-> Take a random col, find max in that, the val is greater than top and bottom, now need to check left and right,
   Now this boiled down to peak in one d array, we can easily find which side part can skip.
-> Search space is col 0 to m-1, Apply BS to find peak.
   Ex :

        1   2   3   4   5
        6   7   8   9   10
        11  12  13  14  15
        16  15  11  10  12

       left     right   middle     max
       0        4       2          13  -> 13 < 14  -> If move right side it sure that we can get peak since ends are -1
       3        4       3          14  -> 14 < 15 -> move right side.
       4        4       4          15  -> 15 is greater than left and right so return 15.
 */
