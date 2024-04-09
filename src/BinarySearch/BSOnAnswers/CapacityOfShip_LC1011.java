package BinarySearch.BSOnAnswers;

public class CapacityOfShip_LC1011 {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        System.out.println(shipWithinDays(weights, days));
    }
    public static int shipWithinDays(int[] weights, int days) { // TC - O(NlogN) SC - O(1)
        int maxCap = 0;
        int minCap = 1;

        // we have to try all possible capacities.
        // MinCapacity that ship carries is max of all weights.
        // MaxCapacity is sum of all weights. So answer would be with in this range.

        for (int weight : weights) {
            maxCap += weight;
            minCap = Math.max(minCap, weight);
        }

        while(minCap < maxCap){
            int midCap = minCap + (maxCap - minCap)/2;
            if(isPossibleToShip(midCap, weights, days)){
                maxCap = midCap; // mid capacity could be the min answer, so if we do mid - 1 we lost it. we can store in ans or do right = mid.
            }else {
                minCap = midCap + 1;
            }
        }
        return minCap;
    }
    public static boolean isPossibleToShip(int capacity, int[] weights, int days){
        int totalWeight = 0;
        int dayCount = 0;
        for (int weight : weights) {
            totalWeight += weight;
            if(totalWeight > capacity){
                dayCount += 1;
                totalWeight = weight;
            }
        }
        dayCount += 1;
        return dayCount <= days;
    }
}
