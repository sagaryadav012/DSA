package TwoPointerAndSlidingWindow.Medium;

public class MaxPointsCanObtainFromCards_LC1423 {
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k == 1) return Math.max(cardPoints[0], cardPoints[n-1]);

        int maxScore = 0;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += cardPoints[i];
        }
        maxScore = Math.max(maxScore, sum);
        sum -= cardPoints[k-1];
        int left = k-2;
        int right = n-1;
        while(left >= -1){
            sum += cardPoints[right];
            maxScore = Math.max(maxScore, sum);
            sum -= left < 0 ? 0 : cardPoints[left];
            left--;
            right--;
        }
        return maxScore;
    }
}
