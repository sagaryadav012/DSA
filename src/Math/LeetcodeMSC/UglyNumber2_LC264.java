package Math.LeetcodeMSC;

public class UglyNumber2_LC264 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1; // The first ugly number is 1

        // Pointers for multiples of 2, 3, and 5
        int p2 = 0, p3 = 0, p5 = 0;

        // The next multiples of 2, 3, and 5
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        // Fill the array with the first n ugly numbers
        for (int i = 1; i < n; i++) {
            // The next ugly number is the minimum of the three potential next multiples
            int nextUgly = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            ugly[i] = nextUgly;

            // Increment the pointers to avoid duplicates and move forward
            if (nextUgly == nextMultipleOf2) {
                p2++;
                nextMultipleOf2 = ugly[p2] * 2;
            }
            if (nextUgly == nextMultipleOf3) {
                p3++;
                nextMultipleOf3 = ugly[p3] * 3;
            }
            if (nextUgly == nextMultipleOf5) {
                p5++;
                nextMultipleOf5 = ugly[p5] * 5;
            }
        }

        // Return the n-th ugly number
        return ugly[n - 1];
    }
}
/*
-> Find nth ugly number, the number which has prime factors 2,3 or 5 only.




























 */