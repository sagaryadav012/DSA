package QueueAndStacks.MonotonicStack;

public class TrapRainWater_LC42 {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            if (height[i] > leftMax[i - 1]) leftMax[i] = height[i];
            else leftMax[i] = leftMax[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > rightMax[i + 1]) rightMax[i] = height[i];
            else rightMax[i] = rightMax[i + 1];
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftMax[i - 1], rightMax[i + 1]);
            int water = min - height[i];
            if (water > 0) ans += water;
        }

        return ans;
    }
}
/*
-> We have to calculate how much water it stores.
-> We know water will store in rectangle shape, means it has support left and right then only stores water
-> Calculate how much water each bar stores. So find left max height and right max height, take min of them and min * bar width.

Approach 1 :
-> First and last bars won't store water since it doesn't have right and left supports.
-> so store left max height and right max height of each bar to reduce TC.
-> Take min left and right height * bar width.
 */