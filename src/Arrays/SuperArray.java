package Arrays;

import java.util.*;

public class SuperArray {
    public static void main(String[] args) {
        int[] A = {7, 9, 9, 9, 2, 3};
        long[] B = {43, 17, 45};
//        System.out.println(Arrays.toString(superArray(A, B)));
        System.out.println(numWaterBottles(9, 3));
    }
    public static int[] superArray(int[] A, long[] B) {
        int n = A.length;
        int m = B.length;

        List<Pair> pairs = new ArrayList<>();

        for(int i = 0; i < n; i++){
            long occurs = (long)(i+1)*(n-i);
            pairs.add(new Pair(A[i], occurs));
        }

        Collections.sort(pairs, (p1, p2) -> p1.num - p2.num);

        // long[] indexRange = new long[n];

        // for(int i = 0; i < n; i++){
        //     indexRange[i] = (i+1) * (n-i);
        // }
        // indexRange[0] -= 1;

        // for(int i = 1; i < n; i++){
        //     indexRange[i] += indexRange[i-1];
        // }

        TreeMap<Long, Integer> map = new TreeMap<>();
        long count = pairs.get(0).occurs - 1;
        map.put(count, pairs.get(0).num);

        for(int i = 1; i < n; i++){
            Pair p = pairs.get(i);
            int num = p.num;
            long occurs = p.occurs;
            count += occurs;
            map.put(count, num);
        }

        int[] res = new int[m];

        for(int i = 0; i < m; i++){
            Long key = map.ceilingKey(B[i]);

            if(key == null) res[i] = -1;
            else res[i] = map.get(key);
        }

        return res;
    }
    public static int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        while(numBottles >= numExchange){
            numBottles = (numBottles - numExchange) + 1;
            count += 1;
        }

        int maxBottles = (numExchange * count) + numBottles;
        return maxBottles;
    }
}
class Pair{
    int num;
    long occurs;
    Pair(int num, long occurs){
        this.num = num;
        this.occurs = occurs;
    }
}
