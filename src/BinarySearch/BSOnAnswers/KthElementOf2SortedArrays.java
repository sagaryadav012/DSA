package BinarySearch.BSOnAnswers;

public class KthElementOf2SortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {3,8,10,15};
        int[] nums2 = {2,6,9,11};
        int k = 6;
        System.out.println(findKthVal(nums1, nums2, k));
    }
    public static int findKthVal(int[] nums1, int[] nums2, int k) { // TC - O(NlogN) SC - O(1)
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2) return findKthVal(nums2, nums1, k);

        int left = Math.max(0, k-len2), right = Math.min(len1, k);

        while(left <= right){
            int mid = left + (right - left)/2;
            int partition = k - mid;
            int l1 = mid > 0 ? nums1[mid-1] : Integer.MIN_VALUE;
            int r1 = mid < len1 ? nums1[mid] : Integer.MAX_VALUE;
            int l2 = partition > 0 ? nums2[partition-1] : Integer.MIN_VALUE;
            int r2 = partition < len2 ? nums2[partition] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }

            if(l1 > r2) right = mid - 1;
            else if(l2 > r1) left = mid + 1;
        }
        return -1;
    }
}
/*
-> It is almost same as median of two sorted arrays but in that question, we partitioned array at mid
   length so that it would be easy to find median.
-> But here partition array at length of k.
   For example : ar1 {3,8,10,15} ar2 {2,6,9,11} k = 2
   Now partition array at 2 length like
      3     8,10,15
      2     6,9,11
   Above partition is valid, so take max of left side, that is the answer

   Similarly, find k = 6.
   So left side array should have length 6 and right side array have remaining of totalLen.
   Choose range from 0 to 6
   If I choose 0 from ar1 remaining from ar2
   MinValue         3,6,10,15
   2,6,9,11         MaxValue
   Above partition is not valid since It gives IOB Exception, We have to choose 6-0 = 6 but arr2 len is 4 only

   So first figure out left and right bounds. left = Math.max(0, k-len2) right = min(k, len1)

   Chose right based on following criteria :
   We have to find kth value so if Kth value < len1, partition array at len K so can find k easily.
   else if Kth val > len1 partition array at len k but can choose max value from ar1 is len1.
   so right should min of k,len1

   Chose left based on following criteria :
   suppose left is 0, right 6 when k = 6. If I choose 0 from ar1 then need to choose 6 values from ar2
   but ar2 len is 4 only to minimize this left will be min 2, so choose area starts from 2 to 6.
   If I choose 2 from ar1 then 4 from ar2, now its valid.
   So left will be max(k-len2, 0)

-> Once partitioned array then choose max on left side.
 */
