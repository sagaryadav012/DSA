package BinarySearch.BSOnAnswers;

public class PainterPartitionAndSplitLargestSum_LC410 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
    public static int splitArray(int[] nums, int k) {
        int minSum = 0;
        int maxSum = 0;
        for(int num : nums){
            maxSum += num;
            minSum = Math.max(minSum, num);
        }
        int left = minSum, right = maxSum;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;
            int count = isPossible(nums, mid, k);
            if(count <= k){
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int isPossible(int[] nums, int mid, int k) {
        int countSubArrays = 0;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(sum > mid){
                countSubArrays += 1;
                sum = num;
            }
        }
        countSubArrays += 1;
        return countSubArrays;
    }
}
/*
-> Painters partition and Split Array Largest sum both are same problems.
-> Painters Problem -> they give board sizes, painter has to paint all board, find min time to complete
   all board. painter can paint consecutive boards only, time taken to complete board size 10 is 10 units of time.

   Ex : 10, 20, 30, 40 and painters = 2
   Two painters has to divide boards and paint them, total time consumed is minimized.
   Check possible ways :
    p1           p2             Time Taken
    10           20,30,40 ->    10 and 90 -> max is 90 units to complete all boards
    10,20        30,40    ->    30 and 70 -> max is 70
    10,20,30     40       ->    60 and 40 -> max is 60
    so min of all(90,70,60) is 60 the best way to paint all boards is p1(10,20,30) p2(40)
    So How can we find this?
-> Take some time and check will painter complete with in the taken time.
   For example1 total time is 50, p1 take 10,20 can't take 30 it exceeds taken time.
   p2 takes 30 and p3 takes 40. So, total 3 painters required,but we have 2 painters only.
   so it is not possible.
   Example 2 : totalTime is 70.
   p1 takes 10,20,30
   p2 takes 40
   yes it's possible to complete in 70 units of time, but we need min time. so check values < 70.
-> If we know minTime and maxTime then we can check which is possible answer and then return ans.
-> The min time is what? if there are 3 boards(10,20,30) and 3 painters, what would be the time
   to complete all boards? that is max of all boards -> 30.
   What would be max time? 3 boards(10,20,30) 1 painter then 1 painter has to complete all so total time taken
   is 60.
   MinTime is min of all boards, MaxTime is sum of all boards, answer lies with in this range.

-> Do simply binary search on it.
-> Split array large sum is also same problem, If array length is 5 and k = 5 then ans is max of all 5 sub arrays.
-> If array length is 5 and k = 1 then answer is sum of all.
-> In other cases ans lies between minPossibleSum and maxPossibleSum.

 */