package QueueAndStacks.LeetCodeMSC;

public class MinInsertions_LC1541 {
    public static void main(String[] args) {
        String s = "()()()()()(";
        System.out.println(minInsertions(s));
    }
    public static int minInsertions(String s) {
        int n = s.length();

        int open = 0;
        int insertions = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){
                open += 1;
            }
            else{
                if(i+1 < n && s.charAt(i+1) == ')'){
                    if(open > 0){
                        open -= 1;
                    }
                    else{
                        // when we reach here that means we have )) but no open so insert open.
                        insertions += 1;
                    }
                    i++; // since we processed i+1 so move to next index
                }else{
                    if(open > 0){
                        insertions += 1; // insert close
                        open -= 1;
                    }
                    else{
                        insertions += 2; // insert open and close
                    }
                }
            }
        }
        insertions += open * 2;
        return insertions;
    }
}
