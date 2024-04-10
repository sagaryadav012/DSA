package QueueAndStacks;

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

            while(!stack.isEmpty() && stack.peek() > 0 &&  stack.peek() < Math.abs(asteroid)){
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() > 0 && stack.peek() == Math.abs(asteroid)){
                stack.pop();
                continue;
            }

            if(stack.isEmpty() || stack.peek() < 0){
                stack.push(asteroid);
            }
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
