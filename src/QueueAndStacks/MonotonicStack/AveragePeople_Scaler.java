package QueueAndStacks.MonotonicStack;

public class AveragePeople_Scaler {
    public static void main(String[] args) {
        int[] A = {28, 11, 17, 31, 23, 29, 8, 26, 8, 35}; // output = 106 but getting 120
        System.out.println(solve(A));
    }
    public static long solve(int[] A) {
        int[] NLS = MonotonicStack.NLS_array(A);
        int[] NRS = MonotonicStack.NRS_array(A);
        int[] NLG = MonotonicStack.NLG_array(A);
        int[] NRG = MonotonicStack.NRG_array(A);

        long count = 0;
        int n = A.length;
        for(int i = 0; i < n; i++){
            int totalSubArrays = (i+1) * (n-i);
            int minCount = (i - NLS[i]) * (NRS[i] - i);
            int maxCount = (i - NLG[i]) * (NRG[i] - i);

            count = count + totalSubArrays - (minCount + maxCount - 1);
        }
        return count;
    }
}
/*
Question :
Average People:
Given an array A representing heights of N students. For every subarray find the number of people say x, who are
neither the shortest nor the tallest in the subarray. Find and return sum of the values x for all sub arrays
of the array.

Problem Constraints:
1<=N<=10^5
1<=A[i]<=10^9

Input Format: The first input is an integer array A
Output Format: Return the sum of the values x for all sub-arrays of the array.

Example Input:
Input 1: A = [11,20,17],  Output: 1
Input 2: A = [30,47,19,23], Output: 4


 Count of an element neither max nor min = total no.of sub arrays it exists -
                                           (no.of sub array it acts as max + no.of sub arrays it acts as min - 1(for common 1sized array)

    x = total no.of occurrence of each element in array.
    y = no.of occurrences of element which acts as min.
    z = no.of occurrences of element which acts as max.

    result = x - (y + z - 1) // Here -1 is to remove duplicates like {19} in this sub array, 19 acts as max as well as min.
    So remove one occurrence.
 */
