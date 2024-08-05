package Strings.Medium;

import java.util.HashMap;

public class RomanToInteger_LC13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] ch = s.toCharArray();
        int totalSum = map.get(ch[n-1]);
        int nextVal = totalSum;

        for(int i = n-2; i >= 0; i--){
            char c = ch[i];
            int curVal = map.get(c);
            if(curVal >= nextVal){
                totalSum += curVal;
                nextVal = curVal;
            }
            else{
                totalSum -= curVal;
            }
        }

        return totalSum;
    }
}
