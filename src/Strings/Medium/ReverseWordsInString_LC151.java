package Strings.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString_LC151 {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        int n = s.length();
        int i = 0, j = 0;
        List<String> words = new ArrayList<>();
        while(i < n && s.charAt(i) == ' '){ // this is for first empty space in string
            i++;
        }
        j = i; // once find chars after empty space assign i and j pointer to it.
        while(j < n){
            while(j < n && s.charAt(j) != ' ') j++; // find complete word
            String word = s.substring(i, j);
            words.add(word);
            while(j < n && s.charAt(j) == ' ') j++; // move to next word, skip empty spaces
            i = j; // assign starting point of word to i
        }
        Collections.reverse(words);
        System.out.println(words);
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word+" ");
        }
        sb.deleteCharAt(sb.length() - 1); // remove last empty space
        return sb.toString();
    }
}
