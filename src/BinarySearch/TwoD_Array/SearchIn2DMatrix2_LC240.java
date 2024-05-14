package BinarySearch.TwoD_Array;

public class SearchIn2DMatrix2_LC240 {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i=0,j=n-1;

        while(i<m && j>=0)
        {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else
                i++;
        }

        return false;
    }
}
