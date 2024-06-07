package QueueAndStacks.Hard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache_LC460 {
    public static void main(String[] args) {

        // Not worked re try again
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
class LFUCache {
    Map<Integer, Integer> map;
    Map<Integer, Integer> freqMap;
    PriorityQueue<int[]> pq; // hold key, freq
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        freqMap.put(key, freqMap.get(key) + 1);
        pq.add(new int[]{key, freqMap.get(key)});
        return map.get(key);
    }

    public void put(int key, int value) {
        int size = map.size();
        if(map.containsKey(key) || size < capacity){
            map.put(key, value);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
            pq.add(new int[]{key, freqMap.get(key)});
            return;
        }
        while(!pq.isEmpty() &&  pq.peek()[1] != freqMap.get(pq.peek()[0])){
            pq.poll();
        }
        int[] pair = pq.poll();
        int num = pair[0];
//        int freq = pair[1];

        map.remove(num);
        freqMap.remove(num);

        map.put(key, value);
        freqMap.put(key, 1);
        pq.add(new int[]{key, 1});
    }
}