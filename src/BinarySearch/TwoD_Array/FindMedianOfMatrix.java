package BinarySearch.TwoD_Array;

import java.util.Arrays;
import java.util.Collections;

public class FindMedianOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,8,8,8},
                {2,3,4,5,10},
                {9,10,12,14,16}
        };
        System.out.println(findMedian(matrix));
    }
    public static int findMedian(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            left = Math.min(row[0], left);
            right = Math.max(right, row[m-1]);
        }
        int median = (n*m)/2;
        while(left <= right){
            int mid = left + (right - left)/2;
            int smallerCount = smallerEqual(matrix, mid);
            if(smallerCount <= median){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public static int smallerEqual(int[][] matrix, int num){
        int count = 0;
        for (int[] row : matrix) {
            int left = 0;
            int right = row.length - 1;
            int smallerCount = 0;
            while (left <= right){
                int mid = left + (right - left)/2;
                if(row[mid] <= num){
                    smallerCount = mid + 1;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            count += smallerCount;
        }
        return count;
    }
}
/*
-> We have to find median of matrix, Given matrix, each row in matrix is sorted.
-> And R and C is odd.
-> When we multiply odd * odd we get odd. So total no.of elements in matrix are odd number.
-> Median is middle value of sorted values.

Approach 1 :
-> Go through each value, add it to list, sort list and take median.
-> TC - O(N*M) SC - O(N*M)

Approach 2 :
-> TC lower than N*M is NlogM, That means we should not go through each value, have to skip some portion in matrix.
-> We know that each row is sorted, by iterating through first col we get smaller value in matrix,
   By iterating through last col we get larger value in matrix.
-> Now we know least and bigger values in matrix, So median lies between smaller and larger.
-> Observed that no.of elements in matrix are always odd, odd/2 + 1 is median.
-> For example 15 is no.of values in matrix, then 15/2 = 8 is median,
   that means there will be 7 values to left of median and 7 values to right of median.
-> We know smaller and larger, take mid and check how many no.of values less than mid, if mid lies exact mid position
   then that could be the ans;
-> For Example :
        1   5   7   9   11
        2   3   4   5   10
        9   10  12  14  16
   Here Smaller value is 1 and larger value is 16. So median lies between 1 and 16.
   Here total no.of elements are 3*5 = 15 so left to median are 7, right to median are 7.
   Now take any number between 1 and 16, for example I take 14 and check How many numbers are less than 14,
   If 14 have to be median then no.of smaller values should be 7.

   Number from 1 to 16      :           1    2   3   4   5   6   7   8   9   10  11  12  13  14  15  16
   No.of smaller values to curr Num :   1    2   3   4   6   6   7   7   9   11  12  13  13  14  14  15
   We need to find a number that exactly at middle means total no.of elements to left are 7 and right also 7.
   Here for 8, there are 7 smaller values, that means there will be total 7 numbers to left of 8, so 8 is
   the correct ans, but here correct ans is 9. always find the left smaller values are <= middle.
   If smaller values are <= middle then move right,
   If smaller values are > middle then move left

   left         right       mid     no.of smaller values    move
   1            16          8       7                       7 <= 7 -> left = mid + 1
   9            16          12      13                      13 > 7  -> right = mid - 1
   9            11          10      11                      11 > 7  -> right = mid - 1;
   9            10          9       9                       9 > 7   -> right = mid - 1;
   9            8       left > right exit left is ans.

-> Can't we find smaller values <= num using Arrays.BinarySearch() ?
-> Ans No. When Arrays.BinarySearch gives insert position, for example 1,2,4,8,8,8 in this array
   No.of values <= 8 are 6 but If we use Arrays.BinarySearch() it gives insert position 3 and +1 = 4 but here ans is 6
   So binarySearch will not work.

 */
