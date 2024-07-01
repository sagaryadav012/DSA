package Graphs.MSTandDisJointSetProblems;

public class RemoveMaxEdges_LC1579 {
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet dsAlice = new DisjointSet(n+1);
        DisjointSet dsBob = new DisjointSet(n+1);

        int edgesNeeded = 0;
        for(int[] edge : edges){
            if(edge[0] == 3){
                if(dsAlice.union(edge[1], edge[2])){ // If all are T3 edges and forms cycle we don't need to count extra edges.
                    dsBob.union(edge[1], edge[2]);
                    edgesNeeded += 1;
                }
            }
        }

        for(int[] edge : edges){
            if(edge[0] == 1){
                if(dsAlice.union(edge[1], edge[2])){
                    edgesNeeded += 1;
                }
            }
        }

        for(int[] edge : edges){
            if(edge[0] == 2){
                if(dsBob.union(edge[1], edge[2])){
                    edgesNeeded += 1;
                }
            }
        }

        if(canTraverse(dsAlice, n) && canTraverse(dsBob, n)){
            return edges.length - edgesNeeded;
        }

        return -1;
    }
    public static boolean canTraverse(DisjointSet ds, int n){
        int parent = ds.findRepresentative(1);

        for(int i = 2; i <= n; i++){
            if(ds.findRepresentative(i) != parent) return false;
        }

        return true;
    }
}
/*
-> First understand question.
-> Alice can traverse through T1 edges, Bob can traverse through T2 edges and Alic,Bob can traverse through T3 edges.
-> Common paths are T3 edges so first take T3 edges, Then we take T1 and T2.
-> We Disjoint set to check cycle.
-> First take count T3 edges and make connection, And if any nodes left as isolated then process T1 and T2.
-> While taking edges we check whether it forms cycle or not, if it forms cycle then it means it is an extra edge.
-> Once all done check Alice can traverse all nodes using disjoint set. If parent of all nodes are same then it means
   it can traverse to all nodes.
-> If Both Alice and Bob can traverse then remove needed edges from all edges, so we get extra edges count.

 */