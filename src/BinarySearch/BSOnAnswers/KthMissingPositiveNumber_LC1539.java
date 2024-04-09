package BinarySearch.BSOnAnswers;

public class KthMissingPositiveNumber_LC1539 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        System.out.println(findKthPositive1(arr, k));
        System.out.println(findKthPositive2(arr, k));
        System.out.println(findKthPositive3(arr, k));
    }
    // TC - O(N) SC - O(N)
    public static int findKthPositive1(int[] arr, int k) {
        boolean[] nums = new boolean[1001]; // 1 <= arr[i] <= 1000
        for (int num : arr) {
            nums[num] = true;
        }
        int count = 0;
        for(int i = 1; i <= 1000; i++){
            if(!nums[i]) count += 1;
            if(count == k) return i;
        }
        return 1001 + k;
    }
    // TC - O(N) SC - O(1)
    public static int findKthPositive2(int[] arr, int k) {
        for (int i : arr) {
            if(i <= k) k += 1;
            else break;
        }
        return k;
    }

    // TC - O(LogN) SC - O(1)
    public static int findKthPositive3(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = n-1;

        int missingCount = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            int num = arr[mid];
            missingCount = num -(mid+1);

            if(missingCount < k) left = mid + 1;
            else right = mid - 1;
        }

        return k + right + 1; //arr[right] + (k - missingCount);
    }

}
/*
Binary search approach

-> To apply BS we need range and target but here we don't target(Kth Missing Number)
-> Array is sorted, if we know how many numbers are missed till index then we can know which side to move.
-> Ex : 2,3,4,7,11 and k = 5

                Indexes :   0       1       2       3       4
                Numbers :   2       3       4       7       11
  Missing Numbers Count :   1       1       1       3       6
  MissingNumbersCount = nums[i] - (index + 1)

        left        right       middle     move
        0           4           2          Missing[2] < k -> 1 < 5 -> left = mid + 1
        3           4           3          Missing[3] < k -> 3 < 5 -> left = mid + 1
        4           4           4          Missing[4] > k -> 6 > 5 -> right = mid - 1;
        4           3           break(left <= right)

        MissingNumber = nums[right] + (k - MissingNumberCount) or k + right + 1
 */
