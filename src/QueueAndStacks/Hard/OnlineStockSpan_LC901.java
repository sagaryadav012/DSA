package QueueAndStacks.Hard;

import java.util.Stack;

public class OnlineStockSpan_LC901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
class StockSpanner {
    Stack<int[]> stack;
    int index = 0;
    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new int[]{index++, 100001}); // max price is 10^5 so add 10^5 + 1 to avoid stack empty cases
    }

    public int next(int price) {
        while(!stack.isEmpty() && stack.peek()[1] <= price){
            stack.pop();
        }

        int ans = index - stack.peek()[0];

        stack.push(new int[]{index++, price});

        return ans;
    }
}