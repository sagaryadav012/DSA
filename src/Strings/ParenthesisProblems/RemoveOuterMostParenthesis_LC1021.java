package Strings.ParenthesisProblems;

public class RemoveOuterMostParenthesis_LC1021 {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
        System.out.println(removeOuterParentheses1(s));
    }
    public static String removeOuterParentheses(String s) {
        int n = s.length();
        int start = 0, open = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(open == 0 && i > 0){
                sb.append(s, start+1, i-1);
                start = i;
            }

            if(s.charAt(i) == '(') open += 1;
            else open -= 1;
        }
        if(open == 0){
            sb.append(s, start+1, n-1);
        }
        return sb.toString();
    }
    public static String removeOuterParentheses1(String S) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char c : S.toCharArray()) {
            if (c == '(' && balance++ > 0) {
                result.append(c);
            }
            if (c == ')' && balance-- > 1) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
