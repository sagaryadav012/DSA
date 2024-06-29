package DP.Strings;

public class DecodeWays_LC91 {
    public static void main(String[] args) {
        String s = "226232";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        int n = s.length();
        int prev1 = 1, prev2 = 1;

        for(int i = 1; i < n; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i-1);
            int curr = 0;

            if(c1 >= '1' && c1 <= '9') curr = prev1;

            if(c2 == '1') curr += prev2;
            else if(c2 == '2' && c1 <= '6') curr += prev2;

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
