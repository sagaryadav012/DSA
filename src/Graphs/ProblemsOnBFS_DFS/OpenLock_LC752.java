package Graphs.ProblemsOnBFS_DFS;

import java.util.*;

public class OpenLock_LC752 {
    public static void main(String[] args) {
        String[] deadEnds = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(deadEnds, target));
    }
    public static int openLock(String[] deadends, String target) { // TC - O(10^4 * 4) SC - O(10^4 * 4)
        Set<String> vis = new HashSet<>(Arrays.asList(deadends));
        if(vis.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        vis.add("0000");

        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                String nextLock = queue.poll();
                if(nextLock.equals(target)) return level;

                for(int i = 0; i < 4; i++){
                    char[] lock = nextLock.toCharArray();
                    char c = lock[i];
                    lock[i] = nextClockWiseChar(c);
                    String s1 = new String(lock);
                    lock[i] = nextAntiClockWiseChar(c);
                    String s2 = new String(lock);
                    if(vis.add(s1)) queue.add(s1);
                    if(vis.add(s2)) queue.add(s2);
                }
                size--;
            }
            level += 1;
        }
        return -1;
    }
    public static Character nextClockWiseChar(char c){
        return c == '9' ? '0' : (char)(c+1);
    }
    public static Character nextAntiClockWiseChar(char c){
        return c == '0' ? '9' : (char)(c-1);
    }
}
/*
-> Lock contains 4 wheels, At each we can move any one of the wheel to forward or backward.
-> For example lock "0000"
   Move each wheel in clockWise direction possible outcomes are : 1000, 0100, 0010, 0001.
   Move each wheel in AntiClockWise direction possible outcomes are : 9000, 0900, 0090, 0009.
-> So at each level, we get possible outcomes, some of them could be already computed.
-> It looks like a tree, assume "0000" is root node, child nodes are 8 possible outcomes.
-> Use BFS algo to traverse each node and check if it visited target. if it visited return level.
-> TC -> Lock has 4 wheels at each wheel we have 10 options(0-9), total possible locks are 10^4,
   BFS could traverse at max 10^4 nodes. And String comparison = length of String is 4;
   TC -> 10^4 * 4;
-> SC -> 10^4 * 4; At worst case set can store all possible locks.
 */