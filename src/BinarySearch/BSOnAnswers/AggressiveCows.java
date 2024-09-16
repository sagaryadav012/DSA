package BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] positions = {0,3,4,7,10,9};
        int cows = 4;
        System.out.println(minDistance(positions, cows));
    }
    public static int minDistance(int[] positions, int cows){
        int n = positions.length;
        Arrays.sort(positions);
        int min = Integer.MAX_VALUE;
        int max = positions[n-1] - positions[0];

        for(int i = 1; i < n; i++){
            min = Math.min(min, positions[i] - positions[i-1]);
        }

        int left = min, right = max;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(positions, cows, mid)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] Positions, int cows, int minDistance){
        int cows_placed = 1;
        int last_position = Positions[0];

        for(int i =1; i < Positions.length; i++){
            int distance = Positions[i] - last_position;
            if(distance >= minDistance){
                cows_placed += 1;
                last_position = Positions[i];
            }
        }
        return cows_placed >= cows;
    }
}
/*
Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls.
You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance.


 */