package LeetcodeMSC;

public class WonderfulSubStrings_LC1915 {
    public static void main(String[] args) {
        String word = "aabb";
        System.out.println(wonderfulSubstrings(word));
    }
    public static long wonderfulSubstrings(String word) { // TC - O(N^2)*26  SC - O(1)
        int n = word.length();
        long strings = 0;
        for(int i = 0; i < n; i++){
            int[] freq = new int[26];

            for(int j = i; j < n; j++){
                char c = word.charAt(j);
                freq[c - 'a']++;
                int countOdd = 0;
                for(int k = 0; k < 26; k++){
                    if(freq[k]%2 != 0) countOdd += 1;
                }
                if(countOdd <= 1) strings += 1;
            }
        }
        return strings;
    }
    public static long wonderfulSubstrings1(String word) {
        int[] count = new int[1024];
        count[0] = 1;
        long res = 0;
        int prefix = 0;
        for(char c : word.toCharArray()){
            prefix ^= 1 << c-'a';
            res += count[prefix];

            for(int i = 0; i < 10; i++){
                res += count[prefix ^ 1 << i];
            }

            count[prefix]++;
        }
        return res;
    }
}
/*
Approach 1 :
-> Generate each substring, count each char freq, if no.of odd freq are <= 1 then we can consider
   that substring is wonderful.
-> TC - O(N^2) SC - O(1)



 */