package TwoPointerAndSlidingWindow.Medium;

public class LongestRepeatingCharacterReplacement_LC424 {
    public static void main(String[] args) {
        String s = "BXYAAYZW";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
    public static int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int windowSize = 0;
        int start = 0;
        int end = 0;

        int[] frequencies = new int[26];
        int maxFrequency = 0;

        while(end < chars.length){
            maxFrequency = Math.max(maxFrequency , ++frequencies[chars[end] - 'A']);
            while(end + 1 - start - maxFrequency > k){
                frequencies[chars[start] - 'A']--;
                start += 1;
            }
            windowSize = Math.max(windowSize , end + 1 - start);
            end += 1;
        }

        return windowSize;
    }
}
/*
-> Given String, find the longest substring which has only one character and you can replace at most k characters.
-> For example String s = "AAXYZ" k = 2. here freq of A = 2 and freq of other chars = 1;
   If we replace max freq char with k chars, do we get maxLen ? No
   Replace A with other chars(X,Y,Z) XXXYZ max substring which has only one char is length 3;
   If we change chars except maxFreq, we get max window. AAAAZ here len is 4.
-> So take two pointer, move right pointer to right and check the window is valid.
   Window is valid when only window length - maxFreq <= k. That means if k = 2 length is 5, and maxFreq = 3
   then there is one char repeated 3 times and two other chars so change two chars to maxFreq char so that
   window of substring has same chars and it's valid.
-> Why shouldn't we update maxFreq again when move left pointer ? There is no point in downgrading maxFreq
   Since we don't get maxLen.
 */