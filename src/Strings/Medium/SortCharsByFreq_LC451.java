package Strings.Medium;

import java.util.Arrays;

public class SortCharsByFreq_LC451 {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
        System.out.println(frequencySort1(s));
    }
    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] freq = new int[128];

        for(char c : chars){
            freq[c]++;
        }

        for(int i = 0; i < n;){
            char c = ',';
            for(int j = 0; j < 128; j++){
                if(freq[j] > freq[c]) c = (char)j;
            }
            while(freq[c] != 0){
                chars[i++] = c;
                freq[c]--;
            }
        }

        return new String(chars);
    }
    public static String frequencySort1(String s){
        Pair[] pairs = new Pair[128];

        for(int i = 0; i < 128; i++){
            pairs[i] = new Pair((char)i, 0);
        }

        for (char c : s.toCharArray()) {
            pairs[c].freq++;
        }
        Arrays.sort(pairs, (p1, p2) -> p2.freq - p1.freq);
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(index < pairs.length && pairs[index].freq > 0){
            int freq = pairs[index].freq;
            char c = pairs[index].c;
            while(freq > 0){
                sb.append(c);
                freq--;
            }
            index++;
        }
        return sb.toString();
    }
}
class Pair{
    char c;
    int freq;
    Pair(){}
    Pair(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}