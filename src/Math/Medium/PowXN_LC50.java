package Math.Medium;

public class PowXN_LC50 {
    public static void main(String[] args) {
        double x = 2;
        int n = -2;
        System.out.println(myPow(x, n));
    }
    public static double myPow(double x, int n) {
        double powVal = fastPow(x, Math.abs(n));
        if(n < 0) return 1/powVal;

        return powVal;
    }
    public static double fastPow(double x, int p){
        if(p == 0) return 1;
        double half = fastPow(x, p/2);

        if(p % 2 == 0){
            return half * half;
        }
        return x * half * half;
    }
}
