package QueueAndStacks.MonotonicStack;

public class LargestRectangleInHistogram_LC84 {
    public static void main(String[] args) {
       int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] NLS = new int[n];
        int[] NRS = new int[n];

        NLS[0] = -1;
        NRS[n-1] = n;

        // Find Nearest Left Smaller
        for(int i = 1; i < n; i++){
            int prev = i-1;
            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = NLS[prev];
            }
            NLS[i] = prev;
        }

        // Find Nearest Right Smaller
        for(int i = n-2; i >= 0; i--){
            int right = i+1;
            while(right < n && heights[i] <= heights[right]){
                right = NRS[right];
            }
            NRS[i] = right;
        }
        int ans = -1;
        for(int i = 0; i < n; i++){
            int area = (NRS[i] - NLS[i] - 1)*heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
