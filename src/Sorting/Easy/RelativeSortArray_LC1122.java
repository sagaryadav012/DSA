package Sorting.Easy;

import java.util.Arrays;

public class RelativeSortArray_LC1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for(int num : arr1){
            freq[num]++;
        }

        int n = arr1.length;
        int[] res = new int[n];
        int index = 0;
        for(int num : arr2){
            int freqq = freq[num];
            while(freqq > 0){
                res[index++] = num;
                freqq--;
            }
            freq[num] = 0;
        }

        for(int i = 0; i <= 1000; i++){
            int freqq = freq[i];
            while(freqq > 0){
                res[index++] = i;
                freqq--;
            }
            // freq[i] = 0;
        }

        return res;
    }
}
