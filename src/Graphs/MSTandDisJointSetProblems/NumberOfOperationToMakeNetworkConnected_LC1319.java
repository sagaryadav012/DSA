package Graphs.MSTandDisJointSetProblems;

public class NumberOfOperationToMakeNetworkConnected_LC1319 {
    public static void main(String[] args) {
        int[][] connections = { {0,1}, {0,2}, {0,3}, {1,2}, {1,3}};
        int n = 6;
        System.out.println(makeConnected(n, connections));
    }
    public static int makeConnected(int n, int[][] connections) {
        DisjointSet dsu = new DisjointSet(n-1); // since DSU takes n+1, we given n-1
        int extraEdges = 0;
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            if(!dsu.union(u, v)) extraEdges += 1;
        }

        int connectedComponents = 0;
        int[] parentAr = dsu.parentArr;
        for(int i = 0; i < n; i++){
            if(i == parentAr[i]) connectedComponents += 1;
        }

        // Extra edges required to connect all components are no.of connected components - 1.
        // Here we have to return min no.of edges so min no.of edges are no.of connected components - 1.
        if(extraEdges >= connectedComponents - 1) return connectedComponents - 1;

        return -1;
    }

}
/*
-> We have to count no.of operations to make sure network connected.
-> If there are 3 connected components, then how many edges we need to make all 3 connected ?
   Answer is 2, We need only two edges to connect all 3 components. If the graph has extra edges then
   we can use those edges to connect components.
-> What is an extra edge here? If we remove an edge from graph then the graph still connected to all nodes
   in that particular component.
-> So find extra edges first, then If  we have sufficient extra edge then we can connect all connected components.
-> If there are n connected components then we need n-1 edges to connect all components.
-> To find extra edges, use DSU it helps to find extra edges. Here extra edges are edges that forms cycle in graph.
   DSU helps to find an edges forms cycle or not, If it forms cycle then count += 1;
-> To find no.of connected components, parentAr in DSU helps to find no.of sets or connected components.
 */