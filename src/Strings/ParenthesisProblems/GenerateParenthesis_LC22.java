package Strings.ParenthesisProblems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_LC22 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    public static void generate(List<String> ans, StringBuilder sb, int openCount, int closeCount, int n){
        if(closeCount > openCount) return;
        if(openCount == n && closeCount == n){
            ans.add(sb.toString());
        }
        if(openCount > n) return;

        generate(ans, sb.append("("), openCount+1, closeCount, n);
        sb.deleteCharAt(sb.length() - 1);
        generate(ans, sb.append(")"), openCount, closeCount+1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
