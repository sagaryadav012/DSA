package Arrays.Medium;

public class CountInversions_GFG {
    static long count = 0;
    static long inversionCount(long arr[], int n) {
        // Your Code Here
        divide(arr, 0, n-1);
        return count;
    }
    static void divide(long[] arr, int s, int e){
        if(s == e) return;
        int m = (s+e)/2;
        divide(arr, s, m);
        divide(arr, m+1, e);
        merge(arr, s, m, e);
    }
    static void merge(long[] arr, int s, int m, int e){
        int p1 = s;
        int p2 = m+1;
        long[] ar = new long[e-s+1];

        int k = 0;
        while(p1 <= m && p2 <= e){
            if(arr[p1] <= arr[p2]){
                ar[k++] = arr[p1++];
            }
            else{
                ar[k++] = arr[p2++];
                count += m - p1 + 1;
            }
        }
        while(p1 <= m){
            ar[k++] = arr[p1];
        }
        while(p2 <= e){
            ar[k++] = arr[p2];
        }

        for(int i = 0; i < ar.length; i++){
            arr[s+i] = ar[i];
        }
    }
}
