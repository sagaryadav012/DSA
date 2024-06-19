package Arrays.Medium;

public class MaxProductSubArray_LC152 {
    public static void main(String[] args) {

    }
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int product = 1;
        int maxProduct = -20;

        for(int num : nums){
            product *= num;
            maxProduct = Math.max(maxProduct, product);
            if(product == 0){
                product = 1;
            }
        }

        product = 1;
        for(int i = n-1; i >= 0; i--){
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if(product == 0){
                product = 1;
            }
        }
        return maxProduct;
    }
}
