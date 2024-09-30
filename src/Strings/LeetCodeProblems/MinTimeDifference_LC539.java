package Strings.LeetCodeProblems;

import java.util.Arrays;
import java.util.List;

public class MinTimeDifference_LC539 {
    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "00:00");
        System.out.println(findMinDifference(timePoints));
    }
    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];

        for(int i = 0; i < n; i++){
            minutes[i] = convertToMinutes(timePoints.get(i));
        }

        Arrays.sort(minutes);

        int minTimeDifference = 1441;
        for(int i = 1; i < n; i++){
            minTimeDifference = Math.min(minTimeDifference, minutes[i] - minutes[i-1]);
        }
        // because time is actually circular so we need to check first ans last time also
        minTimeDifference = Math.min(minTimeDifference, 1440 - minutes[n-1] + minutes[0]);

        return minTimeDifference;
    }
    public static int convertToMinutes(String time){
        int hours = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int minutes = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');

        return hours * 60 + minutes;
    }
}
