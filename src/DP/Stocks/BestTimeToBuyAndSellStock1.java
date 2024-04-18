package DP.Stocks;

public class BestTimeToBuyAndSellStock1 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
    }
    public static int maxProfit1(int[] prices) { // TC - O(N^2) SC - O(1)
        int n = prices.length;
        int profit =0;
        for(int i = 0; i < n; i++){ // i = buy_price
            for(int j = i+1; j < n; j++){ // j = sell_price
                if(prices[j] > prices[i]){
                    profit = Math.max(profit, prices[j] - prices[i]);
                }
            }
        }
        return profit;
    }
    public static int maxProfit2(int[] prices) { // TC - O(N) SC - O(1)
        int profit =0;
        int buy_price = prices[0];
        for(int price : prices){
            if(price < buy_price){
                buy_price = price;
                continue;
            }
            profit = Math.max(profit, price - buy_price);

        }
        return profit;
    }
}
/*

-> We have to find maxProfit. choose some day to buy and some day to sell so that we have to get max profit.
-> It's about make only one transaction but should get max profit.

Approach 1 :
-> Take two pointer(i,j). Here i is the buy price and j is sell price. in order to get profit we have to sell at higher price i.e. greater than buy price.
-> So keep i pointer at one price and iterate over prices using j pointer and check which one is greater than buy_price and take max profit.
-> TC - O(N^2) SC - O(1)

Approach 2 :
-> For example we buy at price 8 and next we encounter price 12 so if we sell at 12, we get profit 4.
   And next day price drops to 5, and again it raises to 15. if buy at 5 and sell at 15 we would have get 10 profit.
-> So buy at some price and sell at price > buy_price, store profit. Now keep on iterating over prices,
   If we encounter price < buy_price, then move buy_price pointer to here and check for, sell price again.
-> TC - O(N) SC - O(1)


 */