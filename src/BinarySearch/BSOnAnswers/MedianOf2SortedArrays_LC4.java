package BinarySearch.BSOnAnswers;

public class MedianOf2SortedArrays_LC4 {
    public static void main(String[] args) {

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);

        int totalLen = len1 + len2;
        int halfLen = totalLen/2;
        int left = 0, right = len1;

        while(left <= right){
            int mid = left + (right - left)/2;
            int partition = halfLen - mid;
            int l1 = mid > 0 ? nums1[mid-1] : Integer.MIN_VALUE;
            int r1 = mid < len1 ? nums1[mid] : Integer.MAX_VALUE;
            int l2 = partition > 0 ? nums2[partition-1] : Integer.MIN_VALUE;
            int r2 = partition < len2 ? nums2[partition] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                int l = Math.max(l1, l2);
                int r = Math.min(r1, r2);
                if(totalLen % 2 == 0) return (double)(l+r)/2;
                else return r;
            }

            if(l1 > r2) right = mid - 1;
            else if(l2 > r1) left = mid + 1;
        }
        return -1;
    }
}
/*
Approach 1 :
-> Given two sorted arrays, so merge two sorted array and find median.
-> TC - O(N) SC - O(N)

Approach 2 :
-> Given two sorted arrays, If we can shift smaller values to left and bigger values to right then it
   is easy to find median. How can shift?
-> Ex -> ar1 = {1,3,4,7,10,12} ar2 = {2,3,6,15}, If merge two array, {1,2,3,3,4,6,7,10,12,15}
    median = 4+6/2 = 5. Observed that total length is 10 so divide sorted array into two partitions like
    p1 = {1,2,3,3,4} and p2 = {6,7,10,12,15}
    median = p1[n-1] + p2[0]/2
-> Given two sorted array, make them two equal partition. so it would be easier to find median.
-> step1 : check given array sorted check ar1[n-1] < ar[0] then it is sorted take median directly.
   step2 : step1 fails then total length =(ar1.length + ar2.length). HalfLength = totalLen/2;
   so partitioned arrays must have length = halfLength.
   Choose values from 0 to halfLen or min of len1,len2 and check are they sorted.
   For example :
   Choose 0 from ar2, and remaining elements(halfLen - chose from ar2) choose them from ar1
   MinVal       2,3,4,15
   1,3,4,7,10   12
   check sorted(max of left side < min of right side) 10 > 2 so not sorted.

   check this -> choose 2 values from ar2, remaining from ar1
   2,3      6,15
   1,3,4    7,10,12
   4 < 6 sorted

-> Observed that we have to choose values from 0 to 5, we know that range so apply binary search on it.
-> The observation is that choose elements from 0 to minLen(len1, len2) and remaining elements are halfLen - chose.
-> Always choose elements from minLen Array because choose range is 0 to minLen(len1, len2)
   Ex : ar1 {3,5} and ar2 {1,2,5,6} If we choose elements from maxLen array, halfLen here is 3.
        choose range here is 0 to 2.
        I choose 0 from ar2 so remaining I have to choose from ar1, halfLen - 0 = 3
        Choose 3 values from ar1 but ar1 len is 2 only it gives OOB exception.

 */