package QueueAndStacks;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[](){}}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty()){
                    char ch = stack.peek();
                    if(ch == '(' && c == ')') stack.pop();
                    else if(ch == '[' && c == ']') stack.pop();
                    else if(ch == '{' && c == '}') stack.pop();
                    else return false;
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
