package Arrays.Hard;

import java.util.Arrays;

public class MissingAndRepeating_GFG {
    public static void main(String[] args) {
        int[] arr = {2,2};
        System.out.println(Arrays.toString(findTwoElement(arr, arr.length)));
        System.out.println(Arrays.toString(setPositions(arr))); // best approach
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
    public static int[] setPositions(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] != nums[nums[i] - 1] && nums[i] != i + 1){
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
//        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < n; i++){
            if(nums[i] != i+1) return new int[]{nums[i], i+1};
        }
        return new int[]{};
    }
}
/*
Approach 2 :
-> nums[i] is in between 0 and n, so place all nums at right place means 0 index will have num 1 and
   3 index will have 4 num like that, once we place all in correct order, check if anything is missing
   means nums[i] != i+1 then missing num is i+1 and repeating num is nums[i]
-> Tc - O(N) SC - O(1)

Approach 3 :
-> Add all nums to set, while adding check set.add(num) == false means the num is repeating.
-> We got the num which is repeating, now we need to find missing num.
-> We know all the nums are in between 1 to n, so while adding nums to set, sum all nums except repeating num.
   And assume it as A.
-> Now if nums.length = n then sum of all nums in arr is n*(n+1)/2. Assume this sum as B.
-> Missing num = B - A.
-> Tc - O(N) SC - O(N)
 */
