package TwoPointerAndSlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets_GFG {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruits(fruits.length, fruits));
    }
    public static int totalFruits(int N, int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int left = 0, right = 0;

        int maxFruits = 0;
        while(right < N){
            baskets.put(fruits[right], baskets.getOrDefault(fruits[right], 0) + 1);

            while(baskets.size() > 2){
                int count = baskets.get(fruits[left]);

                if(count == 1) baskets.remove(fruits[left]);
                else baskets.put(fruits[left], count - 1);

                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        return maxFruits;
    }
}
/*
Approach 1 :
-> Fruit type can be 1 to 10^5. So take int array of size 10^5 + 1 and go through each fruit, increment their
   count.
-> Now take 2 fruit type which have max count.
-> TC - O(N) SC - O(N)

Approach 2 :
-> Use sliding window approach. Take two pointer and assign it to 0. Move right pointer at each step and check
   the window is valid or not. How can check the window is valid or not? Types of fruits with in the window should
   be < 3 type.
-> To know how many types fruits we hold, I use map to check this. map.size() gives types of fruits hold.
-> So every time move right pointer, check window is valid if yes take length, else decrease the window size by
   moving left pointer by one step and check again.
-> Repeat the process until array ends;
 */
