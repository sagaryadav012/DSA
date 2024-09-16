package Greedy.Medium;

import java.util.PriorityQueue;

public class FractionalKnapsack_GFG {
    public static void main(String[] args) {
        int n = 10;
        Item[] arr = new Item[n];

        arr[0] = new Item(8, 10);
        arr[1] = new Item(2, 1);
        arr[2] = new Item(10, 7);
        arr[3] = new Item(1, 7);
        arr[4] = new Item(9, 5);
        arr[5] = new Item(7, 1);
        arr[6] = new Item(2, 8);
        arr[7] = new Item(6, 6);
        arr[8] = new Item(4, 8);
        arr[9] = new Item(9, 7);


        int w = 21;
        System.out.println(fractionalKnapsack(w, arr, n));
    }
    public static double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p2.fraction, p1.fraction));
        for(int i = 0; i < n; i++)        {
            Item item = arr[i];
            double value = item.value;
            double weight = item.weight;
            double fractionVal = value/weight;
            pq.add(new Pair(fractionVal, i));
        }

        double totalVal = 0;
        while(!pq.isEmpty() && w > 0){
            Pair p = pq.poll();
            double fraction = p.fraction;
            int index = p.index;
            if(w > arr[index].weight){
                totalVal += arr[index].value;
                w -= arr[index].weight;
                continue;
            }

            totalVal += w * fraction;
            w = 0;
        }
        return totalVal;
    }
}
class Pair{
    double fraction;
    int index;
    Pair(double fraction, int index){
        this.fraction = fraction;
        this.index = index;
    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
