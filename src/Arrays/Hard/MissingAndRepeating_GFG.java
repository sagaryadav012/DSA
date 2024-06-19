package Arrays.Hard;

import java.util.Arrays;

public class MissingAndRepeating_GFG {
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
        System.out.println(Arrays.toString(findTwoElement(arr, arr.length)));
    }
    public static int[] findTwoElement(int arr[], int n) {
        long totalSum = (long) (n * (n + 1)) / 2;
        long totalSquareSum = n * (n+1) * (2*n + 1)/6;

        long sum = 0;
        long squareSum = 0;

        for(int num : arr){
            sum += num;
            squareSum += (num * num);
        }

        long x = totalSum - sum; // x - y
        long y = totalSquareSum - squareSum; // x^2 - y^2 = (x+y)  (x-y)
        long z = y/x;
        long missingNum = (z+x)/2;
        long repeatedNum = z - missingNum;

        return new int[]{(int)repeatedNum, (int)missingNum};

    }
}
