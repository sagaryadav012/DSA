package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2_LC229 {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0; int count2 = 0;
        int num1 = Integer.MIN_VALUE; int num2 = Integer.MIN_VALUE;

        for(int num : nums){
            if(count1 == 0 && num2 != num){
                count1 = 1;
                num1 = num;
            }
            else if(count2 == 0 && num1 != num){
                count2 = 1;
                num2 = num;
            }
            else if(num1 == num) count1++;
            else if(num2 == num) count2++;
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for(int num : nums){
            if(num1 == num) count1 += 1;
            if(num2 == num) count2 += 1;
        }
        int minTimes = nums.length / 3;
        List<Integer> res = new ArrayList<>();

        if(count1 > minTimes) res.add(num1);
        if(count2 > minTimes) res.add(num2);
        return res;
    }
}
