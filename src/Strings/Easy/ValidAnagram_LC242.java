package Strings.Easy;

public class ValidAnagram_LC242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            freq[c - 'a']--;
        }

        for(int val : freq){
            if(val != 0) return false;
        }

        return true;
    }
}
