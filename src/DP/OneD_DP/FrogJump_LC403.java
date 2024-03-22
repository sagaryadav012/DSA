package DP.OneD_DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FrogJump_LC403 {
    public static void main(String[] args) {
        FrogJump_LC403 obj = new FrogJump_LC403();
        int[] stones = {0,1,2,3,4,8,9,11};
        System.out.println(obj.canCross(stones));
        System.out.println(obj.canCross1(stones));
    }
    public boolean canCross(int[] stones) { // Given Time Limit Exceeded
        if(stones[1] - stones[0] != 1) return false;
        int n = stones.length;
        Set<Integer> stoneSet = new HashSet<>();
        for(int stone : stones) stoneSet.add(stone);
        return dfs(stones[1], stones[n-1], stoneSet, 1);
    }
    public boolean dfs(int at, int lastStone, Set<Integer> stoneSet, int k){
        if(at == lastStone) return true;
        if(!stoneSet.contains(at)) return false;

        if(at + k - 1 > at)
            if(dfs(at + k - 1, lastStone, stoneSet, k - 1)) return true;
        if(dfs(at + k, lastStone, stoneSet, k)) return true;
        if(dfs(at+k+1, lastStone, stoneSet, k+1)) return true;

        return false;
    }
    public boolean canCross1(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>() ;
        for(int stone : stones){
            map.put(stone, new HashSet<>());
        }
        map.get(stones[0]).add(1);

        for(int stone : stones){
            HashSet<Integer> jumps = map.get(stone);
            for(int jump : jumps){
                int currStone = stone + jump;
                if(currStone == stones[stones.length - 1]) return true;
                if(map.containsKey(currStone)){
                    if(jump - 1 > 0) map.get(currStone).add(jump - 1);
                    map.get(currStone).add(jump);
                    map.get(currStone).add(jump + 1);
                }
            }
        }
        return false;
    }
}

/*
-> Store jumps that a stone can do.
-> To do that take hashmap of int and set. Here set is to avoid same jumps
-> initially we can make one jump. now from 1 we can make jump-1,jump,jump+1.
-> And hashmap, currentStone + jump exists in map, if exists add jumps to that stone.
-> Repeat this process until we reach last stone. if couldn't reach return false.
 */
