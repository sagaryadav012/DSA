package QueueAndStacks.MonotonicStack;

import java.util.LinkedList;
import java.util.Stack;

public class RemoveKDigits_LC402 {
    public static void main(String[] args) {
        String num = "10";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }
    public static String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Integer> stack = new Stack<>();
        for(char c : num.toCharArray()){
            int digit = c - '0';
            while(!stack.isEmpty() && stack.peek() > digit && k > 0){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while(k > 0){ // Dry run 8888, k =2 and 1000001 k = 3
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append((char)(stack.pop() + '0'));
        }
        while(sb.length() != 0 && sb.charAt(sb.length() - 1) == '0'){ // dry run num = 20045 k = 1 and num = 10 and k = 1
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
/*
-> We have to remove k digits from num to make num as min as possible.
-> Which digit if we remove so that num could be smaller? If num is 10^6, we remove left most digit then it become 10^5.
-> For example num is 894 remove one digit to become num as min as possible, we know that remove left most, so it become small but
   if remove 8, num is 94 but possible ans is 84. So traverse from right and remove k greater values.
-> Use stack to remove k greater nums of current num.
-> First remove left greater values, If still k > 0 then remove values from right, since they will be in ascending order.

 */