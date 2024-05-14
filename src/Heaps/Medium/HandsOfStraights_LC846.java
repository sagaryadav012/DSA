package Heaps.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandsOfStraights_LC846 {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        int totalGroups = n / groupSize;

        Arrays.sort(hand);
        List<List<Integer>> groups = new ArrayList<>();
        for(int i = 0; i < totalGroups; i++){
            groups.add(new ArrayList<>());
        }

        for(int value : hand){
            boolean isAdded = false;
            for(List<Integer> group : groups){
                if(group.size() >= groupSize) continue;
                if(group.isEmpty() || group.get(group.size() - 1) + 1 == value){
                    group.add(value);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded) return false;
        }
        return true;
    }
}
