package Strings.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IsomorphicString_LC205 {
    public static void main(String[] args) {

    }
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> setVals = new HashSet<>();

        for(int i = 0; i < n; i++){
            char c1 = S[i];
            char c2 = T[i];
            if(map.containsKey(c1)){
                char ch = map.get(c1);
                if(ch != c2) return false;
            }
            else{
                if(setVals.contains(c2)) return false;
                map.put(c1, c2);
                setVals.add(c2);
            }
        }
        return true;
    }
}
