package Math.ScalerProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimes {
    public static void main(String[] args) {
        int num = 50;
        System.out.println(findAllPrimes1(num));
        System.out.println(findAllPrimes2(num));
        System.out.println(findAllPrimes3(num));
    }

    public static List<Integer> findAllPrimes1(int num){ // TC - O(N * N)
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= num; i++){
            if(IsPrimeNumber.isPrime1(i)) primes.add(i);
        }
        return primes;
    }

    public static List<Integer> findAllPrimes2(int num){ // TC - O(N * sqrt(N))
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= num; i++){
            if(IsPrimeNumber.isPrime2(i)) primes.add(i);
        }
        return primes;
    }

    public static List<Integer> findAllPrimes3(int num){ // TC - O(N * log(log(N)))
        List<Integer> primes = new ArrayList<>();

        boolean[] primeNums = new boolean[num+1];
        Arrays.fill(primeNums, true);
        primeNums[0] = primeNums[1] = false;

        for (int i = 2; i*i <= num; i++){
            if(primeNums[i]) {
                for (int j = i*i; j <= num; j += i) {
                    primeNums[j] = false;
                }
            }
        }



        for(int i = 1; i <= num; i++){
            if(primeNums[i]) primes.add(i);
        }
        return primes;
    }
}
