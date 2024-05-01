package QueueAndStacks.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2_LC503 {
    public static void main(String[] args) {
       int[] nums = {1,2,3,4,3,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for(int i = n-2; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] >= stack.peek()){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i] >= stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = stack.peek();
            }
            else{
                ans[i] = -1;
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}
/*
-> We have to find next greater of each num. we can find with stack and without stack if array is not circular.
-> But here array is circular. Take example 1,2,3,4,3
    Array           :   1   2   3   4   3
    Next Greater    :   2   3   4   -1  4
    for last index, next is 0th index. First find next greater of last num so that it could be easy to find all.
    Iterate over array check curr num > lastNum take this one. Once we find greater of last num, then do normal as we did
    for nextGreater1 question.

    Now try this 1,2,3,4,3,2,1. First we find next greater of last Num(1), when it comes to 2 again we need
    to go over array to find next greater. so it is not possible with this approach.

    indexes :   0   1   2   3   4
    Nums    :   1   2   3   2   1
-> First we find greater for index, answer is index 1. but when it comes to greater of index 3, we have to go beyond n.
-> Observe that next greater current num lies between i+1 to i-1 or -1(it could be the larger value)
-> Find and store greater of n-2 to 0, so that when find greater it will not go to i-1
-> Take stack and store next greater of each num from n-2 to 0.
-> Once we find those, now iterate from n-1 to 0 to find all greater.
-> One thing is that, greater of ith index could be lies between 0 to i-1. so we have to find greater of previous indexes.
 */