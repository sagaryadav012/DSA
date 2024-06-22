package Strings.ParenthesisProblems;

public class MinRemoveToMakeValid_LC1249 {
    public static void main(String[] args) {
        String s = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s));
    }
    public static String minRemoveToMakeValid(String s) {
        char[] ar = s.toCharArray();
        int openCount = 0;

        for(int i = 0; i < ar.length; i++){
            if(ar[i] == '(') openCount += 1;
            else if(ar[i] == ')'){
                if(openCount > 0) openCount -= 1;
                else ar[i] = '*';
            }
        }

        int n = ar.length;
        int k = n - 1;
        while(k >= 0 && openCount > 0){
            if(ar[k] == '('){
                ar[k] = '*';
                openCount -= 1;
            }
            k--;
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
