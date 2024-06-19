package Arrays.Medium;

public class ReArrangeArrayElements_LC2149 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int posIndex = 0, negIndex = 1;
        for(int num : nums){
            if(num < 0){
                res[negIndex] = num;
                negIndex += 2;
            }
            else{
                res[posIndex] = num;
                posIndex += 2;
            }
        }
        return res;
    }
}
