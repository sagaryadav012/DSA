package Greedy.Medium;

import java.util.Stack;

public class ValidParenthesisString_LC678 {
    public static void main(String[] args) {
        String s = "(*)";
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
-> When string is valid? When Open parenthesis have corresponding close parenthesis or close parenthesis
   have open parenthesis before it.
-> Use stack to validate string.
-> There are 3 chars that we have in string those are (, ), *
-> When we get open parenthesis just to push to stack, because open needs to valid close so wait for close.
-> When we get close check for open if it's there in stack pop out, since it is valid.
-> When we get *, it can be "" or ( or ). We have 3 options but we don't know which one to choose when.
-> If we have enough open and close parenthesis then we don't need stars we can assume them as "" empty string.
-> So store stars somewhere, If you don't have enough ( or ) then we use stars for those.

-> Iterate over string, If we get ( just push to stack, If we get close first check for opens are available.
   If yes pop out, If not available check for stars, If available then pop out since *) is valid. If both are
   not available then it is not valid string so return false;
-> last edge case :
    If we have left with opens and stars, validate those string.
    There could be two possibilities -> ((** or (*(* -> here star is close ( like -> (()) and ()()
    If we get stars before and opens later like **(( or *( it is not valid so check last, If we still have
    opens, check are there any stars available It yes, check their position. So when we store ( or * store their
    indexes.
 */