package Sorting.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LexicographicalNumbers_LC386 {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
        System.out.println(lexicalOrder1(n));
    }
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        for(int i = 1; i <= 9; i++){
            dfs(i, n, res);
        }

        return res;
    }
    public static void dfs(int current, int n, List<Integer> res){
        if(current > n) return;

        res.add(current);

        for(int i = 0; i <= 9; i++){
            int next = current * 10 + i;
            if(next > n) break;
            dfs(next, n, res);
        }
    }
    public static List<Integer> lexicalOrder1(int n){
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            res.add(i);
        }

        res.sort((a, b) -> a.toString().compareTo(b.toString()));

        return res;
    }
}
/*
Approach 1 : Use DFS traversal to generate values in lexographical order.
TC - O(N)

Approach 2 : Convert integers to string then use compareTo method to compare strings lexicographically.
TC - O(NlogN)
 */