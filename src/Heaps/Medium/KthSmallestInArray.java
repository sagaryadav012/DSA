package Heaps.Medium;

import java.util.PriorityQueue;

public class KthSmallestInArray {
    public static void main(String[] args) {
        int[] nums = {7,10,4,20,15};
        int k = 4;
        System.out.println(findKthSmallest(nums, k));
        System.out.println(findKthSmallest1(nums, k));
    }
    public static int findKthSmallest(int[] nums, int k){
        int[] freq = new int[100000];
        for(int num : nums){
            freq[num - 1]++;
        }
        int index = 0;
        while(k > 0){
            k -= freq[index++];
        }
        return index;
    }
    public static int findKthSmallest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int num : nums) {
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }

}
