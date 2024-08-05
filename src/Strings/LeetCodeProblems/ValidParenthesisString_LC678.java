package Strings.LeetCodeProblems;

import java.util.Stack;

public class ValidParenthesisString_LC678 {
    public static void main(String[] args) {
        String s = "((*()*";
        System.out.println(checkValidString(s));
    }
    public static boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
                continue;
            }

            if(c == '*'){
                starStack.push(i);
                continue;
            }

            if(c == ')'){
                if(!stack.isEmpty()){
                   stack.pop();
                }
                else if(!starStack.isEmpty()){
                    starStack.pop();
                }
                else return false;
            }
        }

        while(!stack.isEmpty()){
            if(starStack.isEmpty()) return false;
            int starIndex = starStack.peek();
            int openIndex = stack.peek();

            if(openIndex > starIndex) return false;
            stack.pop();
            starStack.pop();
        }

        return true;
    }
}
/*
Approach 1
-> Take two stacks, one is for ( and another one is for *
-> When we encounter ( store in stack, when we encounter * store it in starStack, when we encounter
   ), balance it with ( or star, if stack is empty then check starStack, if starStack also empty return false.
-> Once we balance all closed brackets, there could be open brackets left. so balance open brackets with stars
   if no stars are left return false. if stars present, then check is it occurred before open bracket,
   if yes return false ex : *( this is not valid, (* this is valid so position important. so store indexes
-> once open balanced with star pop them from stacks and move on next open bracket.
 */
