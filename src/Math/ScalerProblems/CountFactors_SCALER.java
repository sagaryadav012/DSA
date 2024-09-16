package Math.ScalerProblems;

import java.util.Arrays;

public class CountFactors_SCALER {
    public static void main(String[] args) {
        int[] nums = {8, 9, 10, 36, 100};
        System.out.println(Arrays.toString(countFactors1(nums)));
        System.out.println(Arrays.toString(countFactors2(nums)));
        System.out.println(Arrays.toString(countFactors3(nums)));
    }
    public static int[] countFactors1(int[] nums){ // TC - O(N*N)
        int n = nums.length;
        int[] res = new int[n];
        int index = 0;
        for(int num : nums){
            int count = 0;
            for(int i = 1; i <= num; i++){
                if(num % i == 0) count += 1;
            }
            res[index++] = count;
        }
        return res;
    }
    public static int[] countFactors2(int[] nums){ // TC - O(N* sqrt(N))
        int n = nums.length;
        int[] res = new int[n];
        int index = 0;
        for(int num : nums){
            int count = 0;
            for(int i = 1; i*i <= num; i++){
                if(num % i == 0){
                    count += 2;
                    if(i == num/i) count -= 1;
                }
            }
            res[index++] = count;
        }
        return res;
    }
    public static int[] countFactors3(int[] nums){ // TC - O(max * log(max) + N)
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] factors = new int[max+1];

        for(int i = 1; i <= max; i++){
            for(int j = i; j <= max; j+=i){
                factors[j]++;
            }
        }
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            res[i] = factors[nums[i]];
        }
        return res;
    }

}


/*
Approach 3 :
-> Find factors of num 10
-> Iterate from 1 to 10

   1        2       3       4       5       6       7       8       9       10
   1        1       1       1       1       1       1       1       1       1
            2       3       2       5       2       7       2       3       2
                            4               3               4       9       5
                                            6               8               10

  Find TC :
  i     j                   no.of iterations
  1     multiples of 1      n/1
  2     multiples of 2      n/2
  3     multiples of 3      n/3
  4     multiples of 4      n/4
  5     multiples of 5      n/5
  6     multiples of 6      n/6
  7     multiples of 7      n/7
  8     multiples of 8      n/8
  9     multiples of 9      n/9
  10    multiples of 10      n/10


  TC = n/1 + n/2 + n/3 + n4 + ....... + n/10
     = n(1/1 + 1/2 + 1/3 + ........ + 1/10)
     = n * logN(sum of reciprocal of natural numbers)



 */