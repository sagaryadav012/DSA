package Heaps.Medium;

import java.util.PriorityQueue;

public class KthLargestInArray_LC215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 6;
        System.out.println(findKthLargest(nums, k));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public static int findKthLargest1(int[] nums, int k) {
        int freq[] = new int[20001];

        for(int curNum : nums){
            freq[10000+curNum]++;
        }
        int index = 20000;
        while(k>0){
            k -= freq[index];
            index--;
        }

        return index-10000+1;
    }
}
/*
Approach 1 :
-> Sort array and take nums[n-k] value;
-> TC - O(NlogN) SC - O(1)

Approach 2 :
-> Put all nums in PQ one by one, If size > k then poll it from PQ.
-> Max size of PQ is K+1, So TC - O(NlogK) SC - O(K)

Approach 3 :
-> -10^4 <= nums[i] <= 10^4 so take array of size 20001 it covers -1 to -10^4 Plus 0 to 10^4
-> Traverse through each num increment the index of value of num.
-> Now iterate from back and decrement k value while k > 0.
-> TC - O(N) SC - O(20001)
 */
