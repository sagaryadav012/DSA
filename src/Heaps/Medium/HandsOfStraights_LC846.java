package Heaps.Medium;

import java.util.*;

public class HandsOfStraights_LC846 {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
        System.out.println(isNStraightHand1(hand, groupSize));
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

    public static boolean isNStraightHand1(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        Arrays.sort(hand);

        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : hand){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        try{
           for(int num : hand){
               if(freqMap.get(num) <= 0) continue;
               for(int i = 0; i < groupSize; i++){
                   int freq = freqMap.get(num+i);
                   if(freq == 0) return false;
                   freqMap.put(num+i, freq - 1);
               }
           }
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}

/*
Approach 2 :
-> no.of cards should de be divisible by groupSize then only we can make groups
-> sort array, store freq of each card.
-> now start from small card and check It is present in map, if yes then check all consecutive present.
   If not present then it throws exception, we catch and return false. If present and freq == 0 then return
   false there only.
-> If those conditions not executed then we can make groups.
 */
