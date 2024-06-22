package Strings.ParenthesisProblems;

public class MinAddToMakeParenthesis_LC921 {
    public static void main(String[] args) {
        String s = ")((((";
        System.out.println(minAddToMakeValid(s));
    }
    public static int minAddToMakeValid(String s) {
        int open = 0, insert = 0;
        for(char c : s.toCharArray()){
            if(c == '(') open += 1;
            else{
                if(open > 0) open -= 1;
                else insert += 1;
            }
        }

        if(open > 0) insert += open;

        return insert;
    }
}
