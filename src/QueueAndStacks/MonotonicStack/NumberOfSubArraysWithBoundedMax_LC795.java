package QueueAndStacks.MonotonicStack;

public class NumberOfSubArraysWithBoundedMax_LC795 {
    public static void main(String[] args) {
        int[] nums = {2,9,2,5,6};
        int left = 2;
        int right = 8;

        System.out.println(numSubarrayBoundedMax(nums, left, right));
        System.out.println(numSubarrayBoundedMax1(nums, left, right));
    }
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int[] LM = leftMax(nums, n);
        int[] RM = rightMax(nums, n);
        int totalSubArrays = 0;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(num < left || num > right) continue;

            int leftIndex = LM[i];
            int rightIndex = RM[i];
            int maxOccurrance = (i - leftIndex) * (rightIndex - i);
            totalSubArrays += maxOccurrance;
        }
        return totalSubArrays;
    }
    public static int[] leftMax(int[] nums, int n){
        int[] LM = new int[n];
        LM[0] = -1;

        for(int i = 1; i < n; i++){
            int prevIndex = i-1;
            while(prevIndex >= 0 && nums[prevIndex] < nums[i]){
                prevIndex = LM[prevIndex];
            }
            LM[i] = prevIndex;
        }
        return LM;
    }
    public static int[] rightMax(int[] nums, int n){
        int[] RM = new int[n];
        RM[n-1] = n;

        for(int i = n-2; i >= 0; i--){
            int nextIndex = i+1;
            while(nextIndex < n && nums[nextIndex] <= nums[i]){
                nextIndex = RM[nextIndex];
            }
            RM[i] = nextIndex;
        }
        return RM;
    }
    public static int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        int length = nums.length;
        int count = 0;
        int temp = 0;
        int start = 0;

        for (int j = 0; j < length; j++) {
            if (nums[j] >= left && nums[j] <= right) {
                temp = j - start + 1;
                count += temp;
            } else if (nums[j] < left) {
                count += temp;
            } else {
                temp = 0;
                start = j + 1;
            }
        }

        return count;
    }
}

/*
Approach 1:
-> Take each sub array and check max of sub array if it lies in between left and right then count += 1;
-> TC - O(N^3) SC - O(1)

Approach 2 :
-> Track max of each sub array using carry forward technique, If max lies in between left and right
   then count += 1;
-> TC - O(N^2) SC - O(1)

Approach 3 :
-> Iterate over array, check value in between left and right, If yes take leftMax and rightMax that
   means it gives boundaries of that values which acts as max, so now we know no.of sub arrays in
   which the values acts as max and this max lies in between left right. So take count.
-> TC - O(N) SC - O(N+N)

Approach 4 :
-> Use two pointer technique.
-> Take two pointers(start, j), point them to index 0, move j pointer towards right, If value in between
   left and right then take subArray length(no.of subArrays in which current value acts as max).
-> If value < left, then add last count to present totalCount.
-> else if value > right then start = j+1 and tempCount = 0;
-> TC - O(N) SC - O(1)

 */