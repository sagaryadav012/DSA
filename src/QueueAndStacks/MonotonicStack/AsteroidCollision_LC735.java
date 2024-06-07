package QueueAndStacks.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision_LC735 {
    public static void main(String[] args) {
        int[] asteroids = {-10,5,6,-10,5,-5,4,9};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids){
            if(stack.isEmpty() || asteroid > 0){
                stack.push(asteroid);
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > 0 &&  stack.peek() < -asteroid){
                stack.pop();
            }

            if(stack.isEmpty() || stack.peek() < 0){
                stack.push(asteroid);
            }

            if(stack.peek() == -asteroid) stack.pop();
        }

        int n = stack.size();
        int[] res = new int[n];

        while(!stack.isEmpty()){
            res[n-1] = stack.pop();
            n -= 1;
        }

        return res;
    }
}
/*
-> Iterate over asteroids, when get +ve asteroid or stack empty push asteroid to stack.
-> Second case when asteroid is -ve, colloid all asteroids that are < abs(currSize), when while loop executes
   it colloids all +ve asteroids which are smaller than current -ve asteroid. while loops stops in following
   4 cases.
   case 1 : All are collided and stack empty.
   case 2 : When we get equal size +ve asteroid.
   case 3 : When we get -ve asteroid.
   case 4 : Greater +ve asteroid.

   In case1, We add current -ve asteroid to stack.
   In case2, We pop peek and don't current asteroid also. since both are collided.
   In case3, Just add current asteroid to stack.
   In case4, current asteroid collided so don't add to stack.
 */
