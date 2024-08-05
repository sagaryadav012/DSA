package Strings;

import java.util.*;

public class SortChars {
    public static void main(String[] args) {
        String s = "vvccbbbaaa";
        sort(s);
    }
    public static void sort(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Pair> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list, (p1, p2) -> p1.freq == p2.freq ? p1.c - p2.c : p2.freq - p1.freq);

        for (Pair pair : list) {
            System.out.println(pair.c+" : "+pair.freq);
        }
    }
}
class Pair{
    char c;
    int freq;
    Pair(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}
