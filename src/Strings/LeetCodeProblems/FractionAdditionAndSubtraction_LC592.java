package Strings.LeetCodeProblems;

public class FractionAdditionAndSubtraction_LC592 {
    public static void main(String[] args) {
        String expression = "4/2-6/3+16/4";
        System.out.println(fractionAddition(expression));
    }
    public static String fractionAddition(String expression) {
        int n = expression.length();
        int i = 0;

        int numerator = 0, denominator = 1;

        while(i < n){
            int sign = 1; // find sign
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }

            int num = 0; // find numerator value
            while(i < n && Character.isDigit(expression.charAt(i))){
                num = num * 10 + expression.charAt(i) - '0';
                i++;
            }

            i++; // skip '/' symbol

            int denom = 0; // find denominator value;
            while(i < n && Character.isDigit(expression.charAt(i))){
                denom = denom * 10 + expression.charAt(i) - '0';
                i++;
            }

            // a/b + c/d -> numerator = a*d + b*c and denominator = b*d
            numerator = numerator * denom + sign * num * denominator;
            denominator *= denom;

            int gcdVal = gcd(Math.abs(numerator), denominator);

            // get gcd value, divide numerator and denominator with gcd value. ex 16/4 -> gcd = 4 -> 4/1
            numerator /= gcdVal;
            denominator /= gcdVal;
        }

        return numerator+"/"+denominator;
    }
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
