package Arrays.LeetCodeMSC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistanceInArrays_LC624 {
    public static void main(String[] args){
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(-2));
        arrays.add(Arrays.asList(-3, -2, 1));
        System.out.println(maxDistance(arrays));
    }
    public static int maxDistance(List<List<Integer>> arrays) {
        int minSoFar = arrays.get(0).get(0);
        int maxSoFar = arrays.get(0).get(arrays.get(0).size() - 1);

        int maxDistance = 0;
        for(int i = 1; i < arrays.size(); i++){
            int minVal = arrays.get(i).get(0);
            int maxVal = arrays.get(i).get(arrays.get(i).size() - 1);

            maxDistance = Math.max(maxDistance, maxSoFar - minVal);
            maxDistance = Math.max(maxDistance, maxVal - minSoFar);

            minSoFar = Math.min(minVal, minSoFar);
            maxSoFar = Math.max(maxVal, maxSoFar);
        }

        return maxDistance;
    }
}
/*
Edge Cases :
{[1,6], [2,4]}
{[-2], [-3,-2,1]}

Keep track of the minimum and maximum elements of the arrays we have seen so far.
Iterate over each array and for each array, calculate two potential distances:
The difference between the maximum so far and the minimum of the current array.
The difference between the minimum so far and the maximum of the current array.
Update the global maximum distance accordingly.
 */