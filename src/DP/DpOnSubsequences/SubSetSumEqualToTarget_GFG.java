package DP.DpOnSubsequences;

public class SubSetSumEqualToTarget_GFG {
    public static void main(String[] args) {
        int[] arr = {2,4,4,3};
        int sum = 5;
        int n = arr.length;
        System.out.println(isSubsetSum(n-1, sum, arr));
        System.out.println(isSubsetSum1(n, arr, sum));
    }
    public static boolean isSubsetSum(int index, int sum, int arr[]){ // TC - O(2^n) SC - O(N)
        if(sum == 0) return true;
        if(index < 0) return false;

        boolean dontTake = isSubsetSum(index - 1, sum, arr);
        boolean take = false;
        if(arr[index] <= sum){
            take = isSubsetSum(index - 1, sum - arr[index], arr);
        }
        return dontTake | take;
    }
    public static boolean isSubsetSum1(int N, int arr[], int sum){ // TC - O(N * Sum) SC - O(Sum)
        // code here
        boolean[] prevRow = new boolean[sum+1];
        prevRow[0] = true;

        for(int i = 0; i < N; i++){
            boolean[] curRow = new boolean[sum + 1];
            curRow[0] = true;
            for(int j = 1; j <= sum; j++){
                boolean dontTake = prevRow[j];
                boolean take = false;
                if(arr[i] <= j) take = prevRow[j - arr[i]];
                curRow[j] = dontTake | take;
            }
            prevRow = curRow;
        }

        return prevRow[sum];
    }
}
