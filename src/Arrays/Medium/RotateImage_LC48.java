package Arrays.Medium;

public class RotateImage_LC48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++)
                matrix[j][i] = (matrix[i][j] + matrix[j][i])-(matrix[i][j] = matrix[j][i]);
        }

        for(int i=0;i<m;i++){
            int s=0;
            int e=n-1;
            while(s<e){
                matrix[i][e] = (matrix[i][s]+matrix[i][e])-(matrix[i][s]=matrix[i][e]);
                s++;e--;
            }
        }
    }
}
