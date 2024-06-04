package Strings.LeetCodeProblems;

public class ExcelTitleToNumber {
    public static void main(String[] args) {
       String s = "CYZ";
        System.out.println(titleToNumber(s));
    }
    public static int titleToNumber(String s){
        int n = s.length();
        int result = 0;
        for(int i = 0; i < n; i++){
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
