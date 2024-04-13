package QueueAndStacks.MonotonicStack;

public class SumOfSubArrayMins_LC907 {
    public static void main(String[] args) {
       int[] arr = {11,81,94,43,3};
        System.out.println(sumSubarrayMins1(arr));
        System.out.println(sumSubarrayMins2(arr));
    }
    public static int sumSubarrayMins1(int[] arr) { // TC -O(N^2) SC -O(1)
        int n = arr.length;
        int mod = 1000000009;
        long sum = 0;

        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                min = Math.min(min, arr[j]);
                sum = (sum + min)%mod;
            }
        }
        return (int)sum%mod;
    }
    public static int sumSubarrayMins2(int[] arr) { // TC -O(N) SC -O(N)
        int n = arr.length;
        int mod = 1000000007;
        int[] leftMin = new int[n];
        leftMin[0] = -1;
        int[] rightMin = new int[n];
        rightMin[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > arr[i]) {
                prev = leftMin[prev];
            }

            leftMin[i] = prev;
        }

        for (int i = n - 2; i >= 0; i--) {
            int next = i + 1;
            while (next < n && arr[next] >= arr[i]) {
                next = rightMin[next];
            }

            rightMin[i] = next;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int minOccurance = (i - leftMin[i]) * (rightMin[i] - i);
            sum = (sum + ((long) minOccurance * arr[i])) % mod;
        }

        return (int) (sum % mod);
    }
}
/*
Approach 2 :
-> Find each value act as in how many arrays, if we know the count then we can calculate sum. count * value.
    For example : 3   1   2   4. Here 1 act as min in 6 sub arrays. [3,1] [3,1,2] [3,1,2,4] [1] [1,2] [1,2,4].
-> So how we find this count? value can act as min until it gets value less than this.
-> So find left smaller and right smaller indexes. for example value 2 in above example,
   left smaller index 1 and right smaller index 4(out of bound) so with in this range 2 act as min.
-> Take example 1 in above array, left smaller index -1 and right smaller index 4. 1 act as min in range from 0 ro 3,
   index of 1 is 1 -> 1 - leftSmallerIndex(-1) * rightSmallerIndex(4) - 1 = 2 * 3 = 6 * value = 6 * 1 = 6.
   value one contributes sum 6 to totalSum.
-> Find sum of all values that contributes to totalSum.

 edge case : 71 55 82 55, Dry run this to check why we use >= in rightMin.
 >= have to use either leftMin or RightMin to avoid duplicate calculations
 */