package TwoPointerAndSlidingWindow.LeetCodeProbs;

public class GrumpyBookStore_LC1052 {
    public static void main(String[] args) {
        int[] customers = {4,10,20};
        int[] grumpy = {1,1,0};
        int minutes = 2;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) { // TC - O(N+N) SC - O(1)
        int n = customers.length;

        int maxCustomers = 0;
        for(int i = 0; i < minutes; i++){
            if(grumpy[i] == 1)
                maxCustomers += customers[i];
        }

        int count = maxCustomers;
        for(int i = minutes; i < n; i++){
            if(grumpy[i] == 1) count += customers[i];
            if(grumpy[i-minutes] == 1) count -= customers[i-minutes];

            maxCustomers = Math.max(maxCustomers, count);
        }

        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0) maxCustomers += customers[i];
        }

        return maxCustomers;
    }
}
/*
Approach 1 :
-> Here minutes is window size of array, so iterate over array and take maxSum of each window sums.
-> That means owner has one choice so it's completed, and track start and end index of that maxSum window.
-> Now make customers = 0 of that window, iterate over array sum += customers[i] where grumpy[i] == 0.
-> But above approach fails at this test case.

Customers = {4,10,20}
grumpy = {1,1,0}
minutes  = 2;
        window      maxCustomers
        0 - 1       14
        1 - 2       30
-> Now maxCustomers  = 30, iterate over array and add customers at grumpy[i] == 0.
-> We don't find anything and returns 30. But correct ans is 34 we can choose all. When owner has one choice choose
   index 0 and 1. at index 2 grumpy is 0. so we obviously choose that one.

Approach 2 :
-> Track customers : count customers of window size where grumpy[i] == 1;
-> If we know which window has max customers where owner is grumpy.
-> so we use sliding window approach to cal customers. Once we know customers count, now count all customers at
   grumpy[i] == 0 and that count to customers we gained from choice.
 */