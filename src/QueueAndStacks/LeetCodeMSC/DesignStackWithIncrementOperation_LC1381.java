package QueueAndStacks.LeetCodeMSC;

public class DesignStackWithIncrementOperation_LC1381 {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
class CustomStack {
    private int[] stack;
    private int top;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if(top < stack.length - 1){
            stack[++top] = x;
        }
    }

    public int pop() {
        return top > -1 ? stack[top--] : -1;
    }

    public void increment(int k, int val) {
        k = Math.min(k, top+1);
        for(int i = 0; i < k; i++){
            stack[i] += val;
        }
    }
}
