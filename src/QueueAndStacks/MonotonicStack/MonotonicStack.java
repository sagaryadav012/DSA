package QueueAndStacks.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/*
   This class provides methods to find

   1. Nearest left smaller using stack and array
   2. Nearest right smaller using stack and array
   3. Nearest left greater using stack and array
   4. Nearest right greater using stack and array


 */
public class MonotonicStack {
    public static void main(String[] args) {
        int[] nums = {28,11,17,31,23,29};
//        System.out.println(Arrays.toString(NLS_stack(nums)));
//        System.out.println(Arrays.toString(NRS_stack(nums)));
//        System.out.println(Arrays.toString(NLG_stack(nums)));
//        System.out.println(Arrays.toString(NRG_stack(nums)));
        System.out.println(Arrays.toString(NLS_array(nums)));
        System.out.println(Arrays.toString(NRS_array(nums)));
        System.out.println(Arrays.toString(NLG_array(nums)));
        System.out.println(Arrays.toString(NRG_array(nums)));
    }
    public static int[] NLS_stack(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() > num){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(num);
        }
        return res;
    }
    public static int[] NRS_stack(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for(int i = n-1; i >= 0; i--){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() > num){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(num);
        }
        return res;
    }
    public static int[] NLG_stack(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() < num){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(num);
        }
        return res;
    }
    public static int[] NRG_stack(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for(int i = n-1; i >= 0; i--){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() < num){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = -1;
            else res[i] = stack.peek();

            stack.push(num);
        }
        return res;
    }

    public static int[] NLS_array(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        res[0] = -1;
        for(int i = 1; i < n; i++){
            int prevIndex = i-1;
            while(prevIndex >= 0 && nums[prevIndex] > nums[i]){
                prevIndex = res[prevIndex];
            }
            res[i] = prevIndex;
        }
        return res;
    }
    public static int[] NRS_array(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        res[n-1] = n;
        for(int i = n-2; i >= 0; i--){
            int nextIndex = i+1;
            while(nextIndex < n && nums[nextIndex] >= nums[i]){
                nextIndex = res[nextIndex];
            }
            res[i] = nextIndex;
        }
        return res;
    }
    public static int[] NLG_array(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        res[0] = -1;
        for(int i = 1; i < n; i++){
            int prevIndex = i-1;
            while(prevIndex >= 0 && nums[prevIndex] < nums[i]){
                prevIndex = res[prevIndex];
            }
            res[i] = prevIndex;
        }
        return res;
    }
    public static int[] NRG_array(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        res[n-1] = n;
        for(int i = n-2; i >= 0; i--){
            int nextIndex = i+1;
            while(nextIndex < n && nums[nextIndex] <= nums[i]){
                nextIndex = res[nextIndex];
            }
            res[i] = nextIndex;
        }
        return res;
    }
}
