package Graphs.MSTandDisJointSetProblems;

public class DisjointSet {
    int[] parentArr;
    DisjointSet(int n){
        parentArr = new int[n+1];

        for(int i = 0; i <= n; i++){
            parentArr[i] = i; // initially each element is individual subset, their representative is itself only.
        }
    }

    public int findRepresentative(int x){
        if(parentArr[x] == x) return x;
        return parentArr[x] = findRepresentative(parentArr[x]); // Path compression, It is to improve speed in future operations.
    }

    public boolean union(int x, int y){
        // step 1 : find representative of x and y.
        // step 2 : If the representatives are different then do union else return false
        int representativeX = findRepresentative(x);
        int representativeY = findRepresentative(y);

        if(representativeX == representativeY) return false;

        if(representativeX < representativeY){
            parentArr[representativeY] = representativeX;
        }else{
            parentArr[representativeX] = representativeY;
        }
        return true;
    }
}
/*
Disjoint helps in
-> Kruskal's algo to find an edge forms cycle or not
-> Cycle in undirected graph
-> No.of connected components(when given edges only)
 */