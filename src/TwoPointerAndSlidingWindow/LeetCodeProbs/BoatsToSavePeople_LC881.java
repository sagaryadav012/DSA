package TwoPointerAndSlidingWindow.LeetCodeProbs;

import java.util.Arrays;

public class BoatsToSavePeople_LC881 {
    public static void main(String[] args) {
        int[] people = {3,8,7,1,4};
        int limit = 9;
        System.out.println(numRescueBoats(people, limit));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        int boat_count = 0;

        while(i <= j){
            int weight1 = people[i];
            int weight2 = people[j];
            int total_weight = weight1 + weight2;
            if(total_weight > limit){
                boat_count += 1;
                j--;
            }
            else{
                boat_count += 1;
                i++;
                j--;
            }
        }
        return boat_count;
    }
}
/*
Approach 1 :
-> Carry out all people with min no.of boats.
-> At most a boat can carry 2 people, those weight should be <= limit.
-> How will we choose people? so that can use min no.of boats ?
-> Ex : people {3,8,7,1,4} limit = 9
    step1 : I can't choose 3 and 8, since weight(3+8) > limit so I choose one person 3 : boat_count = 1.
    step2 : Choose 8 only : boat_count = 2.
    step3 : Now I can choose 7 and 1, since weight < limit : boat_count 3
    step4 : Choose 4 : boat count 4.
    Total we need 4 boats to carry out people.
    But 3 boats are enough, Let's check

    Sort array -> 1,3,4,7,8 and limit 9
    Take two pointer, i = 0 and j = n-1;
    Now check can I take these two people i and j, If weight < limit then can take and boat_count += 1.
    else take person at j only. why can't take i person. since i < j and i can be carry out with upcoming j people.
    so take j only.

-> TC - O(NlogN) SC - O(1)
 */