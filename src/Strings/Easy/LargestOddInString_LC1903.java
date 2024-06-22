package Strings.Easy;

public class LargestOddInString_LC1903 {
    public static void main(String[] args) {
        String num  = "345564820";
        System.out.println(largestOddNumber(num));
    }
    public static String largestOddNumber(String num) {
        String ans = "";
        int n = num.length();
        for(int i = n-1; i >= 0; i--){
            char c = num.charAt(i);
            int digit = c - '0';
            if(digit % 2 != 0){
                ans = num.substring(0, i+1);
                break;
            }
        }
        return ans;
    }
}
