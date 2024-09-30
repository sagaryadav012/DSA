package BitManipulation.Medium;

public class MinNoOfOperations {
    public static void main(String[] args) {
        int[] nums = {9,3,4,1,7};
        System.out.println(minOperations(nums));
    }
    public static int minOperations(int[] nums){
        int operations = 0;

        for(int bit = 0; bit < 32; bit++) {
            int zerosCount = 0;
            int onesCounts = 0;
            for (int num : nums) {
                if (((num >> bit) & 1) == 0) zerosCount += 1;
                else onesCounts += 1;
            }
            operations += Math.min(zerosCount, onesCounts);
        }
        return operations;
    }
}
/*
Question : Find min no.of operations to make all values in array equal. In one operation, you can
           flip any bit of any number.

Ex : nums = {1,2,3} convert all to 3, takes two operations.
 */
