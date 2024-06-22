package Strings.ParenthesisProblems;

public class MaxNestedDepth_LC1614 {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int maxDepth = 0;
        int count = 0;
        for(char c : chars){
            if(c == '('){
                count += 1;
                maxDepth = Math.max(count, maxDepth);
            }
            else if(c == ')'){
                count -= 1;
            }
        }
        return maxDepth;
    }
}
