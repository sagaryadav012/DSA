package TwoPointerAndSlidingWindow.Medium;

public class PermutationInString_LC567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) { // TC - O(N*M)
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for(char c : s1.toCharArray()){
            freqA[c - 'a']++;
        }

        for(int i = 0; i < n; i++){
            freqB[s2.charAt(i) - 'a']++;
        }

        if(isSame(freqA, freqB)) return true;

        int s = 0, e = n;
        while(e < m){
            char c1 = s2.charAt(s);
            char c2 = s2.charAt(e);
            freqB[c1 - 'a']--;
            freqB[c2 - 'a']++;

            if(isSame(freqA, freqB)) return true;

            s++; e++;
        }
        return false;
    }
    public static boolean isSame(int[] freqA, int[] freqB){
        for(int i = 0; i < 26; i++){
            if(freqA[i] != freqB[i]) return false;
        }
        return true;
    }
}

/*
-> To check permutation of s1 exists in s2, Check all substring of s2 size of s1 should be same,
    means the chars in substring and s1 should be same.
-> How do we say s1 is a permutation of s2? When char freq of s1 is same as char freq of s2,
   Order doesn't matter.
-> So take chars freq of s1 and all substring char freq of s2 and compare them.
-> Use sliding window to check each substring of size s1.
 */
