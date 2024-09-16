package Math.ScalerProblems;

public class IsPrimeNumber {
    public static void main(String[] args) {
        int num = 15;
        System.out.println(isPrime1(num));
        System.out.println(isPrime2(num));
    }
    public static boolean isPrime1(int num){ // TC - O(N)
        if(num == 1) return false;
        for(int i = 2; i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static boolean isPrime2(int num){ // TC - O(sqrt(N))
        int count = 0;
        for(int i = 1; i*i <= num; i++){
            if(num % i == 0){
                count += 2;
                if(i == num/i) count -= 1;
            }
        }
        return count == 2;
    }

}
