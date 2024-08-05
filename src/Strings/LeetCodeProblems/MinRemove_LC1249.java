package Strings.LeetCodeProblems;

import java.util.Stack;

public class MinRemove_LC1249 {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s));
        System.out.println(minRemoveToMakeValid1(s));
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char c : s.toCharArray()){
            stack.push(c);

            if(c == '(') count += 1;
            else if(c == ')') count -= 1;

            if(count < 0){
                stack.pop();
                count += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c == '(' && count > 0){
                count -= 1;
                continue;
            }

            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public static String minRemoveToMakeValid1(String s){ // TC - O(N) SC - O(N)
        char[] ar = s.toCharArray();
        int balanced = 0;

        for(int i = 0; i < ar.length; i++){
            if(ar[i] == '(') balanced += 1;
            else if(ar[i] == ')') balanced -= 1;

            if(balanced < 0){
                ar[i] = '*';
                balanced += 1;
            }
        }

        for(int i = ar.length - 1; i >= 0; i--){
            if(ar[i] == '(' && balanced > 0){
                ar[i] = '*';
                balanced -= 1;
            }
        }

        int idx = 0;
        for(int i = 0; i < ar.length; i++){
            if(ar[i] != '*'){
                ar[idx++] = ar[i];
            }
        }

        return String.valueOf(ar).substring(0, idx);
    }
}
/*
Approach 2 :
-> Convert string to char Array.
-> Count open and closed brackets, if closed > opened it means it's invalid parenthesis.
-> So, when we encounter ( balance += 1, or ) then balance -= 1.
-> When balance < 0 means opened < closed means invalid parenthesis. so replace it with * to remove it later.
-> And now check if opened > closed ex : (())(( this is also not valid. so traverse from back and check
   if balance > 0 and char c = ( then replace it with *
-> Now remove all *'s.
 */