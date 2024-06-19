package Arrays.Easy;

public class MajorityElement_169 {
    public static void main(String[] args) {

    }
    public static int majorityElement(int[] nums) {
        int count = 0;
        int res = nums[0]; // can be anything
        for(int num : nums){
            if(count == 0){
                count = 1;
                res = num;
            }
            else if(res == num){
                count += 1;
            }
            else count -= 1;
        }
        return res;
    }
}
