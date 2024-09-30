package Sorting.Medium;

public class KthSmallInLexicographical_LC440 {
    public static void main(String[] args) {
        int n = 100;
        int k = 10;
        System.out.println(findKthNumber(n, k));
    }
    public static int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // Start from the 1st number, so decrement k

        while (k > 0) {
            int steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                // We can skip this prefix
                curr += 1;
                k -= steps;
            } else {
                // Go down one level in the tree (lexicographically)
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    // Count how many numbers are between the prefix "curr" and "next" (exclusive)
    private static int countSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += (int) (Math.min(n + 1, next) - curr);
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
