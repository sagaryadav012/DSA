package Heaps.Hard;

import java.util.PriorityQueue;

public class MedianFinder_LC295 {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder_LC295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        minHeap.add(num);
        if(maxHeap.size() < minHeap.size()){
            int val = minHeap.poll();
            maxHeap.add(val);
        }
        if(maxHeap.size() > minHeap.size()){
            int val = maxHeap.poll();
            minHeap.add(val);
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }

        return (double)minHeap.peek();
    }
}
