package Heaps.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReplaceElementWithItsRank_GFG {
    public static void main(String[] args) {
        int[] arr = {2,2,1,8,3,6,8};
        int n = 7;
        System.out.println(Arrays.toString(replaceWithRank1(arr, n)));
        System.out.println(Arrays.toString(replaceWithRank2(arr, n)));
    }
    static int[] replaceWithRank1(int arr[], int N) {
        int n = arr.length;
        int[] copyArr = new int[n];
        System.arraycopy(arr, 0, copyArr, 0, n);
        Arrays.sort(copyArr);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : copyArr){
            if(map.containsKey(num)) continue;
            map.put(num, rank++);
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
    static int[] replaceWithRank2(int arr[], int N) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // it stores val,index. sort pq on value in ascending
        for(int i = 0; i < n; i++){
            pq.add(new int[]{arr[i], i});
        }

        int[] res = new int[n];
        int lastVal = -1;
        int rank = 1;
        while(!pq.isEmpty()){
           int[] pair = pq.poll();
           int val = pair[0];
           int index = pair[1];
           if(lastVal == val){
              res[index] = rank-1;
              continue;
           }
           res[index] = rank;
           rank++;
           lastVal = val;
        }
        return res;
    }
}
/*
Approach 1 :
-> Copy Original array, sort it. Now iterate over sorted array, give them rank and store in Map.
-> Now iterate over original array and get their ranks from map.
-> TC - O(NlogN) SC - O(N)

Approach 2 :
-> Iterate over original array, store val,index in Priority Queue, so that we can fetch one by one in
   sorted, can give rank to them.
-> TC - O(NlogN) SC - O(N)
 */