package SwiggyQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class OrderAssignService {
    public static void main(String[] args) {
        int N = 3;
        int M = 5;
        int[] arrivalTime = {2,4,1,8,9};
        int[] deliveryTime = {7,9,2,4,5};
        System.out.println(Arrays.toString(assignOrder(N, M, arrivalTime, deliveryTime)));
    }
    public static int[] assignOrder(int N, int M, int[] arrivalTime, int[] deliveryTime){
        int[][] orders = new int[M][3]; // stores index, arrivalTime, deliveryTime
        for(int i = 0; i < M; i++){
            orders[i] = new int[]{i, arrivalTime[i], deliveryTime[i]};
        }

        Arrays.sort(orders, (a, b) -> a[1] - b[1]); // sort orders on arrivalTime
        PriorityQueue<Integer> deliveryPartners = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            deliveryPartners.add(i);
        }

        PriorityQueue<int[]> onGoingOrders = new PriorityQueue<>((a, b) -> a[1] - b[1]); // stores deliveryPartner, orderCompleteTime
        int[] res = new int[M];
        for(int[] order : orders){
            int orderIndex = order[0];
            int orderArrivalTime = order[1];
            int orderDeliveryTime = order[2];

            while(!onGoingOrders.isEmpty() && onGoingOrders.peek()[1] <= orderArrivalTime){
                   int availableDeliveryPartner = onGoingOrders.poll()[0];
                   deliveryPartners.add(availableDeliveryPartner);
            }

            if(deliveryPartners.isEmpty()){
                res[orderIndex] = -1;
                continue;
            }

            int deliveryPartner = deliveryPartners.poll();
            onGoingOrders.add(new int[]{deliveryPartner, orderArrivalTime+orderDeliveryTime});
            res[orderIndex] = deliveryPartner;
        }

        return res;
    }
}
/*
Question :
A logistics company has decided to create an order assignment service to distribute orders across
delivery partners fairly.

There are N delivery partners indexed from 1 to N, and M orders to be processed.
The i-th order arrives at time arrival[i] and takes delivery Time[i] time to execute.
The service assigns the order to the available delivery partner with the minimum index.
A delivery partner that is assigned the ith order is unavailable from time arrival[i] to arrival[i] + delivery Time[i].
At arrival[i] + deliveryTime[i], the delivery partner is available to deliver a new order
Given N, arrival, and delivery Time for each order, find the index of the delivery partner that delivers it.
If no delivery partners available at the time the orders dropped, and -1 is reported.
If multiple orders arrive at the same time the one with the smaller will be assigned.
 */