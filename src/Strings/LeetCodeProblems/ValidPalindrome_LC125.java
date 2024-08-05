package Strings.LeetCodeProblems;

public class ValidPalindrome_LC125 {
    public static void main(String[] args) {

    }
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start<end) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(end);

            if(!Character.isLetterOrDigit(currFirst))
                start++;
            else if(!Character.isLetterOrDigit(currLast))
                end--;
            else {
                if(Character.toLowerCase(currFirst) != Character.toLowerCase(currLast))
                    return false;
                else {
                    start++;
                    end--;
                }
            }
        }

        return true;
    }
}
