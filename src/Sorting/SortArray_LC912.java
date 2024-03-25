package Sorting;

import java.util.Arrays;

public class SortArray_LC912 {
    public static void main(String[] args) {
       int[] nums = {3,10,6,15,8,12,2,18,17};
       mergeSort(nums, 0, nums.length-1);
       System.out.println(Arrays.toString(nums));
    }
    public static void mergeSort(int[] nums, int s, int e){ // TC - O(NlogN) SC - O(N)
        if(s == e) return;
        int m = (s+e)/2;
        mergeSort(nums, s, m);
        mergeSort(nums, m+1, e);
        merge(nums, s, m, e);
    }
    public static void merge(int[] nums, int s ,int m, int e){
        int p1 = s;
        int p2 = m+1;
        int[] mergedArray = new int[e-s+1];
        int idx = 0;
        while(p1 <= m && p2 <= e){
            if(nums[p1] < nums[p2]){
                mergedArray[idx++] = nums[p1++];
            }
            else{
                mergedArray[idx++] = nums[p2++];
            }
        }
        while(p1 <= m){
            mergedArray[idx++] = nums[p1++];
        }
        while(p2 <= e){
            mergedArray[idx++] = nums[p2++];
        }

        for(int i = 0; i < mergedArray.length; i++){
            nums[i + s] = mergedArray[i];
        }
    }
}
