package Arrays.Hard;

public class ReversePairs_LC493 {
    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};

        System.out.println(reversePairs(nums));
    }
    static int count = 0;
    public static int reversePairs(int[] nums) {
        int n = nums.length;
        divide(nums, 0, n-1);
        return count;
    }
    public static void divide(int[] nums, int s, int e){
        if(s == e) return;
        int m = (s+e)/2;
        divide(nums, s, m);
        divide(nums, m+1, e);
        countPairs(nums, s, m, e);
        merge(nums, s, m, e);
    }
    public static void countPairs(int[] nums, int s, int m, int e){
        int p1 = s, p2 = m+1;
        while(p1 <= m && p2 <= e){
            if(nums[p1] > (2L *nums[p2])){
                count += m - p1 + 1;
                p2++;
            }else p1++;
        }
    }
    public static void merge(int[] nums, int s, int m, int e){
        int[] ar = new int[e-s+1];
        int p1 = s, p2 = m+1;
        int idx = 0;
        while(p1 <= m && p2 <= e){
            if(nums[p1] <= nums[p2]){
                ar[idx++] = nums[p1++];
            }
            else{
                ar[idx++] = nums[p2++];
            }
        }
        while(p1 <= m){
            ar[idx++] = nums[p1++];
        }
        while(p2 <= e){
            ar[idx++] = nums[p2++];
        }
        for(int i = 0; i < ar.length; i++){
            nums[s+i] = ar[i];
        }
    }
}
