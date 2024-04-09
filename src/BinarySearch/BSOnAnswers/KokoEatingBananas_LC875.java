package BinarySearch.BSOnAnswers;

public class KokoEatingBananas_LC875 {
    public static void main(String[] args) {
        int[] piles = {2,2};
        int h = 4;
        System.out.println(minEatingSpeed1(piles, h));
        System.out.println(minEatingSpeed2(piles, h));
    }
    public static int minEatingSpeed1(int[] piles, int h) { // TC - O(max * N) SC -O(1)
        int maxCanEat = 0;
        for(int pile : piles){
            maxCanEat = Math.max(maxCanEat, pile);
        }

        int answer = 0;
        for(int i = 1; i <= maxCanEat; i++){
            long totalHours = 0;
            for(int pile : piles){
                // Take ceil value every time because if pile has 3 bananas and speed is 2/hr,
                // it can't complete all in one hour, 3/2 gives 1 but here it takes 2 hrs so take ceil value.
                totalHours += (long)Math.ceil((double)pile/i);
            }
            if(totalHours <= h) return i;
        }

        return 0;
    }
    public static int minEatingSpeed2(int[] piles, int h) { // TC - O(NlogN) SC - O(1)
        int max = 0;
        for(int pile : piles){
            max = Math.max(pile, max);
        }
        int left = 1, right = max;
        while(left < right){
            int mid = left + (right - left)/2;
            boolean possible = calTotalHours(piles, mid, h);

            if(possible) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    public static boolean calTotalHours(int[] piles, int speed, int h){
        long totalHours = 0;
        for(int pile : piles){
            totalHours += (int)Math.ceil((double)pile/speed);
        }
        return totalHours <= h;
    }
}
/*
Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4


Approach 1 :
-> Here we need to find min speed/hour to eat all bananas with in given time.
-> If pile has 2 bananas, and eating speed is 4 bananas/hr, means she eats 2, can't move to next pile until hours completes.
-> koko eats min 1 banana per hour, and max ? Take ex1, if she eats 12/hr each pile takes 1 hr,
   lets decrease speed, 11/hr -> till it takes pile/hr, if we take 10 4th pile take 2 hrs so till 11 it's
   same, it means max it can eat 11/hr.

-> Run two loops, first loop for eat bananas speed/hr. second loop for calculate to eat pile with given
   speed/hr.

-> TC - O(max * n)

Approach 2 :
-> Observe approach 1, we are checking possible ans from 1 to 11.
-> From 1 to 11, 1 to 3 is not possible and 4 to 11 possible answers, we need to find answer.
-> So do binary search on it. search space is 1 to 11, target min possible answer.

        left        right       mid     calcTotalHours      move
        1           11          6       6 hours             6 < 8, possible ans so take min, right = mid
        1           6           3       10 hours            10 < 8 not possible move right, left = mid + 1
        4           5           4       8 hours             8 <= 8 possible, so move left, right = mid
        4           4           break loop since !left < right

-> why right = mid? not mid - 1. Here right can be maxBananas and for example possible answers are 5 to 10,
   left = 1, right = 9 and mid = 5 here mid is ans and we move left to find min answer if we take right
   as mid-1 then we lost 5, so we need to store 5 somewhere else or don't take do mid-1.

TestCases :
piles = {3,6,7,11} h = 18
piles = [805306368,805306368,805306368] h = 1000000000
piles = 2,2     h = 4
 */
