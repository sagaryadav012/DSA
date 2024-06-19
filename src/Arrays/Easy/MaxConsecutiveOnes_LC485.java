package Arrays.Easy;

public class MaxConsecutiveOnes_LC485 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int curr = 0;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]==0){
                ans = Math.max(ans , curr);
                curr = 0;
            }
            else{
                curr++;
            }
        }
        return Math.max(ans , curr);
    }
}
