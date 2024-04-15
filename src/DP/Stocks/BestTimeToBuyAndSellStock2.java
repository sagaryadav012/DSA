package DP.Stocks;

public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
    }
    public static int maxProfit1(int[] prices) { // TC - O(N) SC - O(1)
        int profit = 0;
        int buy_price = prices[0];
        for(int price : prices){
            if(price < buy_price){
                buy_price = price;
                continue;
            }
            profit += price - buy_price;
            buy_price = price;
        }
        return profit;
    }
}
/*
Problem statement : On each day, you may decide to buy and/or sell the stock.
                    You can only hold at most one share of the stock at any time.
                    However, you can buy it then immediately sell it on the same day.

Approach 1 :
-> Take two pointer(i,j). Here i is the buy price and j is sell price. in order to get profit we have to sell at higher price i.e. greater than buy price.
-> So keep i pointer at one price and iterate over prices using j pointer and check which one is greater than buy_price and take max profit.
-> But this approach will fail.
   Example 7,1,5,3,6,4
   We buy at 1 and sell at 6 and got profit 5
   Now i pointer at 3 and j pointer at 6. Can we make this transaction?
   No because we can hold at most one share of stock at any time.
   We buy at 1, again we buy at 3 before it sells. so this approach will not work.

Approach 2(Greedy) :
-> We buy at some price and will sell at price that is greater than buy price in order to get profit right?
-> We can make multiple transactions, but we can hold at most one share stock only.
-> For example we buy at price 5, price raised to 10 if we sell here we get 5 profit,
   if it raised to 15 and sell at 15 we would have get 10 profit. So when to sell?
-> We do like this buy at 5, price raised to 10, we sell at 10, got profit 5.
   And again buy at 10 if it raises to 15, we sell at 15 and got profit 5. total profit 10.
   Or if price falls to 5 then we move our buy_price pointer to here, so if it raises again we will buy there.

   5 ----> 10 ----> 15 = 5 + 5 = 10 profit
   5 ----> 10 -- 4 ----> 14 = 5 + 10 = 15 profit

-> TC - O(N) SC - O(1)

 */
