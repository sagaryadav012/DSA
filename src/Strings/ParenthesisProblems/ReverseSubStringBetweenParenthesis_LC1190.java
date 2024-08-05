package Strings.ParenthesisProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseSubStringBetweenParenthesis_LC1190 {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == ')'){
                List<Character> temp = new ArrayList<>();
                while(stack.peek() != '('){
                    temp.add(stack.pop());
                }
                stack.pop();

                for(char ch : temp){
                    stack.push(ch);
                }
            }
            else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }
}
