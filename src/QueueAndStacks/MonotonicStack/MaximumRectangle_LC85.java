package QueueAndStacks.MonotonicStack;

import java.util.Arrays;

public class MaximumRectangle_LC85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] mat = new int[n][m];

        for(int i = 0; i < m; i++){
            mat[0][i] = matrix[0][i] == '0' ? 0 : 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = matrix[i][j] == '0' ? 0 : mat[i-1][j] + 1;
            }
        }

        int maxArea = 0;
        for(int[] row : mat){
            int[] LS = findLeftSmaller(row);
            int[] RS = findRightSmaller(row);

            for(int i = 0; i < m; i++){
                int area = (RS[i] - LS[i] - 1) * row[i];
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }
    public static int[] findLeftSmaller(int[] row){
        int m = row.length;
        int[] LS = new int[m];
        LS[0] = -1;

        for(int i = 1; i < m; i++){
            int prev = i-1;
            while(prev >= 0 && row[prev] >= row[i]){
                prev = LS[prev];
            }
            LS[i] = prev;
        }

        return LS;
    }
    public static int[] findRightSmaller(int[] row){
        int m = row.length;
        int[] RS = new int[m];
        RS[m-1] = m;

        for(int i = m-2; i >= 0; i--){
            int next = i+1;
            while(next < m && row[next] >= row[i]){
                next = RS[next];
            }
            RS[i] = next;
        }

        return RS;
    }
}
/*

The best way to approach this solution is to break it down into smaller parts. Let's start with the first array in the matrix: ["1","0","1","0","0"]

We can demonstrate this visually using a histogram:
image

As we can see, we can't represent a rectangle from this dataset.

Now let's go to the next array in the matrix: ["1","0","1","1","1"]

For each value in this array, we want to add it to the value of the previous array, unless we encounter a zero. Then we swap it with a zero. So our array becomes: ["2","0","2","1","1"]

Which is represented by the following histogram:
image

As we can see, this represents a rectangle (outlined in red) with a max size of 3. Let's keep iterating through the matrix, adding the values where we can and setting them to 0 otherwise.

Next array: ["1","1","1","1","1"]

Reflected against our previous array, we get: ["3","1","3","2","2"]

And the associated histogram:
image

A 2x3 rectangle is represented here. Now our max size is at 6.

Let's move on to the last array in the matrix: ["1","0","0","1","0"]

Reflected against our previous array, we get: ["4","0","0","3","0"]

And the histogram:
image

Since a rectangle isn't represented in the histogram, our max size remains 6.

 */