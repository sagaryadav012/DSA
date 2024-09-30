package Greedy.Medium;

public class IncreasingTripletSubSe_LC334 {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        System.out.println(increasingTriplet1(nums));
        System.out.println(increasingTriplet2(nums));
    }
    public static boolean increasingTriplet1(int[] nums) { // TC - O(N^3)
        int n = nums.length;

        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                if(nums[i] > nums[j]) continue;

                for(int k = j+1; k < n; k++){
                    if(nums[j] > nums[k]) continue;
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean increasingTriplet2(int[] nums) { // TC - O(N)
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num <= mid) mid = num;
            else return true;
        }
        return false;
    }
}
