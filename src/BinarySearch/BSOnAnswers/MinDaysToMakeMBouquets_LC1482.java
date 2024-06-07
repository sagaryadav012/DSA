package BinarySearch.BSOnAnswers;

public class MinDaysToMakeMBouquets_LC1482 {
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(minDays1(bloomDay, m, k));
        System.out.println(minDays2(bloomDay, m, k));
        System.out.println(isPossible(m, k, bloomDay, 12));
    }
    public static int minDays1(int[] bloomDay, int m, int k) { // TC - O(N*N)
        int n = bloomDay.length;
        if(n < m*k) return -1;

        int maxDay = 0;
        for(int day : bloomDay){
            maxDay = Math.max(day, maxDay);
        }


        for(int i = 1; i <= maxDay; i++){
            int adjacent = 0;
            int madeBouquets = 0;

            for (int day : bloomDay) {
                int ans = day - i;

                if (ans <= 0) adjacent += 1;
                else adjacent = 0;

                if (adjacent == k) {
                    madeBouquets += 1;
                    adjacent = 0;
                }

                if (madeBouquets == m) return i;

            }

        }
        return -1;
    }
    public static boolean isPossible(int m, int k, int[] bloomDay, int currentDay){
        int adjacent = 0;
        int madeBouquets = 0;

        for (int day : bloomDay){
            if (currentDay - day >= 0) adjacent += 1;
            else adjacent = 0;

            if (adjacent == k) {
                madeBouquets += 1;
                adjacent = 0;
            }

            if (madeBouquets == m) return true;

        }
        return madeBouquets == m;
    }
    public static int minDays2(int[] bloomDay, int m, int k) { // TC - O(NlogN)
        int n = bloomDay.length;
        if(n < m*k) return -1;

        int maxDay = 0;
        for(int day : bloomDay){
            maxDay = Math.max(day, maxDay);
        }

        int startDay = 1, endDay = maxDay;

        while(startDay < endDay){
            int mid = startDay + (endDay - startDay)/2;
            if(isPossible(m, k, bloomDay, mid)){
                endDay = mid;
            }
            else startDay = mid + 1;
        }
        return startDay;
    }
}

/*
-> We need to find min days to make m bouquets with k adjacent flowers.
-> Also given bloomDays, ith flower will bloom in bloomDay[i] day.
-> First of all check can we make m bouquets with given flowers ?
   if flowers given 5, we need to make 3 bouquets with 2 adjacent flowers. Can we make 3 bouquets?
   Answer is no, it is not possible, it's possible when only boolmDay size(flowers given) >= m*k

Approach 1 :
-> Check each day, how many flowers bloomed up, and can we m bouquets with bloomed up flowers.
-> We need min answer so start from day 1, and end day is what? At what all flowers bloomed up so nothing is left?
   Max num in bloomDays is tha last day, so nothing is left to bloom.
-> so iterate from 1 to max and check is it possible to make.

Approach 2 :
-> It is same as approach1, but slight optimisation can do. We are checking each day.
-> And we are checking consecutive, sorted day. So can we apply binary search here?
-> Yes, can optimise outer loop using binary search. when it is not possible increase day so move to right means left = mid + 1;
-> When it's possible move left -> right = mid. Here don't take mid-1 because mid could be min possible ans
   if take right = mid-1, we never visit it again and we lost answer.



 */