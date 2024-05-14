package BinarySearch.TwoD_Array;

public class SearchIn2DMatrix_LC74 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
        };
        int target = 30;
        System.out.println(searchMatrix1(matrix,target));
        System.out.println(searchMatrix2(matrix, target));
    }
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i=0,j=n-1;

        while(i<m && j>=0)
        {
            int val = matrix[i][j];
            if(val == target) return true;
            else if(val > target) j--;
            else i++;
        }

        return false;
    }
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m*n-1;

        while(left <= right)
        {
            int mid = left + (right-left)/2;
            int val = matrix[mid/n][mid%n];

            if(val == target) return true;
            else if(val < target) left = mid+1;
            else right = mid-1;
        }

        return false;
    }
}
