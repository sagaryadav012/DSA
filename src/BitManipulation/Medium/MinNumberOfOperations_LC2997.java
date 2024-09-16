package BitManipulation.Medium;

public class MinNumberOfOperations_LC2997 {
    public static void main(String[] args) {
        int[] nums = {2,1,3,4};
        int k = 1;
        System.out.println(minOperations(nums, k));
    }
    public static int minOperations(int[] nums, int k) {
        int resNum = 0;
        for(int num : nums){
            resNum ^= num;
        }
        int operations = 0;
        for(int i = 0; i < 32; i++){
            if(((resNum>>i)&1) != ((k>>i)&1)) operations += 1;
        }
        return operations;
    }
}
/*
Ex : {2,1,3,4} and k = 1
-> We know that xor gives 1 when bits are opposite.
-> So count all 1(set) bits at each position and compare it with bits of k.

positions   3   2   1
    2   ->  0   1   0
    1   ->  0   0   1
    3   ->  0   1   1
    4   ->  1   0   0
sum bits -> 1   2   2
bits of k ->0   0   1

at position 1 -> there are 2 set bits, If we XOR both we get 0 but we need one set at that pos, so add 1 set bit
                 and operations += 1
at position 2 -> there are 2 set bits, If we xor both we get 0. 0 == 0.
at position 3 -> there is only set bit, to get 0 add one more set bit to it(operations++) and Do xor.

-> Instead of doing all these do xor of original array, We get resultNum and compare bits of resultNum with
   bits of K, If they are not equal, we need to make them are equal so operations++;

total operations are 2;

 */