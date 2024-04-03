package Strings;

import java.util.Arrays;

public class LengthOfLastWord_LC58 {
    public static void main(String[] args) {
        String s = "   fly me   to   the  moon  ";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord1(s));
    }
    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
    public static int lengthOfLastWord1(String s) {
        s = s.trim();
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' ') break;
            count++;
        }
        return count;
    }
}
