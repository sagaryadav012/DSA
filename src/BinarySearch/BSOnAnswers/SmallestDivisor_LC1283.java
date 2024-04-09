package BinarySearch.BSOnAnswers;

public class SmallestDivisor_LC1283 {
    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        System.out.println(smallestDivisor1(nums, threshold));
        System.out.println(smallestDivisor2(nums, threshold));
    }
    public static int smallestDivisor1(int[] nums, int threshold) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        for(int i = 1; i <= maxNum; i++){
            if(isPossible(i, nums, threshold)) return i;
        }
        return -1;
    }
    public static int smallestDivisor2(int[] nums, int threshold) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        int left = 1, right = maxNum;
        while (left < right){
            int mid = left + (right - left)/2;
            if(isPossible(mid, nums, threshold)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static boolean isPossible(int divisor, int[] nums, int threshold){
        double totalSum = 0;
        for(int num : nums){
            totalSum += Math.ceil((double)num/divisor);
        }
        return totalSum <= threshold;
    }
}
