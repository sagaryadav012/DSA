package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_LC54 {
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> list = new ArrayList<>();

        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;

        int dir=1;
        while(top<=bottom && left<=right)
        {
            if(dir==1)
            {
                for(int i=left;i<=right;i++)
                    list.add(matrix[top][i]);
                dir=2;
                top++;
            }
            else if(dir==2)
            {
                for(int i=top;i<=bottom;i++)
                    list.add(matrix[i][right]);
                dir=3;
                right--;
            }
            else if(dir==3)
            {
                for(int i=right;i>=left;i--)
                    list.add(matrix[bottom][i]);
                dir=4;
                bottom--;
            }
            else if(dir==4)
            {
                for(int i=bottom;i>=top;i--)
                    list.add(matrix[i][left]);
                dir=1;
                left++;
            }

        }

        return list;
    }
}
